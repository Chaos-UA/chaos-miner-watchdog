package com.chaos.crypto.ewbf.watchdog.checker;

import com.chaos.crypto.ewbf.watchdog.config.MinerControllerConfig;
import com.chaos.crypto.ewbf.watchdog.service.MinerService;
import com.chaos.crypto.ewbf.watchdog.service.MinerStatsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ConditionalOnProperty(value = "healthChecker.miner.ewbf.api.enabled", havingValue = "true")
@Component
public class MinerApiChecker implements MinerChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinerApiChecker.class);

    @Autowired
    private MinerService minerService;

    @Autowired
    private MinerControllerConfig config;

    /**
     * Key is gpu id
     */
    private Map<Integer, GpuSharesInfo> gpuStatsMap;

    @Override
    public String getName() {
        return "Miner API checker";
    }

    @Override
    public String detectIssue() {
        MinerStatsDto minerStats = minerService.getStats();
        LOGGER.debug("Received stats from API: " + minerStats);

        Validate.isTrue(minerStats.getError() == null, minerStats.getError());

        for (MinerStatsDto.GpuStats gpuStats : minerStats.getResult()) {
            GpuSharesInfo currentSharesInfo = new GpuSharesInfo.GpuSharesInfoBuilder()
                    .acceptedShares(gpuStats.getAcceptedShares())
                    .rejectedShares(gpuStats.getRejectedShares())
                    .lastModifiedDate(new Date())
                    .build();
            GpuSharesInfo previousSharesInfo = gpuStatsMap.computeIfAbsent(gpuStats.getGpuId(), (gpuId) -> currentSharesInfo);
            if (currentSharesInfo.getAcceptedShares().equals(previousSharesInfo.getAcceptedShares())
                    && currentSharesInfo.getRejectedShares().equals(previousSharesInfo.getRejectedShares())) {
                LOGGER.warn(
                        "GPU{} didn't update shares. Current date: {}, previous date: {}",
                        gpuStats.getGpuId(), currentSharesInfo.getLastModifiedDate(), previousSharesInfo.getLastModifiedDate()
                );

                long timeDiff = currentSharesInfo.getLastModifiedDate().getTime() - previousSharesInfo.getLastModifiedDate().getTime();

                if (timeDiff > config.getMaxSharesDelayInSec() * 1000) {
                    return String.format(
                            "GPU%s didn't update shares for %s seconds, while max allowed is %s seconds",
                            gpuStats.getGpuId(), timeDiff / 1000D, config.getMaxSharesDelayInSec()
                    );
                }
            } else {
                gpuStatsMap.put(gpuStats.getGpuId(), currentSharesInfo);
            }
        }

        return null;
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void resetState() {
        gpuStatsMap = new HashMap<>();
    }

    @Getter
    @Setter
    @ToString
    @Builder
    private static class GpuSharesInfo {
        private Integer acceptedShares;
        private Integer rejectedShares;
        private Date lastModifiedDate;
    }
}
