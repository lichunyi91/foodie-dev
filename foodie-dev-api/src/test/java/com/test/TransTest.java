package com.test;

import com.imooc.Application;
import com.imooc.service.StuService;
import com.imooc.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private TestTransService testTransService;

    @Autowired
    private StuService stuService;

//    @Test
    public void myTest() {
        testTransService.testPropagationTrans();
    }
}
