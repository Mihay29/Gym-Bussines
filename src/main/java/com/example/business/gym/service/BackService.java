package com.example.business.gym.service;

import com.example.business.gym.entity.Back;
import com.example.business.gym.entity.Client;

import java.util.Optional;

public interface BackService {
    Optional<Back> getBackById(int id);
    Back createBack(Back back);
    Back updateBackById(Integer id, Back user);
    boolean deleteBackById(int id);
}
