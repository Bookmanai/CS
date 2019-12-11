package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainMenu extends Container {
    public JButton buyClothes;
    public JButton buyShoes;
    public JButton exit;

    public UserMainMenu() {
        setSize(700, 700);
        setLayout(null);

        buyClothes = new JButton("Buy Clothes");
        buyClothes.setLocation(200, 150);
        buyClothes.setSize(300, 30);
        buyClothes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserService.showAddClothesPage();
            }
        });
        add(buyClothes);


        buyShoes = new JButton("Buy Shoes");
        buyShoes.setLocation(200, 190);
        buyShoes.setSize(300, 30);
        buyShoes.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           UserService.showAddShoesPage();
                                       }
                                   }
        );
        add(buyShoes);

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
