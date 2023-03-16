package com.edunavarro.springboot.h2.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import com.edunavarro.springboot.h2.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
        @Sql(value = "classpath:db/reset.sql", executionPhase = BEFORE_TEST_METHOD)
})
class UserControllerTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenANewUserShouldCreateAUser() throws Exception {
        
        assertThat(repository.findAll()).hasSize(0);

        mockMvc.perform(post("/v1/user/add").contentType(APPLICATION_JSON)
                .content("{\"id\":2,\"name\":\"Pepe\"}"));

        
        assertThat(repository.findAll()).hasSize(1);
    }

}