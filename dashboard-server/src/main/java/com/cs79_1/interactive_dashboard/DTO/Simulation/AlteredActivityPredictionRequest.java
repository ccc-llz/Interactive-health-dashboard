package com.cs79_1.interactive_dashboard.DTO.Simulation;

import java.util.HashMap;
import java.util.Map;

public class AlteredActivityPredictionRequest {
    long userId;
    boolean isWeekdays;
    Map<Integer, Double> mvpa;
    Map<Integer, Double> light;

    public AlteredActivityPredictionRequest(long userId, boolean isWeekdays) {
        mvpa = new HashMap<>();
        light = new HashMap<>();
        this.userId = userId;
        this.isWeekdays = isWeekdays;
    }

    public void addMVPA(int startingHourIndex, double scale) {
        mvpa.put(startingHourIndex, scale);
    }

    public void addLight(int startingHourIndex, double scale) {
        light.put(startingHourIndex, scale);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isWeekdays() {
        return isWeekdays;
    }

    public void setWeekdays(boolean weekdays) {
        isWeekdays = weekdays;
    }

    public Map<Integer, Double> getMvpa() {
        return mvpa;
    }

    public void setMvpa(Map<Integer, Double> mvpa) {
        this.mvpa = mvpa;
    }

    public Map<Integer, Double> getLight() {
        return light;
    }

    public void setLight(Map<Integer, Double> light) {
        this.light = light;
    }
}
