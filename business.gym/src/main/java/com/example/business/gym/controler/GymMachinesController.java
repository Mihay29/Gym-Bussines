package com.example.business.gym.controler;

import com.example.business.gym.entity.GymMachines;
import com.example.business.gym.service.GymMachinesService;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/machines")
public class GymMachinesController {


    @Autowired
    GymMachinesService gymMachinesService;

    @GetMapping("/{id}")
    public Optional<GymMachines> getGymMachinesById(@PathVariable int id) {
        return gymMachinesService.getGymMachinesById(id);
    }

    @PostMapping
    public Optional<GymMachines> saveGymMachines(@RequestBody GymMachines gymMachines) {
        return gymMachinesService.createGymMachines(gymMachines);
    }

    @PutMapping("/{id}")
    public Optional<GymMachines> updateMachinesById(@PathVariable int id, @RequestBody GymMachines gymMachines) {
        return gymMachinesService.updateGymMachinesById(id, gymMachines);
    }

    @DeleteMapping("/{id}")
    public void deleteMachinesById(@PathVariable int id) {
       gymMachinesService.deleteGymMachinesById(id);
    }

}
