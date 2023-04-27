package com.dayspring.spring6restclients.infrastructure.domain;

import com.dayspring.spring6restclients.domain.ExchangeRate;
import com.dayspring.spring6restclients.domain.ExchangeRateRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateMyBatisRepositoryImpl implements ExchangeRateRepository {

    @Override
    public Optional<ExchangeRate> getLatest() {
//        return mapper.select();
        return Optional.empty();
    }
}
