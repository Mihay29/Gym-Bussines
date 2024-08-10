package com.example.business.gym.controler;


import com.example.business.gym.entity.Client;
import com.example.business.gym.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientServiceImpl userServiceImpl;

    @Autowired
    public ClientController(ClientServiceImpl  userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getUserById(@PathVariable Integer id) {
        return userServiceImpl.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
     public ResponseEntity<Client> createClient(@RequestBody Client client){
       return ResponseEntity.ok(userServiceImpl.createClient(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClientById(@PathVariable Integer id, @RequestBody Client client){
        return ResponseEntity.ok(userServiceImpl.updateClientById(id,client));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Integer id) {
        if (userServiceImpl.deleteClientById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
