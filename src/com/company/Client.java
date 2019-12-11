package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;
    public static AuthorizationService authorizationService;
    public static AdminService adminService;
    public static UserService userService;
    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",5999);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        connectToServer();
        authorizationService = new AuthorizationService(outputStream, inputStream);
        adminService = new AdminService(outputStream, inputStream);
        userService = new UserService(outputStream, inputStream);
    }
}
