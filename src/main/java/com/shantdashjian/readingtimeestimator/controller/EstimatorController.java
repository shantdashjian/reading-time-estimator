package com.shantdashjian.readingtimeestimator.controller;

import com.shantdashjian.readingtimeestimator.model.Estimate;
import com.shantdashjian.readingtimeestimator.service.EstimatorService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstimatorController {

    EstimatorService service;

    public EstimatorController(EstimatorService service) {
        this.service = service;
    }

    @PostMapping("/estimate")
    public Estimate calculateEstimate(@io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            examples = {
            @ExampleObject(value = "{\"text\": \"two words\",\"wpm\": 1,\"estimate\": 0}")
    }) }) @RequestBody Estimate estimate) {
        return service.calculateEstimate(estimate);
    }
}
