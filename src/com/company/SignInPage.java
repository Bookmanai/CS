package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInPage extends Container {
    private JLabel login;
    private JTextField textLogin;
    private JPasswordField textpassword;
    private JLabel password;
    private JButton signIn;
    private JButton register;
    private JLabel error;

    public SignInPage() {
        setLayout(null);
        setSize(700, 700);

        login = new JLabel("Login:");
        login.setBounds(250, 150, 80, 40);
        add(login);
        textLogin = new JTextField();
        textLogin.setBounds(340, 150, 100, 40);
        add(textLogin);

        error = new JLabel("Wrong password or login!");
        error.setBounds(250, 250, 80, 40);
        error.setVisible(false);
        add(error);
        password = new JLabel("Password:");
        password.setBounds(250, 200, 80, 40);
        add(password);

        textpassword = new JPasswordField();
        textpassword.setBounds(340, 200, 100, 40);
        add(textpassword);

        signIn=new JButton("Sign in");
        signIn.setBounds(340,250,100,50);
        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User(null,textLogin.getText(),textpassword.getText(),null, null, false);
                    user = AuthorizationService.signIn(user);
                    textLogin.setText("");
                    textpassword.setText("");
                    if(user!=null){
                        if(!user.isAdmin()){
                            UserService.frame.setVisible(true);
                            UserService.showMenuPage();
                        }
                        else {
                            AdminService.frame.setVisible(true);
                        }
                        AuthorizationService.frame.setVisible(false);
                    }
                    else error.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(signIn);
        register =new JButton("Register");
        register.setBounds(340,310,100,50);
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AuthorizationService.showRegisterPage();
            }
        });
        add(register);
    }
}
