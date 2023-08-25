package com.ibk.spring.cloud.msvc.balances.msvcbalances.controllers;


import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Client;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.response.ApiResponseUser;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.services.ClientService;
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
@RequestMapping("/api/balances/client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<ApiResponseUser> listAll() {
        List<Client> currencies = this.clientService.findAllClient();
        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("Los datos de la moneda se estan listando correctamente")
                .status(HttpStatus.OK)
                .data(currencies)
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<?> saveClient(@Valid @RequestBody Client client, BindingResult result) {
        if (result.hasErrors()) {
            return valid_data(result);
        }

        Client clientRequest = clientService.saveClient(client);

        ApiResponseUser response = new ApiResponseUser().builder()
                .success(true)
                .message("La moneda se ha creado correctamente")
                .status(HttpStatus.OK)
                .data(clientRequest)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Optional<Client> o = clientService.findById(id);
        if (o.isPresent()) {
            clientService.deleteClient(id);
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
