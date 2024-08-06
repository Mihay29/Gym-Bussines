package com.example.business.gym.service;

import com.example.business.gym.entity.Client;
import com.example.business.gym.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {


    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

   public Client createClient(Client client){
       return  clientRepository.save(client);
   }

   public Optional<Client> getClientById(int id){
       Optional<Client> client = clientRepository.findById(id);
       if(client.isPresent()){
           return Optional.of(client.get());
       }else {
           return Optional.empty();
       }
   }

   public Optional<Client> updateClient(Integer id,Client client){
       Optional<Client> optionalClient = getClientById(id);
       if(optionalClient.isPresent()){
          Client client1 = optionalClient.get();

          client1.setAddress(client.getAddress());
          client1.setEmail(client.getEmail());
          client1.setPhone(client.getPhone());
          client1.setFirstName(client.getFirstName());
          client1.setLastName(client.getLastName());
          return Optional.of(clientRepository.save(client1));
       }else{
           return Optional.empty();
       }
   }

   public void deleteClientById(int id){
       clientRepository.deleteById(id);
   }
}
