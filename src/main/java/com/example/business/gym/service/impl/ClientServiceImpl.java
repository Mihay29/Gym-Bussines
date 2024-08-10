package com.example.business.gym.service.impl;

import com.example.business.gym.entity.Client;
import com.example.business.gym.repository.ClientRepository;
import com.example.business.gym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
   public Client createClient(Client client){
       return  clientRepository.save(client);
   }
   @Transactional(readOnly = true)
   @Override
   public Optional<Client> getClientById(int id){
       return clientRepository.findById(id);
   }

    @Override
    public Client updateClientById(Integer id,Client client){
       return clientRepository.findById(id)
               .map(existingClient -> {
                   existingClient.setAddress(client.getAddress());
                   existingClient.setEmail(client.getEmail());
                   existingClient.setFirstName(client.getFirstName());
                   existingClient.setLastName(client.getLastName());
                   existingClient.setPhone(client.getPhone());
                   return clientRepository.save(existingClient);
               })
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
   }
   @Override
   public boolean deleteClientById(int id){
       return clientRepository.findById(id)
               .map(existingClient -> {
                   clientRepository.delete(existingClient);
                   return true;
               })
               .orElse(false);
   }
}
