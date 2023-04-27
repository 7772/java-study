package com.dayspring.spring6restclients.config;

import com.dayspring.spring6restclients.infrastructure.httpclient.ExchangeHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientsConfiguration {

    @Bean
    public WebClient openErApiClient() {
        return WebClient.builder()
                .baseUrl("https://open.er-api.com")
                .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                    // change error
                    throw new RuntimeException("");
                })
                .build();
    }

    @Bean
    public ExchangeHttpClient exchangeApi() {
        return exchangeHttpClientFactory(openErApiClient());
    }

    private ExchangeHttpClient exchangeHttpClientFactory(WebClient webClient) {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();

        return httpServiceProxyFactory.createClient(ExchangeHttpClient.class);
    }
}
