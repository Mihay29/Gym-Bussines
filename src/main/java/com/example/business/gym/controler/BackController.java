package com.example.business.gym.controler;

import com.example.business.gym.entity.Back;
import com.example.business.gym.service.impl.BackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/back")
public class BackController {


    private final BackServiceImpl backServiceImpl;
    @Autowired
    public BackController(BackServiceImpl backServiceImpl){
        this.backServiceImpl = backServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Back> createBack(@RequestBody Back back){
        return ResponseEntity.ok(backServiceImpl.createBack(back));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Back> getBackById(@PathVariable Integer id) {
        return backServiceImpl.getBackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Back> updateBackById(@PathVariable Integer id, @RequestBody Back back){
        return ResponseEntity.ok(backServiceImpl.updateBackById(id,back));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBackById(@PathVariable Integer id) {
        if (backServiceImpl.deleteBackById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
