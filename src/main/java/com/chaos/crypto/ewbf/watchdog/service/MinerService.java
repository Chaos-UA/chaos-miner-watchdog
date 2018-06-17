package com.chaos.crypto.ewbf.watchdog.service;

import com.chaos.crypto.ewbf.watchdog.config.AppConfiguration;
import com.chaos.crypto.ewbf.watchdog.config.MinerConfig;
import com.chaos.crypto.ewbf.watchdog.config.MinerControllerConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MinerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinerService.class);

    @Getter
    @Setter
    @Autowired
    private MinerConfig minerConfig;

    @Autowired
    @Getter
    @Setter
    private MinerControllerConfig minerControllerConfig;

    @Autowired
    private ProcessService processService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public boolean isMinerProcessExist() {
        return processService.isProcessRunning(minerConfig.getProcessName());
    }

    public void stopMinerProcess() {
        processService.killAllProcesses(minerConfig.getProcessName());
        //processService.killAllProcesses("cmd.exe");
    }

    @SneakyThrows
    public void startMinerProcess() {
        if (isMinerProcessExist() && !minerControllerConfig.getIgnoreMinerKillFailure()) {
            throw new RuntimeException("Miner process already exists");
        }

        DefaultExecutor executor = new DefaultExecutor();
        executor.setWorkingDirectory(minerConfig.getExecutableFile().getParentFile().getAbsoluteFile());
        executor.setProcessDestroyer(new ShutdownHookProcessDestroyer());
        executor.setWatchdog(new ExecuteWatchdog(ExecuteWatchdog.INFINITE_TIMEOUT));

        String cmd = "start " + minerConfig.getExecutableFile();
        LOGGER.info(cmd);
        Process process = new ProcessBuilder()
                .directory(minerConfig.getExecutableFile().getParentFile().getAbsoluteFile())
                .command("cmd", "/c " + cmd)
                .start();

        Thread.sleep(3000);

        process.destroy();
        if (process.isAlive()) {
            throw new RuntimeException("Can't destroy hidden CMD");
        }

        if (!isMinerProcessExist()) {
            throw new RuntimeException("Failed to start miner process");
        }
    }

    public void restartMinerProcess() {
        stopMinerProcess();
        startMinerProcess();
    }

    @SneakyThrows
    public MinerStatsDto getStats() {
        ResponseEntity<String> response = restTemplate.getForEntity(minerConfig.getStatsUrl(), String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Invalid response status code: " + response.getStatusCode());
        }

        MinerStatsDto result = objectMapper.readValue(response.getBody(), MinerStatsDto.class);

        return result;
    }
}
