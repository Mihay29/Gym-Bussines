package com.example.business.gym.repository;

import com.example.business.gym.entity.GymMachines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMachinesRepository extends JpaRepository<GymMachines, Integer> {
}
