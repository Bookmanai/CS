package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<shoes> shoe;
    ArrayList<clothes> cloth;
    UserData user;
    ArrayList<UserData> users;
    shoes shoes;
    clothes clothes;
    Long id;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<com.company.shoes> shoe, ArrayList<com.company.clothes> cloth, UserData user, ArrayList<UserData> users, com.company.shoes shoes, com.company.clothes clothes, Long id) {

        this.operationType = operationType;
        this.shoe = shoe;
        this.cloth = cloth;
        this.user = user;
        this.users = users;
        this.shoes = shoes;
        this.clothes = clothes;
        this.id = id;
    }
//

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<shoes> getShoe() {
        return shoe;
    }

    public void setShoe(ArrayList<com.company.shoes> shoe) {
        this.shoe = shoe;
    }

    public ArrayList<com.company.clothes> getCloth() {
        return cloth;
    }

    public void setCloth(ArrayList<com.company.clothes> cloth) {
        this.cloth = cloth;
    }

    public com.company.shoes getShoes() {
        return shoes;
    }

    public void setShoes(com.company.shoes shoes) {
        this.shoes = shoes;
    }

    public com.company.clothes getClothes() {
        return clothes;
    }

    public void setClothes(com.company.clothes clothes) {
        this.clothes = clothes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public ArrayList<UserData> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserData> users) {
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
                ", shoes=" + shoes +
                ", clothes=" + clothes +
                ", id=" + id +
                '}';
    }
}
