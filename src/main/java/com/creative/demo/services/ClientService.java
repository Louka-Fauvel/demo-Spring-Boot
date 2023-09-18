package com.creative.demo.services;

import com.creative.demo.models.Client;
import com.creative.demo.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public Client createClient(Client client) {
        int anneDeNaissance = client.getAnneDeNaissance();
        int age = LocalDate.now().getYear() - anneDeNaissance;
        return clientRepo.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepo.findById(id);
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

}
