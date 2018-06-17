package com.chaos.crypto.ewbf.watchdog.config;

import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Builder
public class MinerControllerConfig {

    @NonNull
    private final Integer issueDetectorFrequencyInSec;

    @NonNull
    private final Integer restartDelayInSec;

    @NonNull
    private final Integer maxSharesDelayInSec;

    @NonNull
    private final Boolean ignoreMinerKillFailure;
}
