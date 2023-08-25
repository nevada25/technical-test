package com.ibk.spring.cloud.msvc.balances.msvcbalances.services.impl;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.BalanceDetail;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.repositories.BalanceDetailRepository;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.services.BalanceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceDetailServiceImpl  implements BalanceDetailService {
    @Autowired
    private BalanceDetailRepository repository;


    @Override
    public List<BalanceDetail> findAllBalanceDetail() {
        return (List<BalanceDetail>) repository.findAll();
    }

    @Override
    public Optional<BalanceDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public BalanceDetail saveBalanceDetail(BalanceDetail BalanceDetail) {
        return repository.save(BalanceDetail);
    }

    @Override
    public void deleteBalanceDetail(Long id) {
        repository.deleteById(id);
    }
}
