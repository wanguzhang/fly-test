package com.fly.test.module.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;


/**
 * @author 张攀钦
 * @date 2019-12-17-14:17
 * @description
 */
@WebMvcTest(ExceptionController.class)
class ExceptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void exception2() throws Exception {
        String exception = "exception";
        ResultMatcher xxServerError = MockMvcResultMatchers.status().is5xxServerError();
        mockMvc.perform(MockMvcRequestBuilders.get("/exception").param("exception", exception))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(5000));
    }

    @Test
    void exception() throws Exception {
        String exception = "exception1";
        mockMvc.perform(MockMvcRequestBuilders.get("/exception").param("exception", exception))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(exception));
    }
}