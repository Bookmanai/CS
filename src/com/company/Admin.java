package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class Admin {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static  Socket socket;
    public static AdminMainFrame frame;

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",5999);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addCloth(clothes clothes){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Clothes");
        pd.setClothes(clothes);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addShoes(shoes shoes){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_shoes");
        pd.setShoes(shoes);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static ArrayList<clothes> listClothes(){
        ArrayList<clothes> clothes=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Books");
        pd.setCloth(clothes);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                clothes = pd.getCloth();
            }
        }catch (Exception e){e.printStackTrace();}
        return clothes;
    }
    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Books");
        pd.setId(id);
        ArrayList<clothes> clothes=pd.getCloth();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void showAddPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.listClothes.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.addClothes.setVisible(true);
        Admin.frame.repaint();
    }
    public static void showAddShoes(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.listClothes.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.addClothes.setVisible(false);
        Admin.frame.addClothes.setVisible(true);
        Admin.frame.repaint();
    }
    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.addClothes.setVisible(false);
        frame.deletePage.setVisible(false);
//        Admin.frame.addShoes.setVisible(false);
        frame.listClothes.setVisible(true);
        ArrayList<clothes> list = listClothes();
        Admin.frame.listClothes.updateArea(list);
    }

    public static void showDeletePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addClothes.setVisible(false);
        Admin.frame.listClothes.setVisible(false);
//        Admin.frame.addShoes.setVisible(false);
        ArrayList<clothes> list=listClothes();
//        frame.deletePage.updateArea(list);
        Admin.frame.deletePage.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMenuPage(){
        Admin.frame.addClothes.setVisible(false);
        Admin.frame.listClothes.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
//        Admin.frame.addShoes.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.repaint();
    }

    public static void main(String[] args){
        connectToServer();

        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}
