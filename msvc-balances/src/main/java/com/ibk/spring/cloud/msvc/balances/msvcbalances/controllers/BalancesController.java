package com.ibk.spring.cloud.msvc.balances.msvcbalances.controllers;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Balance;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Balance;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.response.ApiResponseUser;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.services.BalanceService;
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
@RequestMapping("/api/balances/balance")
public class BalancesController {
    @Autowired
    private BalanceService balanceService;


    @GetMapping
    public ResponseEntity<ApiResponseUser> listAll() {
        List<Balance> currencies = balanceService.findAllBalance();
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("Los datos del balance se estan listando correctamente")
                .status(HttpStatus.OK)
                .data(currencies)
                .build();
        return ResponseEntity.ok(response);
    }



    @PostMapping
    public ResponseEntity<?> saveBalance(@Valid @RequestBody Balance balance, BindingResult result) {
        if (result.hasErrors()) {
            return valid_data(result);
        }

        Balance balanceRequest = balanceService.saveBalance(balance);

        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("El balancee se ha creado correctamente")
                .status(HttpStatus.OK)
                .data(balanceRequest)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBalance(@PathVariable Long id) {
        Optional<Balance> o = balanceService.findById(id);
        if (o.isPresent()) {
            balanceService.deleteBalance(id);
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
