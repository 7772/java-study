package com.landon.lambdastudy.consumer;

import com.landon.lambdastudy.Vehicle;

import java.util.function.Consumer;

public class VehicleInformation {
    private Vehicle vehicle;

    public VehicleInformation(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void print(Consumer<Vehicle> vehicleConsumer) {
        System.out.println(vehicle.getType());
        System.out.println(vehicle.getVendor());
        System.out.println(vehicle.getModelName());
        System.out.println(vehicle.getColor());

        vehicleConsumer.accept(vehicle);
    }
}
