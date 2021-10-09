package com.vilin.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLog4j2 {

    // 定义日志记录器对象
    public static final Logger LOGGER = LogManager.getLogger(TestLog4j2.class);

    @Test
    public void testQuick(){
        // 日志消息输出
        LOGGER.fatal("fatal");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("inf");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
