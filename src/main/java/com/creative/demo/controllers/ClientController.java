package com.creative.demo.controllers;

import com.creative.demo.models.Client;
import com.creative.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<List<Client>>(
                clientService.getAllClients(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable long id) {
        Optional<Client> client = clientService.getClientById(id);
        Map<String, String> body = new HashMap<>();
        if (client.isPresent()) {
            return new ResponseEntity<Client>(
                    client.get(),
                    HttpStatus.OK
            );
            } else {
            body.put("message", "Client not found");
            return new ResponseEntity<>(
                    body,
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping("")
    public ResponseEntity<Client> CreateClient(@RequestBody Client client) {
        return new ResponseEntity<Client>(
                clientService.createClient(client),
                HttpStatus.CREATED
        );
    }

}
