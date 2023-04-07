package com.landon.lambdastudy.function;

import com.landon.lambdastudy.Vehicle;

public class VehicleFunctionService {
    private final VehicleDetailProvider vehicleDetailProvider;

    public VehicleFunctionService() {
        Vehicle vehicle = new Vehicle(Vehicle.Type.SUV, "BMW", "M3", "white");
        vehicleDetailProvider = new VehicleDetailProvider(vehicle);
    }

    public void run() {
        String vehicleColor = vehicleDetailProvider.make((vehicle) -> vehicle.getColor());
        String vehicleColorByMethodReference = vehicleDetailProvider.make(Vehicle::getColor);

        Vehicle.Type vehicleType = vehicleDetailProvider.make(vehicle -> vehicle.getType());
        boolean isSedan = vehicleDetailProvider.make(vehicle -> vehicle.getType().equals(Vehicle.Type.SEDAN));

        System.out.println("vehicleColor : " + vehicleColor);
        System.out.println("vehicleColorByMethodReference : " + vehicleColorByMethodReference);

        System.out.println("vehicleType : " + vehicleType);
        System.out.println("isSedan : " + isSedan);
    }
}
