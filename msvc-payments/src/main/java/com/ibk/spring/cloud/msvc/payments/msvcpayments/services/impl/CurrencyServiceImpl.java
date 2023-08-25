package com.ibk.spring.cloud.msvc.payments.msvcpayments.services.impl;

import com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity.Currency;
import com.ibk.spring.cloud.msvc.payments.msvcpayments.repositories.CurrencyRepository;
import com.ibk.spring.cloud.msvc.payments.msvcpayments.services.CurrencyService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {


    @Autowired
    private CurrencyRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Currency> findAllCurrency() {
        return (List<Currency>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Currency> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Currency saveCurrency(Currency currency) {
        return repository.save(currency);
    }

    @Override
    @Transactional
    public void deleteCurrency(Long id) {
        repository.deleteById(id);
    }
}
