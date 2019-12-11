package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Shoes> shoes;
    ArrayList<Clothes> cloth;
    User user;
    ArrayList<User> users;
    Shoes shoe;
    Clothes clothes;
    Integer id;

    public PackageData() {
    }


    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }

    public ArrayList<Clothes> getCloth() {
        return cloth;
    }

    public void setCloth(ArrayList<Clothes> cloth) {
        this.cloth = cloth;
    }

    public Shoes getShoe() {
        return shoe;
    }

    public void setShoe(Shoes shoes) {
        this.shoe = shoes;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }



    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", shoe=" + shoe +
                ", cloth=" + cloth +
                ", user=" + user +
                ", users=" + users +
                ", Shoes=" + shoes +
                ", Clothes=" + clothes +
                ", id=" + id +
                '}';
    }
}
