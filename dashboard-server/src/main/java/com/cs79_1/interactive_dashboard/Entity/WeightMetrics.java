package com.cs79_1.interactive_dashboard.Entity;

import com.cs79_1.interactive_dashboard.Enum.WeightClassification;
import jakarta.persistence.*;

@Entity
public class WeightMetrics {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private double iotfL;

    @Column(nullable = false)
    private double iotfM;

    @Column(nullable = false)
    private double iotfS;

    @Column(nullable = false)
    private double iotfZ;

    @Column(nullable = false)
    private double iotfPercentile;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private WeightClassification iotfClassification;

    @Column(nullable = false)
    private double cacheraL;

    @Column(nullable = false)
    private double cacheraM;

    @Column(nullable = false)
    private double cacheraS;

    @Column(nullable = false)
    private double cacheraZ;

    @Column(nullable = false)
    private double cacheraPercentile;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private WeightClassification cacheraClassification;

    @Column(nullable = false)
    private double omsL;

    @Column(nullable = false)
    private double omsM;

    @Column(nullable = false)
    private double omsS;

    @Column(nullable = false)
    private double omsZ;

    @Column(nullable = false)
    private double omsPercentile;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private WeightClassification omsClassification;

    @Column(nullable = false)
    private double cdcL;

    @Column(nullable = false)
    private double cdcM;

    @Column(nullable = false)
    private double cdcS;

    @Column(nullable = false)
    private double cdcZ;

    @Column(nullable = false)
    private double cdcPercentile;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private WeightClassification cdcClassification;

    public WeightMetrics() {}

    public WeightMetrics(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getIotfL() {
        return iotfL;
    }

    public void setIotfL(double iotfL) {
        this.iotfL = iotfL;
    }

    public double getIotfM() {
        return iotfM;
    }

    public void setIotfM(double iotfM) {
        this.iotfM = iotfM;
    }

    public double getIotfS() {
        return iotfS;
    }

    public void setIotfS(double iotfS) {
        this.iotfS = iotfS;
    }

    public double getIotfZ() {
        return iotfZ;
    }

    public void setIotfZ(double iotfZ) {
        this.iotfZ = iotfZ;
    }

    public double getIotfPercentile() {
        return iotfPercentile;
    }

    public void setIotfPercentile(double iotfPercentile) {
        this.iotfPercentile = iotfPercentile;
    }

    public WeightClassification getIotfClassification() {
        return iotfClassification;
    }

    public void setIotfClassification(WeightClassification iotfClassification) {
        this.iotfClassification = iotfClassification;
    }

    public double getCacheraL() {
        return cacheraL;
    }

    public void setCacheraL(double cacheraL) {
        this.cacheraL = cacheraL;
    }

    public double getCacheraM() {
        return cacheraM;
    }

    public void setCacheraM(double cacheraM) {
        this.cacheraM = cacheraM;
    }

    public double getCacheraS() {
        return cacheraS;
    }

    public void setCacheraS(double cacheraS) {
        this.cacheraS = cacheraS;
    }

    public double getCacheraZ() {
        return cacheraZ;
    }

    public void setCacheraZ(double cacheraZ) {
        this.cacheraZ = cacheraZ;
    }

    public double getCacheraPercentile() {
        return cacheraPercentile;
    }

    public void setCacheraPercentile(double cacheraPercentile) {
        this.cacheraPercentile = cacheraPercentile;
    }

    public WeightClassification getCacheraClassification() {
        return cacheraClassification;
    }

    public void setCacheraClassification(WeightClassification cacheraClassification) {
        this.cacheraClassification = cacheraClassification;
    }

    public double getOmsL() {
        return omsL;
    }

    public void setOmsL(double omsL) {
        this.omsL = omsL;
    }

    public double getOmsM() {
        return omsM;
    }

    public void setOmsM(double omsM) {
        this.omsM = omsM;
    }

    public double getOmsS() {
        return omsS;
    }

    public void setOmsS(double omsS) {
        this.omsS = omsS;
    }

    public double getOmsZ() {
        return omsZ;
    }

    public void setOmsZ(double omsZ) {
        this.omsZ = omsZ;
    }

    public double getOmsPercentile() {
        return omsPercentile;
    }

    public void setOmsPercentile(double omsPercentile) {
        this.omsPercentile = omsPercentile;
    }

    public WeightClassification getOmsClassification() {
        return omsClassification;
    }

    public void setOmsClassification(WeightClassification omsClassification) {
        this.omsClassification = omsClassification;
    }

    public double getCdcL() {
        return cdcL;
    }

    public void setCdcL(double cdcL) {
        this.cdcL = cdcL;
    }

    public double getCdcM() {
        return cdcM;
    }

    public void setCdcM(double cdcM) {
        this.cdcM = cdcM;
    }

    public double getCdcS() {
        return cdcS;
    }

    public void setCdcS(double cdcS) {
        this.cdcS = cdcS;
    }

    public double getCdcZ() {
        return cdcZ;
    }

    public void setCdcZ(double cdcZ) {
        this.cdcZ = cdcZ;
    }

    public double getCdcPercentile() {
        return cdcPercentile;
    }

    public void setCdcPercentile(double cdcPercentile) {
        this.cdcPercentile = cdcPercentile;
    }

    public WeightClassification getCdcClassification() {
        return cdcClassification;
    }

    public void setCdcClassification(WeightClassification cdcClassification) {
        this.cdcClassification = cdcClassification;
    }
}
