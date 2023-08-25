package com.ibk.spring.cloud.msvc.balances.msvcbalances.repositories;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Balance;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
}
