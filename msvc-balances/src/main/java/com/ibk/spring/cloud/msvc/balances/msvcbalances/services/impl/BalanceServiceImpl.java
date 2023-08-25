package com.ibk.spring.cloud.msvc.balances.msvcbalances.services.impl;


import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Balance;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.repositories.BalanceRepository;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.services.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private BalanceRepository repository;


    @Override
    public List<Balance> findAllBalance() {
        return (List<Balance>) repository.findAll();
    }

    @Override
    public Optional<Balance> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Balance saveBalance(Balance Balance) {
        return repository.save(Balance);
    }

    @Override
    public void deleteBalance(Long id) {
        repository.deleteById(id);
    }
}
