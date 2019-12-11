package com.company;

import java.io.Serializable;

public class Clothes extends Item implements Serializable {
    private String model;
    private String size;

    public Clothes(String model, String size) {
        this.model = model;
        this.size = size;
    }

    public Clothes(Integer id, String category, String name, int price, int amount, String model, String size) {
        super(id, category, name, price, amount);
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "model='" + model + '\'' +
                ", size='" + size + '\'' +
                "} " + super.toString();
    }
}
