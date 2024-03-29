package com.vilin.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class TestLog4j {

    @Test
    public void testQuick(){

        // 开启 log4j 内置日志记录
        LogLog.setInternalDebugging(true);

        // 初始化配置信息，在入门案例中暂不使用配置文件
        // BasicConfigurator.configure();

        //获取日志记录器对象
        Logger logger = Logger.getLogger(TestLog4j.class);

        //输出日志信息
        logger.info("hello log4j");

        //for(int i = 0; i < 10000; i++) {

            // 日志级别
            logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃并终止运行

            logger.error("error"); // 错误信息，不会影响系统运行
            logger.warn("warn");   // 警告信息，可能会发生问题
            logger.info("info");   // 运行信息，数据连接、网络连接、IO 操作等等
            logger.debug("debug"); // 调试信息，一般在开发中使用，记录程序变量参数传递信息等等

            logger.trace("trace"); // 追踪信息，记录程序所有的流程信息

        //}

        // 再创建一个日志记录器对象
        Logger logger1 = Logger.getLogger(Logger.class);
        logger1.fatal("fatal logger1"); // 严重错误，一般会造成系统崩溃并终止运行
        logger1.error("error logger1"); // 错误信息，不会影响系统运行
        logger1.warn("warn logger1");   // 警告信息，可能会发生问题
        logger1.info("info logger1");   // 运行信息，数据连接、网络连接、IO 操作等等
        logger1.debug("debug logger1"); // 调试信息，一般在开发中使用，记录程序变量参数传递信息等等
        logger1.trace("trace logger1"); // 追踪信息，记录程序所有的流程信息
    }
}
