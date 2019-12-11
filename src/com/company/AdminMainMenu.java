package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends Container {
    public JButton addd;
    public JButton addShoes;
    public JButton list;
    public JButton delete;
    public JButton exit;

    public AdminMainMenu() {
        setSize(700, 700);
        setLayout(null);
        addd = new JButton("Add All");
        addd.setLocation(200, 150);
        addd.setSize(300, 30);
        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddPage();
            }
        });
        add(addd);


//        addShoes = new JButton("Add_Magazine");
//        addShoes.setLocation(200, 190);
//        addShoes.setSize(300, 30);
//        addShoes.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Admin.showAddShoes;
//            }
//        }
//        );
        add(addShoes);

        list = new JButton("List_Books");
        list.setLocation(200, 230);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showListPage();
            }
        });
        add(list);

        delete= new JButton("Delete_Books");
        delete.setLocation(200, 270);
        delete.setSize(300, 30);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeletePage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setBounds(200, 310, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}
