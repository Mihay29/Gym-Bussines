package com.example.business.gym.service;

import com.example.business.gym.entity.Back;
import com.example.business.gym.repository.BackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BackService {

    @Autowired
    private BackRepository backRepository;

    public Back createBack(Back back){
        return backRepository.save(back);
    }

    public Optional<Back> getBackById(int id){
        Optional<Back> back = backRepository.findById(id);
        if(back.isPresent()){
            return Optional.of(back.get());
        }
        return Optional.empty();
    }

    public Optional<Back> updateBackById(Integer id,Back back){
       Optional<Back> back1 = getBackById(id);

        if(back1.isPresent()){
            Back back2 = back1.get();
            back2.setAccessories(back.getAccessories());
            back2.setPrice(back.getPrice());
            back2.setType(back.getType());
            return Optional.of(backRepository.save(back2));
        }else{
            return Optional.empty();
        }

    }

    public void deleteBackById(int id){
        Optional<Back> back = backRepository.findById(id);
        if(back.isPresent()){
            backRepository.delete(back.get());
        }else {
            throw new RuntimeException("Id not found");
        }
    }
}
