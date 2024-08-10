package com.example.business.gym.service.impl;

import com.example.business.gym.entity.Back;
import com.example.business.gym.entity.Chest;
import com.example.business.gym.entity.GymMachines;
import com.example.business.gym.repository.GymMachinesRepository;
import com.example.business.gym.service.GymMachinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GymMachinesServiceImpl implements GymMachinesService {

    private final GymMachinesRepository gymMachinesRepository;
    private final ChestServiceImpl chestServiceImpl;
    private final BackServiceImpl backServiceImpl;

    @Autowired
    public GymMachinesServiceImpl(GymMachinesRepository gymMachinesRepository,
                              ChestServiceImpl chestServiceImpl,
                              BackServiceImpl backServiceImpl) {
        this.gymMachinesRepository = gymMachinesRepository;
        this.chestServiceImpl = chestServiceImpl;
        this.backServiceImpl = backServiceImpl;
    }


    public GymMachines createGymMachines(GymMachines gymMachines) {

        Chest chest = chestServiceImpl.getChestById(gymMachines.getChest().getChestId()).orElseThrow(()-> new RuntimeException("Not found"));
        Back back = backServiceImpl.getBackById((int)gymMachines.getBack().getBackId()).orElseThrow(()->new RuntimeException("Not found"));

        gymMachines.setBack(back);
        gymMachines.setChest(chest);
        return gymMachinesRepository.save(gymMachines);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<GymMachines> getGymMachinesById(int id){
        return gymMachinesRepository.findById(id);
    }

    @Transactional
    @Override
    public GymMachines updateGymMachinesById(Integer id, GymMachines gymMachines) {
        Chest chest = chestServiceImpl.getChestById(gymMachines.getChest().getChestId()).orElseThrow(()->new RuntimeException("Not found"));
        Back back = backServiceImpl.getBackById((int)gymMachines.getBack().getBackId()).orElseThrow(()->new RuntimeException("Not found"));

        gymMachines.setBack(back);
        gymMachines.setChest(chest);
        gymMachines.setId(id);

        return gymMachinesRepository.save(gymMachines);
    }
    @Override
    public boolean deleteGymMachinesById(int id){
        return gymMachinesRepository.findById(id)
                .map(existingGymMachines -> {
                    gymMachinesRepository.delete(existingGymMachines);
                    return true;
                })
                .orElse(false);
    }
}
