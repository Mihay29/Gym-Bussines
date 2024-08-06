package com.example.business.gym.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long chestId;

    String type;
    float price;
    String accessories;

    public Chest() {}

    public long getChestId() {
        return chestId;
    }

    public void setChestId(long chestId) {
        this.chestId = chestId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }
}
