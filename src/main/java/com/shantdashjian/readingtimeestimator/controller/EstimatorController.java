package com.shantdashjian.readingtimeestimator.controller;

import com.shantdashjian.readingtimeestimator.model.Estimate;
import com.shantdashjian.readingtimeestimator.service.EstimatorService;
import org.springframework.http.ResponseEntity;
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
    public Estimate calculateEstimate(@RequestBody Estimate estimate) {
        return service.calculateEstimate(estimate);
    }
}
