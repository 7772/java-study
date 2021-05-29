package com.landon.lambdastudy.predicate;

import com.landon.lambdastudy.Vehicle;

public class VehiclePredicateService {
    private final Vehicle vehicle;

    private final VehicleSUVPredicate vehicleSUVPredicate;

    private final VehiclePredicator vehiclePredicator;

    public VehiclePredicateService() {
        vehicle = new Vehicle(Vehicle.Type.SUV, "BMW", "M3", "white");
        vehicleSUVPredicate = new VehicleSUVPredicate();
        vehiclePredicator = new VehiclePredicator(vehicle);
    }

    public void predicate() {
        boolean isSuv = vehicleSUVPredicate.test(vehicle);
        boolean isSuvByImplementation = vehiclePredicator.predicate(vehicleSUVPredicate);
        boolean isSuvByPredicator = vehiclePredicator.predicate(
            (Vehicle vehicle) -> vehicle.getType().equals(Vehicle.Type.SUV)
        );
        boolean isSedan = vehiclePredicator.predicate(
            (Vehicle vehicle) -> vehicle.getType().equals(Vehicle.Type.SEDAN)
        );
        boolean isSedanAndGreenColor = vehiclePredicator.predicate(
            (Vehicle vehicle) -> vehicle.getType().equals(Vehicle.Type.SEDAN) &&
                vehicle.getColor() == "green"
        );
        boolean isBMW = vehiclePredicator.predicate(
            (vehicle) -> vehicle.getVendor() == "BMW"
        );

        System.out.println("isSuv : " + isSuv);
        System.out.println("isSuvByImplementation : " + isSuvByImplementation);
        System.out.println("isSuvByPredicator : " + isSuvByPredicator);
        System.out.println("isSedan : " + isSedan);
        System.out.println("isSedanAndGreenColor : " + isSedanAndGreenColor);
        System.out.println("isBMW : " + isBMW);
    }
}
