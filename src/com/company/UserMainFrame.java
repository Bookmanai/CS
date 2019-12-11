package com.company;

import javax.swing.*;

public class UserMainFrame extends JFrame {
    public UserMainMenu menu;
    public BuyClothesPage buyClothesPage;
    public BuyShoesPage buyShoesPage;

    public UserMainFrame() {
        setTitle("USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(null);
        setLocationRelativeTo(null);

        buyClothesPage = new BuyClothesPage();
        buyClothesPage.setLocation(0,0);
        buyClothesPage.setVisible(false);
        add(buyClothesPage);

        buyShoesPage = new BuyShoesPage();
        buyShoesPage.setLocation(0,0);
        buyShoesPage.setVisible(false);
        add(buyShoesPage);

        menu = new UserMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(true);
        add(menu);

        repaint();
    }
}
