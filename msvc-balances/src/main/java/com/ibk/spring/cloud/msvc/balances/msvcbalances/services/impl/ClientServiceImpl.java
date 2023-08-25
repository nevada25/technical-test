package com.ibk.spring.cloud.msvc.balances.msvcbalances.services.impl;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Client;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.repositories.ClientRepository;
import com.ibk.spring.cloud.msvc.balances.msvcbalances.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository repository;


    @Override
    public List<Client> findAllClient() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
