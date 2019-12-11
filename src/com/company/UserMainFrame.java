package com.company;
import javax.swing.*;
import java.awt.*;

public class UserMainFrame extends JFrame {
    public UserAdd addUser;
    public UserRegistr regitr;

    //    public UserListPage listMagazines;
//    public UserMainMenu menu;
//
    public UserMainFrame() {
        setTitle("USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        addUser = new UserAdd();
        addUser.setLocation(0, 0);
        addUser.setVisible(true);
        add(addUser);

        regitr=new UserRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);
//
//        addmagazines = new UserAddPage();
//        addmagazines.setLocation(0,0);
//        addmagazines.setVisible(false);
//        add(addmagazines);
//
//        listMagazines= new UserListPage();
//        listMagazines.setLocation(0,0);
//        listMagazines.setVisible(false);
//        add(listMagazines);
//
//        repaint();
    }
}



