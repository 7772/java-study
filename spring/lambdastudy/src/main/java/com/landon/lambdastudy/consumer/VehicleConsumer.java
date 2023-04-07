package com.landon.lambdastudy.consumer;

import java.util.function.Consumer;

import com.landon.lambdastudy.Vehicle;

public interface VehicleConsumer {
    Consumer<Vehicle> consume();
}
