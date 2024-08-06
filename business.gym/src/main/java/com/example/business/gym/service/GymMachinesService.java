package com.example.business.gym.service;

import com.example.business.gym.entity.Back;
import com.example.business.gym.entity.Chest;
import com.example.business.gym.entity.GymMachines;
import com.example.business.gym.repository.GymMachinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymMachinesService {

    @Autowired
    private GymMachinesRepository gymMachinesRepository;
    @Autowired
    private ChestService chestService;
    @Autowired
    private BackService backService;

    @Autowired
    public GymMachinesService(GymMachinesRepository gymMachinesRepository) {
        this.gymMachinesRepository = gymMachinesRepository;
    }


    public Optional<GymMachines> createGymMachines(GymMachines gymMachines) {

        Optional<Chest> chest = chestService.getChestById(gymMachines.getChest().getChestId());
        Optional<Back> back = backService.getBackById((int)gymMachines.getBack().getBackId());
        if(chest.isPresent() && back.isPresent()) {

            gymMachines.setBack(back.get());
            gymMachines.setChest(chest.get());

            return Optional.of(gymMachinesRepository.save(gymMachines)) ;
        }
        return Optional.empty();
    }

    public Optional<GymMachines> getGymMachinesById(Integer gymMachineId) {
        Optional<GymMachines> optionalGymMachines = gymMachinesRepository.findById(gymMachineId);
        if(optionalGymMachines.isPresent()) {
            return Optional.of(optionalGymMachines.get());
        }else{
            return Optional.empty();
        }
    }

    public Optional<GymMachines> updateGymMachinesById(Integer id, GymMachines gymMachines) {
        Optional<Chest> chest = chestService.getChestById(gymMachines.getChest().getChestId());
        Optional<Back> back = backService.getBackById((int)gymMachines.getBack().getBackId());
        if(chest.isPresent() && back.isPresent()) {

            gymMachines.setBack(back.get());
            gymMachines.setChest(chest.get());
            gymMachines.setId(id);

            return Optional.of(gymMachinesRepository.save(gymMachines)) ;
        }
        return Optional.empty();
    }
    public void deleteGymMachinesById(Integer gymMachineId) {
          Optional<GymMachines> optionalGymMachines = gymMachinesRepository.findById(gymMachineId);
          if(optionalGymMachines.isPresent()) {
             gymMachinesRepository.deleteById(gymMachineId);
          }
    }
}
