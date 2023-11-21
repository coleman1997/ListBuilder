package com.listbuilder.listbuilder.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
public class Unit {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;

    private int cost;

    public Unit(){}

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
