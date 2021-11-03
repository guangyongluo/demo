package com.vilin.logback.slf4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {

    private static final Logger LOGGER = Logger.getLogger(TestLog4j.class);

    @Test
    public void testLog4j(){
        LOGGER.info("Hello log4j");
    }

}
