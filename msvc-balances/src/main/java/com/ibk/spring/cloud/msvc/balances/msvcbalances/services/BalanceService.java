package com.ibk.spring.cloud.msvc.balances.msvcbalances.services;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Balance;

import java.util.List;
import java.util.Optional;

public interface BalanceService {
    List<Balance> findAllBalance();

    Optional<Balance> findById(Long id);

    Balance saveBalance(Balance Balance);

    void deleteBalance(Long id);

}
