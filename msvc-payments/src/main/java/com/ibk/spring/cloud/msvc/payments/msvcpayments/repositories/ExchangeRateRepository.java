package com.ibk.spring.cloud.msvc.payments.msvcpayments.repositories;

import com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {
}
