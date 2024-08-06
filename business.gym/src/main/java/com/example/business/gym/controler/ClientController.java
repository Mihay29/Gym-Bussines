package com.example.business.gym.controler;


import com.example.business.gym.entity.Client;
import com.example.business.gym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Integer id){
       return clientService.getClientById(id);
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client){
       return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Optional<Client> updateClientById(@PathVariable Integer id, @RequestBody Client client){
        return clientService.updateClient(id,client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Integer id){
        clientService.deleteClientById(id);
    }
}
