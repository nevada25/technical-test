package com.ibk.spring.cloud.msvc.balances.msvcbalances.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Currency;
import java.util.List;

@FeignClient(name = "msvc-payments", url = "http://localhost:8001")
public interface PaymentClientRest {

    @GetMapping("/api/payments/currency")
    List<Currency> getCurrencies();

    @PostMapping("/api/payments/currency")
    Currency saveCurrency();

    @PostMapping("/api/payments/currency")
    void deleteCurrency();


}
