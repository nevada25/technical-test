package com.ibk.spring.cloud.msvc.balances.msvcbalances.services;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {


    List<Client> findAllClient();

    Optional<Client> findById(Long id);

    Client saveClient(Client Client);

    void deleteClient(Long id);
    
}
