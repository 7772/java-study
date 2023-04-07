package com.landon.lambdastudy;

import java.util.function.Predicate;

public class Vehicle {
    private Type type;

    private String vendor;

    private String modelName;

    private String color;

    public Vehicle(
        Type type,
        String vendor,
        String modelName,
        String color
    ) {
        this.type = type;
        this.vendor = vendor;
        this.modelName = modelName;
        this.color = color;
    }

    public enum Type {
        SUV,
        SEDAN,
        TRUCK
    }

    public Type getType() {
        return type;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModelName() {
        return modelName;
    }

    public String getColor() {
        return color;
    }
}
