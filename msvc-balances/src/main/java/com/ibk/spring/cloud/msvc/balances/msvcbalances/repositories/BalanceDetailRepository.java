package com.ibk.spring.cloud.msvc.balances.msvcbalances.repositories;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.BalanceDetail;
import org.springframework.data.repository.CrudRepository;

public interface BalanceDetailRepository extends CrudRepository<BalanceDetail, Long> {
}
