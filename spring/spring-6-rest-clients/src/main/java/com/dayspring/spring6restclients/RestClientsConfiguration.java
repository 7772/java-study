package com.dayspring.spring6restclients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientsConfiguration {

    @Bean
    public WebClient openErApiClient() {
//        return WebClient.create("https://open.er-api.com");
        return WebClient.builder()
                .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                    // change error
                    throw new RuntimeException("");
                })
                .build();
    }

    @Bean
    public ExchangeApi exchangeApi() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(openErApiClient()))
                .build();

        return httpServiceProxyFactory.createClient(ExchangeApi.class);
    }
}
