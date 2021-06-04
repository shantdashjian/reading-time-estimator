package com.shantdashjian.readingtimeestimator;

import com.shantdashjian.readingtimeestimator.model.Estimate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReadingTimeEstimatorIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testEstimator_returns_estimate_1_when_I_send_text_two_words_and_wpm_106() {
        // arrange
        String text = "Two words";
        int wpm = 106;
        Estimate estimate = new Estimate(text, wpm);

        // act
        ResponseEntity<Estimate> result = restTemplate.postForEntity("http://localhost:" + port + "/estimate", estimate,
                Estimate.class);

        // assess
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getEstimate()).isEqualTo(1);

    }
}
