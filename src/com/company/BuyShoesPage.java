package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyShoesPage extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton buy;
    private JButton back;

    public BuyShoesPage() {
        setLayout(null);
        setSize(700, 700);

        label = new JLabel("INSERT ID:");
        label.setBounds(250, 450, 80, 30);
        add(label);

        textField = new JTextField("");
        textField.setBounds(340, 450, 100, 30);
        add(textField);

        buy = new JButton("BUY");
        buy.setBounds(150, 500, 100, 50);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id;
                try {
                    id = Integer.parseInt(textField.getText());
                    UserService.buyShoes(id);
                    UserService.showMenuPage();
                    textField.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(buy);

        back = new JButton("BACK");
        back.setBounds(450, 500, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserService.showMenuPage();
            }
        });
        add(back);

    }


    public void updateArea(ArrayList<Shoes> shoes ) {

        String columnNames[] = new String[]{"ID", "NAME", "CATEGORY", "PRICE", "AMOUNT", "MODEL", "SIZE"};

        String data[][] = new String[shoes.size()][7];

        int i = 0;
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