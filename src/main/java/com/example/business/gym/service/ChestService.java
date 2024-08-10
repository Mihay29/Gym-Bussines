package com.example.business.gym.service;

import com.example.business.gym.entity.Back;
import com.example.business.gym.entity.Chest;

import java.util.Optional;

public interface ChestService {
    Optional<Chest> getChestById(Long id);
    Chest createChest(Chest chest);
    Chest updateChestById(Long id, Chest chest);
    boolean deleteChestById(Long id);
}
