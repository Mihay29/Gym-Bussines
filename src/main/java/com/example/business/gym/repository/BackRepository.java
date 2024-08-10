package com.example.business.gym.repository;

import com.example.business.gym.entity.Back;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackRepository extends JpaRepository<Back, Integer> {
}
