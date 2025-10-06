package com.cs79_1.interactive_dashboard.DTO.Simulation;

public class PredictionRequestDTO {
    boolean isWeekend = false;
    int[] mvpa = new int[24];
    int[] light = new int[24];

    public PredictionRequestDTO() {}

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public int[] getMvpa() {
        return mvpa;
    }

    public void setMvpa(int[] mvpa) {
        this.mvpa = mvpa;
    }

    public int[] getLight() {
        return light;
    }

    public void setLight(int[] light) {
        this.light = light;
    }
}
