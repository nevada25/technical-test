package com.ibk.spring.cloud.msvc.balances.msvcbalances.services;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.BalanceDetail;

import java.util.List;
import java.util.Optional;

public interface BalanceDetailService {
 
    List<BalanceDetail> findAllBalanceDetail();

    Optional<BalanceDetail> findById(Long id);

    BalanceDetail saveBalanceDetail(BalanceDetail BalanceDetail);

    void deleteBalanceDetail(Long id);
    
}
