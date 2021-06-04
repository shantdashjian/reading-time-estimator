package com.shantdashjian.readingtimeestimator.model;

public class Estimate {

    private String text;
    private Integer wpm;
    private Integer estimate;

    public Estimate(String text, Integer wpm) {
        this.text = text;
        this.wpm = wpm;
    }

    public Estimate() {
    }

    public Estimate(String text, Integer wpm, Integer estimate) {
        this.text = text;
        this.wpm = wpm;
        this.estimate = estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getWpm() {
        return wpm;
    }

    public void setWpm(Integer wpm) {
        this.wpm = wpm;
    }


    public Integer getEstimate() {
        return estimate;
    }

    @Override
    public String toString() {
        return "Estimate{" +
                "text='" + text + '\'' +
                ", wpm=" + wpm +
                ", estimate=" + estimate +
                '}';
    }
}
