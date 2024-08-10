package com.example.business.gym.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GymMachines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "chestId",nullable = false)
    private Chest chest;

    @ManyToOne
    @JoinColumn(name = "backId",nullable = false)
    private Back back;

}
