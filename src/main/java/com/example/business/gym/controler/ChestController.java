package com.example.business.gym.controler;


import com.example.business.gym.entity.Chest;
import com.example.business.gym.service.impl.ChestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chests")
public class ChestController {

    private final ChestServiceImpl chestServiceImpl;

    @Autowired
    public ChestController(ChestServiceImpl chestServiceImpl){
        this.chestServiceImpl = chestServiceImpl;
    }
    @PostMapping
    public ResponseEntity<Chest> createChest(@RequestBody Chest chest){
        return ResponseEntity.ok(chestServiceImpl.createChest(chest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chest> getChestById(@PathVariable Long id) {
        return chestServiceImpl.getChestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChestById(@PathVariable Long id) {
        if (chestServiceImpl.deleteChestById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Chest> updateChestById(@PathVariable Long id, @RequestBody Chest chest){
        return ResponseEntity.ok(chestServiceImpl.updateChestById(id,chest));
    }
}
