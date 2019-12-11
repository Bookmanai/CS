package com.company;

import java.io.Serializable;

public class Shoes extends Item implements Serializable {
    String model;
    int size;

    public Shoes(int size, String model) {
        this.size = size;
        this.model = model;
    }

    public Shoes(Integer id, String category, String name, int price, int amount, int size, String model) {
        super(id, category, name, price, amount);
        this.size = size;
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "model='" + model + '\'' +
                ", size=" + size +
                "} " + super.toString();
    }
}
