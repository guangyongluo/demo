package com.vilin.jcl.log;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class TestJUL {

    @Test
    public void testQuick() {
        //1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.vilin.demo.log.TestJUL");
        //2.日志记录输出
        logger.info("hello world");

        //3.通用的日志输出方法
        logger.log(Level.INFO, "hello");

        //4.通过站位符来传递参数
        String username = "张三";
        int age = 21;
        logger.log(Level.INFO, "用户信息 => 姓名:{0}, 年龄:{1}", new Object[]{username, age});
    }

    @Test
    public void testLogLevel() {
        //1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.vilin.demo.log.TestJUL");

        //2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }

    @Test
    public void testLogConfig() throws IOException {
        //1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.vilin.demo.log.TestJUL");

        //2.关闭系统默认log级别
        logger.setUseParentHandlers(false);

        //3.自定义输出级别，创建consoleHandler，向控制台输出日志
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //4.创建简单格式化器
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //5.对象间的关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        //6.设置自定义日志级别
        logger.setLevel(Level.FINEST);
        consoleHandler.setLevel(Level.FINEST);

        File file = new File("logs/jul.log");
        if(!file.exists()){
            System.out.println(file.getParentFile());
            System.out.println(file.getCanonicalPath());
        }

        FileHandler fileHandler = new FileHandler(file.getAbsolutePath());
        fileHandler.setFormatter(simpleFormatter);

        logger.addHandler(fileHandler);

        //7.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogParent(){
        Logger logger1 = Logger.getLogger("com.vilin.demo");
        Logger logger2 = Logger.getLogger("com");

        System.out.println("logger1 parent : " + logger1.getParent() + " and parent name is " + logger1.getParent().getName());
        System.out.println("logger2 parent : " + logger2.getParent() + " and parent name is " + logger2.getParent().getName());

        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger1.addHandler(consoleHandler);
        logger1.setLevel(Level.FINEST);
        consoleHandler.setLevel(Level.FINEST);

        logger2.severe("severe");
        logger2.warning("warning");
        logger2.info("info");
        logger2.config("config");
        logger2.fine("fine");
        logger2.finer("finer");
        logger2.finest("finest");
    }

    @Test
    public void testLogProperties() throws IOException {
        //通过类加载器，读取配置文件
        InputStream resourceAsStream = TestJUL.class.getClassLoader().getResourceAsStream("logging.properties");
        //创建LogManager
        LogManager logManager = LogManager.getLogManager();
        //通过LogManager加载配置文件
        logManager.readConfiguration(resourceAsStream);

        //创建日志记录器
        Logger logger = Logger.getLogger("com.vilin");
        logger.setLevel(Level.ALL);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}
