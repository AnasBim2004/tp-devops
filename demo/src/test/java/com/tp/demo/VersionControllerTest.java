package com.tp.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// IMPORTANT: This is the new import for Spring Boot 4+
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void versionShouldReturnCorrectVersion() throws Exception {
        mockMvc.perform(get("/version"))
               .andExpect(status().isOk())
               .andExpect(content().string("1.0.0"));
    }
}