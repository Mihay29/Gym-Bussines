package com.example.business.gym.service;

import com.example.business.gym.entity.Chest;
import com.example.business.gym.repository.ChestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChestService {

    @Autowired
    private ChestRepository chestRepository;

    public Chest createChest(Chest chest) {
        return chestRepository.save(chest);
    }

    public Optional<Chest>  getChestById(Long id) {
        Optional<Chest> chest = chestRepository.findById(id);
        if(chest.isPresent()) {
            return Optional.of(chest.get());
        }
        return Optional.empty();
    }

    public Optional<Chest> updateChestById(Long id,Chest chest) {
        Optional<Chest> chestOptional = getChestById(id);
        if(chestOptional.isPresent()) {
            Chest oldChest = chestOptional.get();
            oldChest.setAccessories(chest.getAccessories());
            oldChest.setPrice(chest.getPrice());
            oldChest.setType(chest.getType());
            oldChest.setChestId(chest.getChestId());
            return Optional.of(chestRepository.save(oldChest));
        }
        return Optional.empty();

    }

    public void deleteChest(Long id) {
        Optional<Chest> chestOptional = getChestById(id);
        if(chestOptional.isPresent()) {
            chestRepository.delete(chestOptional.get());
        }
    }

}
