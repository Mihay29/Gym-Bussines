package com.example.business.gym.controler;

import com.example.business.gym.entity.GymMachines;
import com.example.business.gym.service.impl.GymMachinesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/machines")
public class GymMachinesController {


    private final GymMachinesServiceImpl gymMachinesServiceImpl;

    @Autowired
    public GymMachinesController(GymMachinesServiceImpl gymMachinesServiceImpl){
        this.gymMachinesServiceImpl = gymMachinesServiceImpl;
    }
    @GetMapping("/{id}")
    public ResponseEntity<GymMachines> getUserById(@PathVariable Integer id) {
        return gymMachinesServiceImpl.getGymMachinesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GymMachines> createGymMachines(@RequestBody GymMachines gymMachines){
        return ResponseEntity.ok(gymMachinesServiceImpl.createGymMachines(gymMachines));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GymMachines> updateGymMachinesById(@PathVariable Integer id, @RequestBody GymMachines gymMachines){
        return ResponseEntity.ok(gymMachinesServiceImpl.updateGymMachinesById(id,gymMachines));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGymMachinesById(@PathVariable Integer id) {
        if (gymMachinesServiceImpl.deleteGymMachinesById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
