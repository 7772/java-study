package com.dayspring.spring6restclients;

import org.springframework.web.service.annotation.GetExchange;

public interface ExchangeApi {

    @GetExchange("/v6/latest")
    String getLatest();
}
