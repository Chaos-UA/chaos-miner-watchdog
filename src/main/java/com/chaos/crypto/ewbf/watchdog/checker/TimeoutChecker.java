package com.chaos.crypto.ewbf.watchdog.checker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

@Component
public class TimeoutChecker implements MinerChecker {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutChecker.class);

    private long timeoutToRestartInMs;

    private long minerStartedAt;

    public TimeoutChecker(@Value("${healthChecker.timeoutToRestartMinerInMin}") int timeoutToRestartInMin) {
        timeoutToRestartInMs = TimeUnit.MINUTES.toMillis(timeoutToRestartInMin);
    }

    @Override
    public String getName() {
        return "Timeout checker";
    }

    @Override
    public String detectIssue() {
        long currentTime = System.currentTimeMillis();
        long diff = currentTime - minerStartedAt;
        LOGGER.info(
                "{}. {} of {} minutes to restart",
                getName(), DECIMAL_FORMAT.format(diff / 1000D / 60), DECIMAL_FORMAT.format(timeoutToRestartInMs / 1000D / 60)
        );
        if (diff >= timeoutToRestartInMs) {
            return "Timeout reached";
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void resetState() {
        minerStartedAt = System.currentTimeMillis();
    }
}
