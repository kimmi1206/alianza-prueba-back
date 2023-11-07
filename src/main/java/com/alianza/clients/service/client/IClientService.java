package com.alianza.clients.service.client;

import com.alianza.clients.domain.entity.Client;

import java.util.List;

public interface IClientService {

    Client findById(long id);

    Client findBySharedKey(String sharedKey);

    Client save(Client client);

    List<Client> findAll();
}
