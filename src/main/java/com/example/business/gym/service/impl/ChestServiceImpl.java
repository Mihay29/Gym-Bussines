package com.example.business.gym.service.impl;


import com.example.business.gym.entity.Chest;
import com.example.business.gym.repository.ChestRepository;
import com.example.business.gym.service.ChestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChestServiceImpl implements ChestService {

    private final ChestRepository chestRepository;

    @Autowired
    public ChestServiceImpl(ChestRepository chestRepository){
        this.chestRepository = chestRepository;
    }

    @Override
    public Chest createChest(Chest chest){
        return chestRepository.save(chest);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Chest> getChestById(Long id){
        return chestRepository.findById(id);
    }

    @Transactional
    @Override
    public Chest updateChestById(Long id,Chest chest){
        return chestRepository.findById(id)
                .map(existingChest -> {
                    existingChest.setType(chest.getType());
                    existingChest.setAccessories(chest.getAccessories());
                    existingChest.setPrice(chest.getPrice());
                    return chestRepository.save(existingChest);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Chest not found with id " + id));
    }
    @Override
    public boolean deleteChestById(Long id){
        return chestRepository.findById(id)
                .map(existingChest -> {
                    chestRepository.delete(existingChest);
                    return true;
                })
                .orElse(false);
    }

}
