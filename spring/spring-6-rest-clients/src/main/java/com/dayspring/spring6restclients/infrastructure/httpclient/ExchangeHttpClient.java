package com.dayspring.spring6restclients.infrastructure.httpclient;

import org.springframework.web.service.annotation.GetExchange;

public interface ExchangeHttpClient {

    @GetExchange("/v6/latest")
    String getLatest();
}
