package com.ibk.spring.cloud.msvc.payments.msvcpayments.controllers;

import com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity.ExchangeRate;
import com.ibk.spring.cloud.msvc.payments.msvcpayments.response.ApiResponseUser;
import com.ibk.spring.cloud.msvc.payments.msvcpayments.services.CurrencyService;
import com.ibk.spring.cloud.msvc.payments.msvcpayments.services.ExchangeRateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments/exchangeRate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService ExchangeRateService;
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<ApiResponseUser> listAll() {
        List<ExchangeRate> currencies = this.ExchangeRateService.findAllExchangeRate();


        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("Los datos del tipo de cambio  se estan listando correctamente")
                .status(HttpStatus.OK)
                .data(currencies)
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<?> saveExchangeRate(@Valid @RequestBody ExchangeRate ExchangeRate, BindingResult result) {
        if (result.hasErrors()) {
            return valid_data(result);
        }

        ExchangeRate ExchangeRateRequest = ExchangeRateService.saveExchangeRate(ExchangeRate);

        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("El tipo de cambio se ha creado correctamente")
                .status(HttpStatus.OK)
                .data(ExchangeRateRequest)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExchangeRate(@PathVariable Long id) {
        Optional<ExchangeRate> o = ExchangeRateService.findById(id);
        if (o.isPresent()) {
            ExchangeRateService.deleteExchangeRate(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



    private ResponseEntity<Map<String, String>> valid_data(BindingResult result) {
        Map<String, String> errs = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errs.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errs);
    }
}
