package com.company;

import java.io.Serializable;

public class Item implements Serializable{
        private Integer id;
        private String category;
        private String name;
        private int price;
        private int amount;

    public Item() {
    }

    public Item(Integer id, String category, String name, int price, int amount) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
