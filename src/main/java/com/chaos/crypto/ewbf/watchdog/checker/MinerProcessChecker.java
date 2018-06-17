package com.chaos.crypto.ewbf.watchdog.checker;

import com.chaos.crypto.ewbf.watchdog.service.MinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MinerProcessChecker implements MinerChecker {

    @Autowired
    private MinerService minerService;

    @Override
    public String getName() {
        return "Miner process checker";
    }

    @Override
    public String detectIssue() {
        return minerService.isMinerProcessExist() ? null : String.format("Process '%s' doesn't exist", minerService.getMinerConfig().getProcessName());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
