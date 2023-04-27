package com.dayspring.spring6restclients.domain;

import com.dayspring.spring6restclients.domain.vo.Rates;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRate {

    private String provider;
    @JsonProperty("base_code")
    private String baseCode;
    private Rates rates;

    public ExchangeRate() {

    }

    public ExchangeRate(String provider, String baseCode, Rates rates) {
        this.provider = provider;
        this.baseCode = baseCode;
        this.rates = rates;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Rates getRates() {
        return this.rates;
    }

    public Double getMaxRates() {
        return rates.getMax();
    }

    @Override
    public String toString() {
        return provider + " " + baseCode + " " + rates.toString();
    }
}
