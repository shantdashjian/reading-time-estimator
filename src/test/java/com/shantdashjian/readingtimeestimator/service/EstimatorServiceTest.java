package com.shantdashjian.readingtimeestimator.service;

import com.shantdashjian.readingtimeestimator.model.Estimate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EstimatorServiceTest {

    EstimatorService service;

    public EstimatorServiceTest() {
        this.service = new EstimatorService();
    }


    @Test
    void returns_estimate_1_when_posting_text_Two_words_and_wpm_106() throws Exception {
        // arrange
        String text = "Two words";
        Integer wpm = 106;
        Integer estimate = 0;
        Estimate estimateObject = new Estimate(text, wpm, estimate);

        // act
        Estimate result = service.calculateEstimate(estimateObject);

        // assess
        assertThat(result.getEstimate()).isEqualTo(1);
    }

    @Test
    void returns_estimate_2_when_posting_text_Two_words_and_wpm_1() throws Exception {
        // arrange
        String text = "Two words";
        Integer wpm = 1;
        Integer estimate = 0;
        Estimate estimateObject = new Estimate(text, wpm, estimate);

        // act
        Estimate result = service.calculateEstimate(estimateObject);

        // assess
        assertThat(result.getEstimate()).isEqualTo(2);
    }

    @Test
    void returns_estimate_1_when_posting_text_Two_words() throws Exception {
        // arrange
        String text = "Two words";
        Estimate estimateObject = new Estimate(text);

        // act
        Estimate result = service.calculateEstimate(estimateObject);

        // assess
        assertThat(result.getEstimate()).isEqualTo(1);
    }
}