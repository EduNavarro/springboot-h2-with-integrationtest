package com.edunavarro.springboot.h2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edunavarro.springboot.h2.controller.UserController;

@SpringBootTest
public class WebApplicationTest {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        Assertions.assertThat(userController).isNotNull();
    }
}
