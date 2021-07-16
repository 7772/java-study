package com.landon.lambdastudy.consumer;

import com.landon.lambdastudy.Vehicle;

public class VehicleConsumerService {
    private Vehicle vehicle;
    private VehicleInformation vehicleInformation;

    public VehicleConsumerService() {
        vehicle = new Vehicle(Vehicle.Type.SUV, "BMW", "M3", "white");
        vehicleInformation = new VehicleInformation(vehicle);
    }

    public void consume() {
        vehicleInformation.print(new VehicleConsumer().consume());
    }
}
