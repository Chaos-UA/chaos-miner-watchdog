package com.chaos.crypto.ewbf.watchdog.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.io.File;

@Getter
@ToString
@Builder
public class MinerConfig {

    @NonNull
    private final File executableFile;

    @NonNull
    private final String processName;

    @NonNull
    private final String baseApiUrl;

    public String getStatsUrl() {
        return baseApiUrl + "/getstat";
    }

}
