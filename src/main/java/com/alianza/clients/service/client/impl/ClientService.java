package com.alianza.clients.service.client.impl;

import com.alianza.clients.domain.entity.Client;
import com.alianza.clients.exception.ClientNotFoundException;
import com.alianza.clients.repository.client.ClientRepository;
import com.alianza.clients.service.client.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements IClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(long id) {
        LOGGER.info("findById={}", id);

        Client client = clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);

        LOGGER.info("Result (find id={})): {}", id, client);
        return client;
    }

    @Override
    public Client findBySharedKey(String sharedKey) {
        LOGGER.info("findBySharedKey={}", sharedKey);

        Client client = clientRepository.findBySharedKey(sharedKey)
                .orElseThrow(ClientNotFoundException::new);

        LOGGER.info("Result (find sharedKey={})): {}", sharedKey, client);
        return client;
    }

    @Override
    public Client save(Client client) {
        LOGGER.info("save client={}", client);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        LOGGER.info("findAll");

        List<Client> clients = new ArrayList<>();
        Iterable<Client> clientsIterable = clientRepository.findAll();
        if (clientsIterable.iterator().hasNext()) {
            for (Client client : clientsIterable) {
                clients.add(client);
            }
        }

        LOGGER.info("Result (findAll): {}", clients);
        return clients;
    }
}
