package com.shantdashjian.readingtimeestimator.service;

import com.shantdashjian.readingtimeestimator.model.Estimate;
import org.springframework.stereotype.Service;

@Service
public class EstimatorService {

    public Estimate calculateEstimate(Estimate estimate) {
        String[] words = estimate.getText().split(" ");
        estimate.setEstimate((int) Math.ceil((double)words.length / estimate.getWpm()));
        return estimate;
    }
}
