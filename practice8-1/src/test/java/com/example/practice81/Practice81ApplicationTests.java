package com.example.practice81;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.support.GenericWebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Practice81Application.class)
class Practice81ApplicationTests {
    @Autowired
    private GenericWebApplicationContext context;

    @Test
    void contextLoads() {
    }

}
