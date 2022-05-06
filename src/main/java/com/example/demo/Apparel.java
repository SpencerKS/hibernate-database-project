package com.example.demo;

import javax.persistence.Entity;

@Entity
public class Apparel extends Product{
    private String type;
    private String brand;
    private String design;

    public Apparel() {
    }

    public Apparel(long id, String name, float price, String type, String brand, String design) {
        super(id, name, price);
        this.type = type;
        this.brand = brand;
        this.design = design;
    }

}
