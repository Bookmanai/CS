package com.company;
import javax.swing.*;

public class AuthorizationMainFrame extends JFrame {
    public SignInPage addUser;
    public RegisterPage register;

    public AuthorizationMainFrame() {
        setTitle("USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        addUser = new SignInPage();
        addUser.setLocation(0, 0);
        addUser.setVisible(true);
        add(addUser);

        register = new RegisterPage();
        register.setLocation(0,0);
        register.setVisible(false);
        add(register);
    }
}



