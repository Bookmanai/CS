package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject())!=null) {

                if (pd.getOperationType().equals("Add_Clothes")) {
                    try {
                        Clothes clothes= pd.getClothes();
                        addClothes(clothes);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_shoes")){
                    try {
                        Shoes shoes = pd.getShoe();
                        addShoes(shoes);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Buy_Clothes")) {
                    try {
                        buyClothes(pd.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Buy_Shoes")) {
                    try {
                        buyShoes(pd.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Clothes")) {
                    try {
                        ArrayList<Clothes> clothes = getAllClothes();
                        PackageData resp = new PackageData();
                        resp.setCloth(clothes);
                        outputStream.writeObject(resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Shoes")) {
                    try {
                        ArrayList<Shoes> shoe = getAllShoes();
                        PackageData pd2 = new PackageData();
                        pd2.setShoes(shoe);
                        outputStream.writeObject(pd2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Delete_Clothes")){
                    try {
                        Integer id = pd.getId();
                        deleteClothesToDB(id);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Delete_Shoes")){
                    try {
                        Integer id = pd.getId();
                        deleteShoesToDB(id);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_User")){
                    try {
                        User user = pd.getUser();
                        addUser(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Sign_in")){
                    try {
                        User user = pd.getUser();
                        user = signIn(user);
                        PackageData resp = new PackageData();
                        resp.setUser(user);
                        outputStream.writeObject(resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public User signIn(User user){
        User userData = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from users WHERE login = ? and password = ?");
            ps.setString(1,user.getLogin());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                boolean isAdmin = rs.getBoolean("isAdmin");
                userData = new User(id, login, password, address, phone, isAdmin);
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }


    public void addShoes(Shoes shoes){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO shoes (id, name,category,price,amount,model,size) VALUES(NULL, ?, ?,?,?,?,?)");
            ps.setString(1,shoes.getName());
            ps.setInt(3,shoes.getPrice());
            ps.setString(2,shoes.getCategory());
            ps.setInt(4,shoes.getAmount());
            ps.setString(5,shoes.getModel());
            ps.setInt(6, shoes.getSize());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(User user){
        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (id,login, password,address,phone,isAdmin) VALUES(NULL,?,?,?,?,0)");
            ps.setString(1, user.getLogin());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getAddress());
            ps.setString(4, user.getTelephoneNumber());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addClothes(Clothes clothes){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO clothes (id, name,category,price,amount,model,size) VALUES(NULL, ?, ?,?,?,?,?)");
            ps.setString(1,clothes.getName());
            ps.setInt(3,clothes.getPrice());
            ps.setString(2,clothes.getCategory());
            ps.setInt(4,clothes.getAmount());
            ps.setString(5,clothes.getModel());
            ps.setString(6, clothes.getSize());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Clothes> getAllClothes(){
        ArrayList<Clothes> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from clothes");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String size = rs.getString("size");
                String category=rs.getString("category");
                String model =rs.getString("model");
                int price=rs.getInt("price");
                int amount= rs.getInt("amount");

                list.add(new Clothes(id,name,category,price,amount, model, size));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Shoes> getAllShoes(){
        ArrayList<Shoes> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from shoes");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                int size = rs.getInt("size");
                String category=rs.getString("category");
                String model =rs.getString("model");
                int price=rs.getInt("price");
                int amount= rs.getInt("amount");


                list.add(new Shoes(id,name,category,price,amount, size,model));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return list;
    }

    public void buyClothes(Integer id){
        try{
            PreparedStatement ps=connection.prepareStatement("UPDATE clothes SET amount= amount-1 WHERE id=?");
            ps.setInt(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void buyShoes(Integer id){
        try{
            PreparedStatement ps=connection.prepareStatement("UPDATE shoes SET amount= amount-1 WHERE id=?");
            ps.setInt(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteClothesToDB(Integer id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM clothes WHERE id=?");
            ps.setInt(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteShoesToDB(Integer id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM shoes WHERE id=?");
            ps.setInt(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
