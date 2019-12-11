package com.company;

import javax.lang.model.type.NullType;
import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String login;
    private String password;
    private String address;
    private String telephoneNumber;
    private boolean isAdmin;

    public User(Integer id, String login, String password, String address, String telephoneNumber, boolean isAdmin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
