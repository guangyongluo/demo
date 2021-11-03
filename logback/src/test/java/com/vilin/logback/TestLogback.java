package com.vilin.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogback.class);

    @Test
    public void testQuick() {
        //日志输出

        for (int i = 0; i < 10000; i++) {
            LOGGER.error("error");
            LOGGER.warn("warn");
            LOGGER.info("info");
            LOGGER.debug("debug");
            LOGGER.trace("trace");
        }
    }
}
