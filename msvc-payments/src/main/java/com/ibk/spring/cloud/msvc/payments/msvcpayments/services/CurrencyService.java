package com.ibk.spring.cloud.msvc.payments.msvcpayments.services;

import com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    List<Currency> findAllCurrency();

    Optional<Currency> findById(Long id);

    Currency saveCurrency(Currency currency);

    void deleteCurrency(Long id);

}
