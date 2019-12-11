package com.company;
import javax.swing.*;

public class AdminMainFrame extends JFrame {
    public AddClothesPage addClothes;
    public AddShoesPage addShoesPage;
    public ListItemsPage listItems;
    public DeleteClothesPage deletePage;
    public DeleteShoesPage deleteShoesPage;
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

        addClothes = new AddClothesPage();
        addClothes.setLocation(0,0);
        addClothes.setVisible(false);
        add(addClothes);

        addShoesPage = new AddShoesPage();
        addShoesPage.setLocation(0,0);
        addShoesPage.setVisible(false);
        add(addShoesPage);

        listItems = new ListItemsPage();
        listItems.setLocation(0,0);
        listItems.setVisible(false);
        add(listItems);

        deletePage=new DeleteClothesPage();
        deletePage.setLocation(0,0);
        deletePage.setVisible(false);
        add(deletePage);

        deleteShoesPage=new DeleteShoesPage();
        deleteShoesPage.setLocation(0,0);
        deleteShoesPage.setVisible(false);
        add(deleteShoesPage);

        repaint();
    }
}
