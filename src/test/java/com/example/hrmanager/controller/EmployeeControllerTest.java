package com.example.hrmanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHelloWorld3() throws Exception {
        mockMvc.perform(get("/api/test")) // Perform a GET request to the endpoint
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(content().string("Hallo World3!!")); // Expect the correct response content
    }

}