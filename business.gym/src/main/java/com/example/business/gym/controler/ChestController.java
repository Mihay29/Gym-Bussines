package com.example.business.gym.controler;

import com.example.business.gym.entity.Chest;
import com.example.business.gym.service.ChestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chests")
public class ChestController {

    @Autowired
    private ChestService chestService;


    @PostMapping
    public Chest createChest(@RequestBody Chest chest) {
        return chestService.createChest(chest);
    }


    @GetMapping
    public Optional<Chest> getChestById(@PathVariable long id) {
        Optional<Chest> chest = chestService.getChestById(id);
        if (chest.isPresent()) {
            return Optional.of(chest.get());
        }else{
            return Optional.empty();
        }
    }
    @DeleteMapping
    public void  deleteChestById(@PathVariable long id) {
       chestService.deleteChest(id);
    }

    @PutMapping
    public Optional<Chest> updateChestById(@PathVariable long id, @RequestBody Chest chest) {
      return chestService.updateChestById(id,chest);
    }
}
