package com.example.business.gym.service;

import com.example.business.gym.entity.Client;

import java.util.Optional;

public interface ClientService {

    Optional<Client> getClientById(int id);
    Client createClient(Client client);
    Client updateClientById(Integer id, Client user);
    boolean deleteClientById(int id);
}
