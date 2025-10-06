package com.cs79_1.interactive_dashboard.DTO.Simulation;

public class PredictionResultDTO {
    String classification;
    double probability;

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
