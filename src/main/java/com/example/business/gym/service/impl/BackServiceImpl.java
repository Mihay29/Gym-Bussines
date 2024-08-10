package com.example.business.gym.service.impl;

import com.example.business.gym.entity.Back;

import com.example.business.gym.repository.BackRepository;
import com.example.business.gym.service.BackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


@Service
public class BackServiceImpl implements BackService {

    private final BackRepository backRepository;
    @Autowired
    public BackServiceImpl(BackRepository backRepository){
        this.backRepository = backRepository;
    }
    @Override
    public Back createBack(Back back){
        return backRepository.save(back);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Back> getBackById(int id){
        return backRepository.findById(id);
    }

    @Transactional
    @Override
    public Back updateBackById(Integer id,Back back){
        return backRepository.findById(id)
                .map(existingBack -> {
                    existingBack.setType(back.getType());
                    existingBack.setAccessories(back.getAccessories());
                    existingBack.setPrice(back.getPrice());
                    return backRepository.save(existingBack);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Back not found with id " + id));
    }
    @Override
    public boolean deleteBackById(int id){
        return backRepository.findById(id)
                .map(back -> {
                    backRepository.delete(back);
                    return true;
                })
                .orElse(false);
    }
}
