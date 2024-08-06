package com.example.business.gym.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class GymMachines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "chestId",nullable = false)
    private Chest chest;

    @ManyToOne
    @JoinColumn(name = "backId",nullable = false)
    private Back back;

   public GymMachines(){

   }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Back getBack() {
        return back;
    }

    public void setBack(Back back) {
        this.back = back;
    }
}
