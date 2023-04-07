package com.landon.lambdastudy.predicate;

import java.util.function.Predicate;

import com.landon.lambdastudy.Vehicle;

public class VehicleSUVPredicate implements Predicate<Vehicle> {
    @Override
    public boolean test(Vehicle vehicle) {
        return Vehicle.Type.SUV.equals(vehicle.getType());
    }
}
