package com.chaos.crypto.ewbf.watchdog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

@Configuration
public class AppConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public MinerControllerConfig minerCheckerConfig(
            @Value("${healthChecker.checkingFrequencyInSec}") int issueDetectorFrequencyInSec,
            @Value("${minerController.restartDelayInSec}") int restartDelayInSec,
            @Value("${minerController.ignoreMinerKillFailure}") boolean ignoreMinerKillFailure,
            @Value("${healthChecker.miner.ewbf.api.sharesChecker.maxSharesDelayInSec}") int maxSharesDelayInSec) {
        MinerControllerConfig result = new MinerControllerConfig.MinerControllerConfigBuilder()
                .issueDetectorFrequencyInSec(issueDetectorFrequencyInSec)
                .restartDelayInSec(restartDelayInSec)
                .maxSharesDelayInSec(maxSharesDelayInSec)
                .ignoreMinerKillFailure(ignoreMinerKillFailure)
                .build();
        LOGGER.info("Using the following 'MinerControllerConfig' properties: " + result);
        return result;
    }

    @Bean
    public MinerConfig minerConfig(
            @Value("${miner.executableFile}") String executableFile,
            @Value("${healthChecker.miner.ewbf.api.baseApiUrl}") String baseApiUrl,
            @Value("${healthChecker.minerProcessName}") String processName) {
        MinerConfig result = new MinerConfig.MinerConfigBuilder()
                .executableFile(new File(executableFile))
                .baseApiUrl(baseApiUrl)
                .processName(processName)
                .build();
        LOGGER.info("Using the following 'MinerConfig' properties: " + result);
        return result;
    }
}
