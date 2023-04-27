package com.dayspring.spring6restclients.application;

import com.dayspring.spring6restclients.domain.ExchangeRate;
import com.dayspring.spring6restclients.domain.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeService(
            @Qualifier("exchangeRateMyBatisRepositoryImpl") ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public String getExchange() {
        ExchangeRate exchangeRate = exchangeRateRepository.getLatest().orElseThrow();
        return String.valueOf(exchangeRate.getMaxRates());
    }
}
