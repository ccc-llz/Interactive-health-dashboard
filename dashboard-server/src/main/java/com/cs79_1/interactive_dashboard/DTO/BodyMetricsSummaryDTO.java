package com.cs79_1.interactive_dashboard.DTO;

import com.cs79_1.interactive_dashboard.Enum.HFZClassification;

public class BodyMetricsSummaryDTO {
    double height;
    double weight;
    double waistSize;
    double bmi;
    HFZClassification classification;

    public BodyMetricsSummaryDTO() {

    }

    public BodyMetricsSummaryDTO(double height, double weight, double waistSize, double bmi, HFZClassification classification) {
        this.height = height;
        this.weight = weight;
        this.waistSize = waistSize;
        this.bmi = bmi;
        this.classification = classification;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(double waistSize) {
        this.waistSize = waistSize;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public HFZClassification getClassification() {
        return classification;
    }

    public void setClassification(HFZClassification classification) {
        this.classification = classification;
    }
}
