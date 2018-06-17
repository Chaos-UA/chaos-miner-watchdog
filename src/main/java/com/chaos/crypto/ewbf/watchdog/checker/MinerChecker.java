package com.chaos.crypto.ewbf.watchdog.checker;

import java.util.Optional;

public interface MinerChecker {

    /**
     * @return unique checker name
     */
    String getName();

    /**
     * @return string with issue description if an issue were detected
     */
    String detectIssue();

    int getOrder();

    default void resetState() {}
}
