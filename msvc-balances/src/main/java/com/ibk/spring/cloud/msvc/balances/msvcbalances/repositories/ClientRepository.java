package com.ibk.spring.cloud.msvc.balances.msvcbalances.repositories;

import com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
