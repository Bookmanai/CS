package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShoesPage extends Container {
    private JLabel Size;
    private JLabel name;
    private JTextField textName;
    private JLabel Model;
    private JTextField textModel;
    private JTextField textPrice;
    private JLabel description;
    private JTextField textDescription;
    private JLabel count;
    private JTextField textCount;
    private JLabel genre;
    private JComboBox comboBoxGenre;
    private JButton addClothes;
    private JButton back;
    private JSpinner sizeSpinner;

    public AddShoesPage() {
        setLayout(null);
        setSize(700, 700);

        name = new JLabel("Name:");
        name.setBounds(250, 150, 80, 40);
        add(name);
        textName = new JTextField();
        textName.setBounds(340, 150, 100, 40);
        add(textName);

        Model = new JLabel("Model:");
        Model.setBounds(250, 200, 80, 40);
        add(Model);

        textModel = new JTextField();
        textModel.setBounds(340, 200, 100, 40);
        add(textModel);

        JLabel labelPrice = new JLabel("Price:");
        labelPrice.setBounds(250, 250, 80, 40);
        add(labelPrice);

        textPrice = new JTextField();
        textPrice.setBounds(340, 250, 100, 40);
        add(textPrice);


        description = new JLabel("Description:");
        description.setBounds(250, 300, 80, 40);
        add(description);

        textDescription = new JTextField();
        textDescription.setBounds(340, 300, 200, 80);
        add(textDescription);

        count = new JLabel("Count:");
        count.setBounds(250, 400, 80, 40);
        add(count);

        textCount = new JTextField();
        textCount.setBounds(340, 400, 100, 40);
        add(textCount);


        Size = new JLabel("size:");
        Size.setBounds(250, 500, 80, 40);
        add(Size);

        SpinnerModel model =
                new SpinnerNumberModel(30, //initial value
                        1, //min
                        60, //max
                        1);                //step
        sizeSpinner = new JSpinner(model);
        sizeSpinner.setBounds(340, 500, 100, 40);
        add(sizeSpinner);

        genre = new JLabel("Genre");
        genre.setBounds(250, 600, 80, 40);
        add(genre);

        comboBoxGenre = new JComboBox();
        comboBoxGenre.setBounds(340, 600, 100, 40);
        comboBoxGenre.addItem("Adult-Male");
        comboBoxGenre.addItem("Adult-Female");
        comboBoxGenre.addItem("Kid");
        comboBoxGenre.addItem("Teen");
        add(comboBoxGenre);


        addClothes = new JButton("Add");
        addClothes.setBounds(250, 550, 100, 50);
        addClothes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Shoes shoes= new Shoes (null, comboBoxGenre.getSelectedItem().toString(),textName.getText(), Integer.parseInt(textPrice.getText()),Integer.parseInt(textCount.getText()),(int)sizeSpinner.getValue(),textModel.getText());
                    AdminService.addShoes(shoes);
                    textName.setText("");
                    textCount.setText("");
                    textPrice.setText("");
                    textModel.setText("");
                    textDescription.setText("");
                    textPrice.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addClothes);

        back = new JButton("Back");
        back.setBounds(360, 600, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminService.frame.addShoesPage.setVisible(false);
                AdminService.frame.listItems.setVisible(false);
                AdminService.frame.deletePage.setVisible(false);
                AdminService.frame.menu.setVisible(true);
                AdminService.frame.repaint();
            }
        });
        add(back);
    }
}

