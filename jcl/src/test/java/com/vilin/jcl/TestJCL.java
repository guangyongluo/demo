package com.vilin.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestJCL {

    @Test
    public void testQuick(){
        Log log = LogFactory.getLog(TestJCL.class);
        log.info("hello JCL");
    }
}
