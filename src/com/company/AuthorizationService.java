package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AuthorizationService {
    public static AuthorizationMainFrame frame;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public AuthorizationService(ObjectOutputStream _outputStream, ObjectInputStream _inputStream) {
        frame = new AuthorizationMainFrame();
        frame.setVisible(true);
        outputStream = _outputStream;
        inputStream = _inputStream;
    }

    public static void addUser(User user){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_User");
        pd.setUser(user);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static User signIn(User user){
        PackageData pd=new PackageData();
        pd.setOperationType("Sign_in");
        pd.setUser(user);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                user = pd.getUser();
           }
        }catch (Exception e){e.printStackTrace();}
        return user;
    }

    public static void showMenuPage() {
        AuthorizationService.frame.addUser.setVisible(true);
        AuthorizationService.frame.register.setVisible(false);
        AuthorizationService.frame.repaint();
    }
    public static void showRegisterPage(){
        AuthorizationService.frame.addUser.setVisible(false);
        AuthorizationService.frame.register.setVisible(true);
        AuthorizationService.frame.repaint();
    }
}
