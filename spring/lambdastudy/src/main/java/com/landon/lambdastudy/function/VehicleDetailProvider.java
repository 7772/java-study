package com.landon.lambdastudy.function;

import com.landon.lambdastudy.Vehicle;

import java.util.function.Function;

public class VehicleDetailProvider {
    private Vehicle vehicle;

    public VehicleDetailProvider(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public <R> R make(Function<Vehicle, R> function) {
        return function.apply(vehicle);
    }
}
