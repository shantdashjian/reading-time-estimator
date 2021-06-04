package com.shantdashjian.readingtimeestimator.model;

public class Estimate {

    private static final Integer DEFAULT_WPM = 106;

    private String text;
    private Integer wpm;
    private Integer estimate;

    public Estimate(String text, Integer wpm) {
        this.text = text;
        this.wpm = wpm;
    }

    public Estimate() {
        wpm = DEFAULT_WPM;
    }

    public Estimate(String text, Integer wpm, Integer estimate) {
        this.text = text;
        this.wpm = wpm;
        this.estimate = estimate;
    }

    public Estimate(String text) {
        this.text = text;
        this.wpm = DEFAULT_WPM;
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
        if (wpm != null) {
            this.wpm = wpm;
        }
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
