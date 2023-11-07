package com.alianza.clients.repository.client;

import com.alianza.clients.domain.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findBySharedKey(String sharedKey);
}
