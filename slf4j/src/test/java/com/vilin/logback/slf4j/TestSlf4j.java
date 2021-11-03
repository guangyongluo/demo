package com.vilin.logback.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4j {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSlf4j.class);

    @Test
    public void testQuick(){
        //日志输出
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        String name = "Leo";
        int age = 37;
        //使用占位符来输出日志信息
        LOGGER.info("用户：{}, 年龄：{}", name, age);

        //将系统异常信息输出
        try {
            int i = 1 / 0;
        }catch (Exception e){
            LOGGER.error("异常信息：", e);
        }
    }
}
