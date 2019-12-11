package com.company;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class User {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static UserMainFrame frame;
    public static Socket  socket;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",5999);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addUser(UserData user){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_User");
        pd.setUser(user);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }


    public static void showMenuPage() {
        User.frame.addUser.setVisible(true);
        User.frame.regitr.setVisible(false);
        User.frame.repaint();
    }
    public static void showRegistrPage(){
        User.frame.addUser.setVisible(false);
        User.frame.regitr.setVisible(true);
        User.frame.repaint();
    }
//
//    public static ArrayList<magazine> listMagazines(){
//        ArrayList<magazine> reservs=new ArrayList<>();
//        PackageData pd=new PackageData();
//        pd.setOperationType("List_Magazines");
//        pd.setMagazines(reservs);
//        try {
//            outputStream.writeObject(pd);
//            if((pd = (PackageData) inputStream.readObject())!=null){
//                reservs =pd.getMagazines();
//            }
//        }catch (Exception e){e.printStackTrace();}
//        return reservs;
//    }
//
//    public static ArrayList<book> listRooms(){
//        ArrayList<book> rooms=new ArrayList<>();
//        PackageData pd=new PackageData();
//        pd.setOperationType("List_Books");
//        try {
//            outputStream.writeObject(pd);
//            if((pd=(PackageData)inputStream.readObject())!=null){
//                rooms=pd.getBooks();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return rooms;
//    }
//
//
//    public static void showListPage(){
//        User.frame.menu.setVisible(false);
//        User.frame.addmagazines.setVisible(false);
//        User.frame.listMagazines.setVisible(true);
//        ArrayList<magazine>list=listMagazines();
//        frame.listMagazines.updateArea(list);
//        User.frame.repaint();
//    }

    //    public static void showDeletePage(){
//        Cashier.frame.menu.setVisible(false);
//        Cashier.frame.addTickets.setVisible(false);
//        Cashier.frame.listTickets.setVisible(false);
//        ArrayList<Tickets> list=listTickets();
//        JScrollPane scrollPane=new JScrollPane();
//        frame.add(scrollPane);
//        frame.deleteTicket.updateArea(list);
//        Cashier.frame.deleteTicket.setVisible(true);
//        Cashier.frame.repaint();
//    }
    public static void main(String[] args){
        connectToServer();
        frame = new UserMainFrame();
        frame.setVisible(true);
    }
}
