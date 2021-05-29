package com.landon.lambdastudy.predicate;

import com.landon.lambdastudy.Vehicle;

import java.util.function.Predicate;

public class VehiclePredicator {
    private final Vehicle vehicle;

    public VehiclePredicator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean predicate(Predicate<Vehicle> predicate) {
        return predicate.test(vehicle);
    }
}
