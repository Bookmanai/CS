package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends Container {
    public JButton addClothes;
    public JButton addShoes;
    public JButton list;
    public JButton delete;
    public JButton exit;

    public AdminMainMenu() {
        setSize(700, 700);
        setLayout(null);
        addClothes = new JButton("Add Clothes");
        addClothes.setLocation(200, 150);
        addClothes.setSize(300, 30);
        addClothes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminService.showAddClothesPage();
            }
        });
        add(addClothes);


        addShoes = new JButton("Add Shoes");
        addShoes.setLocation(200, 190);
        addShoes.setSize(300, 30);
        addShoes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminService.showAddShoesPage();
            }
        }
        );
        add(addShoes);

        list = new JButton("List Items");
        list.setLocation(200, 230);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminService.showListPage();
            }
        });
        add(list);

        delete= new JButton("Delete Clothes");
        delete.setLocation(200, 270);
        delete.setSize(300, 30);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminService.showDeleteClothesPage();
            }
        });
        add(delete);

        delete= new JButton("Delete Shoes");
        delete.setLocation(200, 310);
        delete.setSize(300, 30);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminService.showDeleteShoesPage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setBounds(200, 350, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}
