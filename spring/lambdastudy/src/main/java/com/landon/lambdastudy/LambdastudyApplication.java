package com.landon.lambdastudy;

import com.landon.lambdastudy.consumer.VehicleConsumerService;
import com.landon.lambdastudy.function.VehicleFunctionService;
import com.landon.lambdastudy.predicate.VehiclePredicateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LambdastudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(LambdastudyApplication.class, args);

		VehiclePredicateService vehiclePredicateService = new VehiclePredicateService();
		vehiclePredicateService.predicate();

		System.out.println("----------------------------------------------------------");

		VehicleConsumerService vehicleConsumerService = new VehicleConsumerService();
		vehicleConsumerService.consume();

		System.out.println("----------------------------------------------------------");

		VehicleFunctionService vehicleFunctionService = new VehicleFunctionService();
		vehicleFunctionService.run();
	}
}
