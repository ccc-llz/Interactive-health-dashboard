package com.cs79_1.interactive_dashboard.Entity;

import com.cs79_1.interactive_dashboard.Enum.mentalStrength;
import jakarta.persistence.*;

@Entity
public class MentalHealthAndDailyRoutine {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private double selfesteemScore;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private mentalStrength selfesteemStrength;

    @Column(nullable = false)
    private double procrastinationScore;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private mentalStrength procrastinationStrength;

    @Column(nullable = false)
    private double weekdaySleepingAvgDuration;

    @Column(nullable = false)
    private double weekendSleepingAvgDuration;

    @Column(nullable = false)
    private double totalSleepingDuration;

    public MentalHealthAndDailyRoutine() {}

    public MentalHealthAndDailyRoutine(User user) {
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

    public double getSelfesteemScore() {
        return selfesteemScore;
    }

    public void setSelfesteemScore(double selfesteemScore) {
        this.selfesteemScore = selfesteemScore;
    }

    public mentalStrength getSelfesteemStrength() {
        return selfesteemStrength;
    }

    public void setSelfesteemStrength(mentalStrength selfesteemStrength) {
        this.selfesteemStrength = selfesteemStrength;
    }

    public double getProcrastinationScore() {
        return procrastinationScore;
    }

    public void setProcrastinationScore(double procrastinationScore) {
        this.procrastinationScore = procrastinationScore;
    }

    public mentalStrength getProcrastinationStrength() {
        return procrastinationStrength;
    }

    public void setProcrastinationStrength(mentalStrength procrastinationStrength) {
        this.procrastinationStrength = procrastinationStrength;
    }

    public double getWeekdaySleepingAvgDuration() {
        return weekdaySleepingAvgDuration;
    }

    public void setWeekdaySleepingAvgDuration(double weekdaySleepingAvgDuration) {
        this.weekdaySleepingAvgDuration = weekdaySleepingAvgDuration;
    }

    public double getWeekendSleepingAvgDuration() {
        return weekendSleepingAvgDuration;
    }

    public void setWeekendSleepingAvgDuration(double weekendSleepingAvgDuration) {
        this.weekendSleepingAvgDuration = weekendSleepingAvgDuration;
    }

    public double getTotalSleepingDuration() {
        return totalSleepingDuration;
    }

    public void setTotalSleepingDuration(double totalSleepingDuration) {
        this.totalSleepingDuration = totalSleepingDuration;
    }
}
