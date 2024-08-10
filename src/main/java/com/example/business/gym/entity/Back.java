package com.example.business.gym.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Back {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long backId;

    private String type;
    private float price;
    private String accessories;

}
