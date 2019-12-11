package com.company;

import java.io.Serializable;

public class clothes extends clothingstore implements Serializable {
    private String model;
    private String size;

    public clothes(Long id, String name, String clothes, int sold, String size, String genre, int count, int price, String model, int i, int count1) {
    }
//
//    public clothes(String model, String size) {
//        this.model = model;
//        this.size = size;
//    }

    public clothes(Long id, String product, String genre, String name, int price, int sold, int count, String model, String size) {
        super(id, product, genre, name, price, sold, count);
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
        return "clothes{" +
                "model='" + model + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
