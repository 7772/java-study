package com.landon.lambdastudy.consumer;

import java.util.function.Consumer;

import com.landon.lambdastudy.Vehicle;

public class VehicleGettingInstanceConsumer implements VehicleConsumer {
    public Consumer<Vehicle> consume() {
        return (vehicle) -> {
            System.out.println("Instance : " + vehicle);
        };
    }
}
