package com.example.myapplication.cawClasses;

public class Food {
    protected String name;
    protected double caloriesper100g;
    protected double proteinper100g;
    protected double fatper100g;
    protected double carbper100g;

    Food() {
        name = "";
        caloriesper100g = 0;
        proteinper100g = 0;
        fatper100g = 0;
        carbper100g = 0;
    }
    public Food(String name, double caloriesper100g, double proteinper100g, double fatper100g, double carbper100g) {
        this.name = name;
        this.caloriesper100g = caloriesper100g;
        this.proteinper100g = proteinper100g;
        this.fatper100g = fatper100g;
        this.carbper100g = carbper100g;
    }

    public double getCaloriesper100g() {
        return caloriesper100g;
    }
    public double getProteinper100g() {return proteinper100g;}
    public double getFatper100g() {return fatper100g;}
    public double getCarbper100g() {return carbper100g;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
