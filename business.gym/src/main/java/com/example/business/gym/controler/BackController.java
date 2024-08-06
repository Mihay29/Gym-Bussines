package com.example.business.gym.controler;

import com.example.business.gym.entity.Back;
import com.example.business.gym.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/back")
public class BackController {

    @Autowired
    BackService backService;

    @PostMapping("/saveBack")
    public Back saveBack(@RequestBody Back back) {
       return backService.createBack(back);
    }

    @GetMapping("/{id}")
    public Optional<Back> getBackById(@PathVariable int id) {
     Optional<Back> back = backService.getBackById(id);
     if(back.isPresent()) {
         return Optional.of(back.get());
     }else {
         return Optional.empty();
     }
    }

    @PutMapping("/{id}")
    public Optional<Back> updateBackById(@PathVariable int id, @RequestBody Back back) {
        return backService.updateBackById(id,back);
    }

    @DeleteMapping({"/{id}"})
    public void deleteBackById(@PathVariable int id) {
        backService.deleteBackById(id);
    }

}
