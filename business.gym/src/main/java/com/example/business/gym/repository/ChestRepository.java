package com.example.business.gym.repository;

import com.example.business.gym.entity.Chest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChestRepository extends JpaRepository<Chest, Long> {

}
