package com.example.user;

import java.util.List;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

public class SayHelloConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new DemoServiceInstanceListSuppler("say-hello");
    }

    static class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

        private final String serviceId;

        DemoServiceInstanceListSuppler(String serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public String getServiceId() {
            return serviceId;
        }

        @Override
        public Flux<List<ServiceInstance>> get() {
            final String host = "localhost";
            return Flux.just(List.of(
                    new DefaultServiceInstance(
                            serviceId + "1",
                            serviceId,
                            host,
                            8090,
                            false),
                    new DefaultServiceInstance(
                            serviceId + "2",
                            serviceId,
                            host,
                            8091,
                            false),
                    new DefaultServiceInstance(
                            serviceId + "3",
                            serviceId,
                            host,
                            8092,
                            false)));
        }
    }
}
