package com.company;
import javafx.css.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddPage extends Container {
    private JLabel Size;
    private JLabel name;
    private JTextField textName;
    private JLabel Model;
    private JTextField textModel;
    private JLabel labelSold;
    private JTextField textPrice;
    private JLabel description;
    private JTextField textDescription;
    private JLabel count;
    private JTextField textGraduate;
    private JLabel graduate;
    private JTextField textCount;
    private JLabel genre;
    private JComboBox comboBoxGenre;

    private JButton addBooks;
    private JButton back;

    public AdminAddPage() {
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



        labelSold= new JLabel("Sold:");
        labelSold.setBounds(250, 250, 80, 40);
        add(labelSold);

        JTextField textSold = new JTextField();
        textSold.setBounds(340, 250, 100, 40);
        add(textSold);

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
        Size.setBounds(250, 400, 80, 40);
        add(Size);

        JTextField textSize = new JTextField();
        textSize.setBounds(340, 400, 100, 40);
        add(textSize);

        genre = new JLabel("Genre");
        genre.setBounds(250, 500, 80, 40);
        add(genre);

        comboBoxGenre = new JComboBox();
        comboBoxGenre.setBounds(340, 500, 100, 40);
        comboBoxGenre.addItem("Adult-Male");
        comboBoxGenre.addItem("Adult-Female");
        comboBoxGenre.addItem("Kid");
        comboBoxGenre.addItem("Teen");
        add(comboBoxGenre);


        addBooks = new JButton("Add");
        addBooks.setBounds(250, 550, 100, 50);
        addBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//null, textName.getText(), "Book",0,comboBoxGenre.getSelectedItem().toString(),  Integer.parseInt(textCount.getText()),
// Integer.parseInt(textPrice.getText()),textModel.getText(), Integer.parseInt(textGraduate.getText()),textDescription.getText());
// Long id, String product, String genre, String name, int price, int sold, int count, String model, String size
                try {
                    clothes clothes= new clothes (null, textName.getText(),comboBoxGenre.getSelectedItem().toString(), textName.getText(), Integer.parseInt(textPrice.getText()),Integer.parseInt(textSold.getText()), Integer.parseInt(textSold.getText()),textModel.getText(), textSize.getText());
                    Admin.addCloth(clothes);
                    textName.setText("");
                    textCount.setText("");
                    textPrice.setText("");
                    textModel.setText("");
                    textGraduate.setText("");
                    textDescription.setText("");
                    textPrice.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addBooks);

        back = new JButton("Back");
        back.setBounds(360, 600, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frame.addClothes.setVisible(false);
                Admin.frame.listClothes.setVisible(false);
                Admin.frame.deletePage.setVisible(false);
                Admin.frame.menu.setVisible(true);
                Admin.frame.repaint();
            }
        });
        add(back);
    }
}

