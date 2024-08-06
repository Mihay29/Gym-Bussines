package com.example.business.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "back")
public class Back {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long backId;

    String type;
    float price;
    String accessories;

    public Back() {}


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

    public long getBackId() {
        return backId;
    }

    public void setBackId(long backId) {
        this.backId = backId;
    }
}
