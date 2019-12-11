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
    public static Long id=null;

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
                        clothes clothes= pd.getClothes();
                        addClothes(clothes);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_shoes")){
                    try {
                        shoes shoes = pd.getShoe().get(0);
                        addShoes(shoes);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Clothes")){
                    ArrayList<clothes> clothes = getAllClothes();
                    PackageData resp = new PackageData();
                    resp.setCloth(clothes);
                    outputStream.writeObject(resp);
                }
                else if(pd.getOperationType().equals("List_Shoes")){
                    ArrayList<shoes> shoe = getAllShoes();
                    PackageData pd2=new PackageData();
                    pd2.setShoe(shoe);
                    outputStream.writeObject(pd2);
                }
                else if(pd.getOperationType().equals("Delete_Clothes")){
                    Long id=pd.getId();
                    deleteclothesToDB(id);
                }
                else if(pd.getOperationType().equals("Add_User")){
                    try {
                        UserData user = pd.getUser();
                        addUser(user);
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


    public void addShoes(shoes shoes){
        try {
            id=id+1;
            PreparedStatement ps = connection.prepareStatement("INSERT INTO shoes (id, name,model,price,sold,count,size,genre) VALUES(?, ?, ?,?,?,?,?,?)");
            ps.setLong(1, shoes.getId());
            ps.setString(2,shoes.getName());
            ps.setInt(3,shoes.getPrice());
            ps.setInt(4, shoes.getSold());
            ps.setString(8,shoes.getGenre());
            ps.setInt(5,shoes.getCount());
            ps.setString(6,shoes.getModel());
            ps.setInt(7, shoes.getSize());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(UserData user){
        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO user (login, password,address,telephoneNumber) VALUES(?,?,?,?)");
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


    public void addClothes(clothes  clothes){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO clothes (id, name,model,price,sold,count,size,genre) VALUES(NULL, ?, ?,?,?,?,?,?)");
            ps.setLong(1, clothes.getId());
            ps.setString(2,clothes.getName());
            ps.setInt(3,clothes.getPrice());
            ps.setInt(4, clothes.getSold());
            ps.setString(8,clothes.getGenre());
            ps.setInt(5,clothes.getCount());
            ps.setString(6, clothes.getModel());
            ps.setString(7,clothes.getSize());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<clothes> getAllClothes(){
        ArrayList<clothes> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from clothes");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int sold = rs.getInt("sold");
                String size = rs.getString("size");
                String genre=rs.getString("genre");
                String model =rs.getString("model");
                int price=rs.getInt("price");
                int count= rs.getInt("count");





                list.add(new clothes(id,name,"clothes",sold,size,genre, count,price,model, price,count));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<shoes> getAllShoes(){
        ArrayList<shoes> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from shoes");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int sold = rs.getInt("sold");
                int size = rs.getInt("size");
                String genre=rs.getString("genre");
                String model =rs.getString("model");
                int price=rs.getInt("price");
                int count= rs.getInt("count");


                list.add(new shoes(id,"shoes", genre,name, price, sold, count,size, model ));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return list;
    }


    public void deleteclothesToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM clothes WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteshoesToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM shoes WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
