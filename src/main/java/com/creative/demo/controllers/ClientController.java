package com.creative.demo.controllers;

import com.creative.demo.models.Client;
import com.creative.demo.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepo clientRepo;

    @GetMapping("")
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable long id) {
        return clientRepo.findById(id).get();
    }

    @PostMapping("")
    public void CreateClient(@RequestBody Client client) {
        clientRepo.save(client);
    }

}
