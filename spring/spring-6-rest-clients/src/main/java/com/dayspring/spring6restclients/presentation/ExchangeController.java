package com.dayspring.spring6restclients.presentation;

import com.dayspring.spring6restclients.application.ExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/exchange")
    public String getExchange() {
        return exchangeService.getExchange();
    }
}
