package com.company;
import javax.swing.*;

public class AdminMainFrame extends JFrame {
    public AdminAddPage addClothes;
//    public AdminAddMagazine addShoes;
    public AdminListPage listClothes;
    public AdminDeletePage deletePage;
    public AdminMainMenu menu;
    public AdminMainFrame(){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);


        menu = new AdminMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(true);
        add(menu);

        addClothes = new AdminAddPage();
        addClothes.setLocation(0,0);
        addClothes.setVisible(false);
        add(addClothes);

//        addShoes = new AdminAddMagazine();
//        addShoes.setLocation(0,0);
//        addShoes.setVisible(false);
//        add(addShoes);

        listClothes = new AdminListPage();
        listClothes.setLocation(0,0);
        listClothes.setVisible(false);
        add(listClothes);

        deletePage=new AdminDeletePage();
        deletePage.setLocation(0,0);

        deletePage.setVisible(false);
        add(deletePage);

        repaint();
    }
}
