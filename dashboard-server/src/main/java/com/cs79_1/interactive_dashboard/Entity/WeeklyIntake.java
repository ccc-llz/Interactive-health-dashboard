package com.cs79_1.interactive_dashboard.Entity;

import jakarta.persistence.*;

@Entity
public class WeeklyIntake {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private double cereals;

    @Column(nullable = false)
    private double vegetablesAndLegumes;

    @Column(nullable = false)
    private double fruit;

    @Column(nullable = false)
    private double dairy;

    @Column(nullable = false)
    private double fatsOils;

    @Column(nullable = false)
    private double meatFishPoultryEggs;

    @Column(nullable = false)
    private double drinks;

    @Column(nullable = false)
    private double extras;

    @Column(nullable = false)
    private double other;

    @Column(nullable = false)
    private double water;

    @Column(nullable = false)
    private double sugarSweetenedBeverages;

    @Column(nullable = false)
    private double energyGroupAvgDaily;

    @Column(nullable = false)
    private double protectiveGroupAvgDaily;

    @Column(nullable = false)
    private double bodybuildingGroupAvgDaily;

    @Column(nullable = false)
    private double limitedFoodAvgDaily;

    @Column(nullable = false)
    private double limitedBeveragesAvgDaily;

    @Column(nullable = false)
    private double waterAvgDaily;

    public WeeklyIntake() {}

    public WeeklyIntake(User user) {
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

    public double getCereals() {
        return cereals;
    }

    public void setCereals(double cereals) {
        this.cereals = cereals;
    }

    public double getVegetablesAndLegumes() {
        return vegetablesAndLegumes;
    }

    public void setVegetablesAndLegumes(double vegetablesAndLegumes) {
        this.vegetablesAndLegumes = vegetablesAndLegumes;
    }

    public double getFruit() {
        return fruit;
    }

    public void setFruit(double fruit) {
        this.fruit = fruit;
    }

    public double getDairy() {
        return dairy;
    }

    public void setDairy(double dairy) {
        this.dairy = dairy;
    }

    public double getFatsOils() {
        return fatsOils;
    }

    public void setFatsOils(double fatsOils) {
        this.fatsOils = fatsOils;
    }

    public double getMeatFishPoultryEggs() {
        return meatFishPoultryEggs;
    }

    public void setMeatFishPoultryEggs(double meatFishPoultryEggs) {
        this.meatFishPoultryEggs = meatFishPoultryEggs;
    }

    public double getDrinks() {
        return drinks;
    }

    public void setDrinks(double drinks) {
        this.drinks = drinks;
    }

    public double getExtras() {
        return extras;
    }

    public void setExtras(double extras) {
        this.extras = extras;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getSugarSweetenedBeverages() {
        return sugarSweetenedBeverages;
    }

    public void setSugarSweetenedBeverages(double sugarSweetenedBeverages) {
        this.sugarSweetenedBeverages = sugarSweetenedBeverages;
    }

    public double getEnergyGroupAvgDaily() {
        return energyGroupAvgDaily;
    }

    public void setEnergyGroupAvgDaily(double energyGroupAvgDaily) {
        this.energyGroupAvgDaily = energyGroupAvgDaily;
    }

    public double getProtectiveGroupAvgDaily() {
        return protectiveGroupAvgDaily;
    }

    public void setProtectiveGroupAvgDaily(double protectiveGroupAvgDaily) {
        this.protectiveGroupAvgDaily = protectiveGroupAvgDaily;
    }

    public double getBodybuildingGroupAvgDaily() {
        return bodybuildingGroupAvgDaily;
    }

    public void setBodybuildingGroupAvgDaily(double bodybuildingGroupAvgDaily) {
        this.bodybuildingGroupAvgDaily = bodybuildingGroupAvgDaily;
    }

    public double getLimitedFoodAvgDaily() {
        return limitedFoodAvgDaily;
    }

    public void setLimitedFoodAvgDaily(double limitedFoodAvgDaily) {
        this.limitedFoodAvgDaily = limitedFoodAvgDaily;
    }

    public double getLimitedBeveragesAvgDaily() {
        return limitedBeveragesAvgDaily;
    }

    public void setLimitedBeveragesAvgDaily(double limitedBeveragesAvgDaily) {
        this.limitedBeveragesAvgDaily = limitedBeveragesAvgDaily;
    }

    public double getWaterAvgDaily() {
        return waterAvgDaily;
    }

    public void setWaterAvgDaily(double waterAvgDaily) {
        this.waterAvgDaily = waterAvgDaily;
    }
}
