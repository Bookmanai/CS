package com.company;

import java.io.Serializable;

public class shoes extends clothingstore implements Serializable {
    int size;
    String model;

//    public shoes(int size, String model) {
//        this.size = size;
//        this.model = model;
//    }

    public shoes(Long id, String product, String genre, String name, int price, int sold, int count, int size, String model) {
        super(id, product, genre, name, price, sold, count);
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
        return "shoes{" +
                "size=" + size +
                ", model='" + model + '\'' +
                '}';
    }
}
