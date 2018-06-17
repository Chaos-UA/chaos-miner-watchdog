package com.chaos.crypto.ewbf.watchdog.service;

import lombok.SneakyThrows;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ProcessService {

    public boolean isProcessRunning(String processName) {
        try {
            processName = processName.trim().toLowerCase();
            Process p = Runtime.getRuntime().exec("tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (line.contains(processName)) {
                    return true;
                }
            }

            return false;
        }
        catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @SneakyThrows
    public void killAllProcesses(String processName) {
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        defaultExecutor.setExitValues(null);
        defaultExecutor.execute(CommandLine.parse("taskkill /F /T /IM '" + processName + "'"));
        // defaultExecutor.executeAndGetNext(CommandLine.parse("taskkill /F /IM " + processName), AVOID_EXECUTE_RESULT);
    }
}
