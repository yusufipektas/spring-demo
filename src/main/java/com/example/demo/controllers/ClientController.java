package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("clients")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("clients")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("clients/{id}")
    public Client getClient(@PathVariable String id) {
        Optional<Client> clientFound = clientRepository.findById(id);
        return clientFound.orElse(null);
    }

    @PutMapping("clients/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client client) {
        Optional<Client> clientFound = clientRepository.findById(id);
        if (clientFound.isEmpty()) return null;
        Client clientToUpdate = clientFound.get();
        clientToUpdate.setName(client.getName());
        clientToUpdate.setLastname(client.getLastname());
        clientToUpdate.setAge(client.getAge());
        return clientRepository.save(clientToUpdate);
    }

    @DeleteMapping("clients/{id}")
    public String deleteClient(@PathVariable String id) {
        clientRepository.deleteById(id);
        return "Client deleted";
    }

}
