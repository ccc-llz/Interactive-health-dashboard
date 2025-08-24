package com.cs79_1.interactive_dashboard.Enum;

public enum WeightClassification {
    Normal("Normal"),
    Surpoids("Surpoids"),
    Obese("Obese"),
    Maigre("Maigre");

    private String description;

    WeightClassification(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
