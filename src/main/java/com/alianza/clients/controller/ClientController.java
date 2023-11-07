package com.alianza.clients.controller;

import com.alianza.clients.domain.entity.Client;
import com.alianza.clients.service.client.impl.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/id/{clientId}")
    public ResponseEntity<Client> getById(@PathVariable long clientId) {
        return new ResponseEntity<>(clientService.findById(clientId), HttpStatus.OK);
    }

    @GetMapping("/find-sharedkey")
    public ResponseEntity<Client> getBySharedKey(@RequestParam String sharedKey) {
        return new ResponseEntity<>(clientService.findBySharedKey(sharedKey), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Client> save(@Valid @RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }
}
