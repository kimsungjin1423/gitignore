package com.tj.edu.practice4.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("helloWorld-GET HTTP Method 성공테스트")
    @Test
    public void helloWorldSuccess() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld1"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError())
//                .andExpect(content().string(""));

        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello-world"));
    }

    @DisplayName("helloWorld-GET HTTP Method 오류테스트")
    @Test
    public void helloWorldFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld1"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(""));

//        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello-world"));
    }


}