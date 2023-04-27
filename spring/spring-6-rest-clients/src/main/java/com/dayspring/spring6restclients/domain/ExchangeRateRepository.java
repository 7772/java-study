package com.dayspring.spring6restclients.domain;

import java.util.Optional;

public interface ExchangeRateRepository {

    Optional<ExchangeRate> getLatest();
}
