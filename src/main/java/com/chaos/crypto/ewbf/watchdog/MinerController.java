package com.chaos.crypto.ewbf.watchdog;

import com.chaos.crypto.ewbf.watchdog.checker.MinerChecker;
import com.chaos.crypto.ewbf.watchdog.config.MinerControllerConfig;
import com.chaos.crypto.ewbf.watchdog.service.MinerService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class MinerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinerController.class);

    private List<MinerChecker> minerCheckers;

    @Autowired
    private MinerService minerService;

    @Autowired
    private MinerControllerConfig config;

    public List<MinerChecker> getMinerCheckers() {
        return minerCheckers;
    }

    @Autowired
    public void setMinerCheckers(List<MinerChecker> minerCheckers) {
        minerCheckers.sort(Comparator.comparingInt(MinerChecker::getOrder));
        this.minerCheckers = minerCheckers;
    }

    /**
     * Will never return
     */
    public void startMining() {
        while (true) {
            try {
                LOGGER.info("Starting/restarting mining process");
                minerService.restartMinerProcess();
                startCheckingForAnyIssues();
            } catch (Throwable e) {
                LOGGER.error("Unexpected error", e);
            } finally {
                try {
                    LOGGER.warn("Stopping mining process");
                    minerService.stopMinerProcess();
                } catch (Exception e) {
                    LOGGER.error("Unexpected error during finalizing restart", e);
                } finally {
                    sleep(config.getRestartDelayInSec() * 1000);
                }
            }
        }
    }

    /**
     * Will return if restart is required
     */
    private void startCheckingForAnyIssues() {
        for (MinerChecker minerChecker : minerCheckers) {
            minerChecker.resetState();
        }

        while (true) {
            LOGGER.info("Start checking for any issues");
            for (MinerChecker minerChecker : minerCheckers) {
                LOGGER.info("___________{}. Start checking___________", minerChecker.getName());
                try {
                    String detectedIssue = minerChecker.detectIssue();
                    if (detectedIssue == null) {
                        LOGGER.info("{}. Didn't find any issues. All OK", minerChecker.getName());
                    } else {
                        LOGGER.error("{}. Restarting since issue detected: {}", minerChecker.getName(), detectedIssue);
                        return;
                    }
                } catch (Exception e) {
                    LOGGER.error("{}. Restarting since unexpected error", minerChecker.getName(), e);
                    return;
                }
            }
            LOGGER.info("Finished checking for any issues. All OK\n");
            sleep(config.getIssueDetectorFrequencyInSec() * 1000);
        }
    }

    @SneakyThrows
    private void sleep(long ms) {
        LOGGER.info("Sleeping for: {} ms", ms);
        Thread.sleep(ms);
    }
}
