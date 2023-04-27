package com.dayspring.spring6restclients.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Rates(
        @JsonProperty("USD")
        Double usd,
        @JsonProperty("AED")
        Double aed,
        @JsonProperty("KRW")
        Double krw
) {

    public Double getMax() {
        return Math.max(usd, Math.max(aed, krw));
    }
}
