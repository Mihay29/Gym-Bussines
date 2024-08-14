package com.example.business.gym.service;

import com.example.business.gym.entity.GymMachines;

import java.util.Optional;

public interface GymMachinesService {
    Optional<GymMachines> getGymMachinesById(int id);
    GymMachines createGymMachines(GymMachines gymMachines);
    GymMachines updateGymMachinesById(Integer id, GymMachines gymMachines);
    boolean deleteGymMachinesById(int id);

}
