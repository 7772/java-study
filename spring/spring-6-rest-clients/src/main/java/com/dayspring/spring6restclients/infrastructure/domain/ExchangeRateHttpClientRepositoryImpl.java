package com.dayspring.spring6restclients.infrastructure.domain;

import com.dayspring.spring6restclients.domain.ExchangeRate;
import com.dayspring.spring6restclients.domain.ExchangeRateRepository;
import com.dayspring.spring6restclients.infrastructure.httpclient.ExchangeHttpClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateHttpClientRepositoryImpl implements ExchangeRateRepository {

    private final ObjectMapper objectMapper;
    private final ExchangeHttpClient exchangeHttpClient;

    public ExchangeRateHttpClientRepositoryImpl(ExchangeHttpClient exchangeHttpClient) {
        this.exchangeHttpClient = exchangeHttpClient;
        this.objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public Optional<ExchangeRate> getLatest() {
        try {
            return Optional.of(objectMapper.readValue(
                    exchangeHttpClient.getLatest(), ExchangeRate.class));
        } catch (JsonProcessingException e) {
            // logging
            return Optional.empty();
        }
    }
}
