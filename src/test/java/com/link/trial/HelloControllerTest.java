package com.link.trial;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.link.trial.controller.HelloController;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHelloWithPathVariable() throws Exception {
        mockMvc.perform(get("/api/hello/Ali"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, Ali!"));
    }
}