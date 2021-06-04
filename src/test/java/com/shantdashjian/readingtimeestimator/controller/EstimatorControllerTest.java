package com.shantdashjian.readingtimeestimator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shantdashjian.readingtimeestimator.model.Estimate;
import com.shantdashjian.readingtimeestimator.service.EstimatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EstimatorController.class)
public class EstimatorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EstimatorService service;

    @Test
    void returns_estimate_1_when_posting_text_Two_words_and_wpm_106() throws Exception {
        // arrange
        String text = "Two words";
        Integer wpm = 106;
        Integer estimate = 0;
        Estimate estimateObject = new Estimate(text, wpm, estimate);

        when(service.calculateEstimate(any(Estimate.class))).thenReturn(new Estimate(text, wpm, 1));

        // act
        mockMvc.perform(post("/estimate")
                .content(asJsonString(estimateObject))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.estimate").value("1"));
        // assess
        verify(service, times(1)).calculateEstimate(any(Estimate.class));
    }

    private static String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
