package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListItemsPage extends Container {
    private JLabel label;
    private JButton btn;
    private JTable table;

    public ListItemsPage(){
        setLayout(null);
        setSize(700,700);

        label=new JLabel("List");
        label.setBounds(320,10,150,60);
        add(label);

        btn = new JButton("Back");
        btn.setLocation(210,600);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminService.showMenuPage();
            }
        });
        add(btn);
    }

    public void updateArea(ArrayList<Clothes> clothes,ArrayList<Shoes> shoes) {
        String columnNames[] = new String[]{"ID", "NAME", "CATEGORY", "PRICE", "AMOUNT", "MODEL", "SIZE"};

        String data[][] = new String[clothes.size()+shoes.size()][7];

        int i = 0;
        for (Clothes st : clothes) {
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getName();
            data[i][2] = st.getCategory();
            data[i][3] = String.valueOf(st.getPrice());
            data[i][4] = String.valueOf(st.getAmount());
            data[i][5] = st.getModel();
            data[i][6] = st.getSize();
            i++;
        }
        for (Shoes st : shoes) {
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getName();
            data[i][2] = st.getCategory();
            data[i][3] = String.valueOf(st.getPrice());
            data[i][4] = String.valueOf(st.getAmount());
            data[i][5] = st.getModel();
            data[i][6] = String.valueOf(st.getSize());
            i++;
        }
        table = new JTable(data, columnNames);
        table.setBounds(70, 80, 500, 500);

        add(table);
        repaint();
    }
}
