package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AdminService {
    public static AdminMainFrame frame;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public AdminService(ObjectOutputStream _outputStream,ObjectInputStream _inputStream) {
        frame = new AdminMainFrame();
        frame.setVisible(false);
        outputStream = _outputStream;
        inputStream = _inputStream;
    }

    public static void addCloth(Clothes clothes){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Clothes");
        pd.setClothes(clothes);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void addShoes(Shoes shoe){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_shoes");
        pd.setShoe(shoe);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
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
    public static void deleteShoesWithId(Integer id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Shoes");
        pd.setId(id);
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void deleteClothesWithId(Integer id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Clothes");
        pd.setId(id);
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void showAddClothesPage(){
        AdminService.frame.menu.setVisible(false);
        AdminService.frame.addClothes.setVisible(true);
        AdminService.frame.repaint();
    }
    public static void showAddShoesPage(){
        AdminService.frame.menu.setVisible(false);
        AdminService.frame.addShoesPage.setVisible(true);
        AdminService.frame.repaint();
    }
    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.listItems.setVisible(true);
        ArrayList<Clothes> clothes = listClothes();
        ArrayList<Shoes> shoes = listShoes();
        AdminService.frame.listItems.updateArea(clothes,shoes);
    }

    public static void showDeleteShoesPage(){
        AdminService.frame.menu.setVisible(false);
        AdminService.frame.deleteShoesPage.setVisible(true);
        ArrayList<Shoes> shoes = listShoes();
        AdminService.frame.deleteShoesPage.updateArea(shoes);
        AdminService.frame.repaint();
    }

    public static void showDeleteClothesPage(){
        AdminService.frame.menu.setVisible(false);
        AdminService.frame.deletePage.setVisible(true);
        ArrayList<Clothes> clothes = listClothes();
        AdminService.frame.deletePage.updateArea(clothes);
        AdminService.frame.repaint();
    }

    public static void showMenuPage(){
        AdminService.frame.addClothes.setVisible(false);
        AdminService.frame.deletePage.setVisible(false);
        AdminService.frame.addShoesPage.setVisible(false);
        AdminService.frame.deleteShoesPage.setVisible(false);
        AdminService.frame.addClothes.setVisible(false);
        AdminService.frame.listItems.setVisible(false);
        AdminService.frame.menu.setVisible(true);
        AdminService.frame.repaint();
    }
}
