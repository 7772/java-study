package com.landon.lambdastudy.consumer;

import java.util.function.Consumer;

import com.landon.lambdastudy.Vehicle;

public class VehicleWithBicycleConsumer implements VehicleConsumer {

    @Override
    public Consumer<Vehicle> consume() {
        Bicycle bicycle = new Bicycle();

        return (vehicle) -> {
            System.out.println("Bicycle is : " + bicycle.getName());
        };
    }

    public static class Bicycle {
        private final String name = "perfect-bicycle";

        public String getName() {
            return name;
        }
    }
}
