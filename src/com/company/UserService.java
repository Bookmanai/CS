package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserService {
    public static UserMainFrame frame;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public UserService(ObjectOutputStream _outputStream,ObjectInputStream _inputStream) {
        frame = new UserMainFrame();
        frame.setVisible(false);
        outputStream = _outputStream;
        inputStream = _inputStream;
    }


    public static ArrayList<Clothes> listClothes(){
        ArrayList<Clothes> clothes=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Clothes");
        pd.setCloth(clothes);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                clothes = pd.getCloth();
            }
        }catch (Exception e){e.printStackTrace();}
        return clothes;
    }

    public static ArrayList<Shoes> listShoes(){
        ArrayList<Shoes> shoes=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Shoes");
        pd.setShoes(shoes);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                shoes = pd.getShoes();
            }
        }catch (Exception e){e.printStackTrace();}
        return shoes;
    }

    public static void buyClothes(Integer id){
        PackageData pd=new PackageData();
        pd.setOperationType("Buy_Clothes");
        pd.setId(id);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void buyShoes(Integer id){
        PackageData pd=new PackageData();
        pd.setOperationType("Buy_Shoes");
        pd.setId(id);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void showAddClothesPage(){
        UserService.frame.menu.setVisible(false);
        UserService.frame.buyClothesPage.setVisible(true);
        ArrayList<Clothes> clothes = listClothes();
        UserService.frame.buyClothesPage.updateArea(clothes);
        UserService.frame.repaint();
    }
    public static void showAddShoesPage(){
        UserService.frame.menu.setVisible(false);
        UserService.frame.buyShoesPage.setVisible(true);
        ArrayList<Shoes> shoes = listShoes();
        UserService.frame.buyShoesPage.updateArea(shoes);
        UserService.frame.repaint();
    }

    public static void showMenuPage(){
        UserService.frame.buyClothesPage.setVisible(false);
        UserService.frame.buyShoesPage.setVisible(false);
        UserService.frame.menu.setVisible(true);
        UserService.frame.repaint();
    }
}
