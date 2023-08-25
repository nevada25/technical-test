package com.ibk.spring.cloud.msvc.payments.msvcpayments.services;


import com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity.ExchangeRate;

import java.util.List;
import java.util.Optional;

public interface ExchangeRateService {

    List<ExchangeRate> findAllExchangeRate();

    Optional<ExchangeRate> findById(Long id);

    ExchangeRate saveExchangeRate(ExchangeRate exchangeRate);

    void deleteExchangeRate(Long id);
}
