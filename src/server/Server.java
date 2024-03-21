/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;


import connection.DataBaseConnection;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.loginView;
import views.signupView;

/**
 *
 * @author admin
 */
public class Server {
     private static Server instance;
     private ServerSocket serverSocket;
    private static final int PORT = 12345;
//    private static Map<String, String> users = new HashMap<>();
   
    public static Server getInstance() {
       if(instance == null){
              instance = new Server();
             }
        return instance;
    }
 
    private Server() {
        ServerSocket socket;
       try {
           socket = new ServerSocket(PORT);
           this.serverSocket= socket;
           System.out.println("Server started. Waiting for clients...");
       } catch (IOException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       }
      
    }
    
    public void serverStart(){
        try{
                DataBaseConnection connection = DataBaseConnection.getInstance("test1");
                connection.connectToDatabase();
                connection.createDatabaseIfNotExists();
                connection.createTable();}
        catch(SQLException e){
              System.out.println("Error when conneted to database.");  
        }
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                
                System.out.println("New client connected.");  
               
            }
        } catch (IOException e){
            closerServer();
        }
    }
    public void closerServer(){
        
        try{
        if(serverSocket != null){
            serverSocket.close();
        }
    } catch(IOException e){
        e.printStackTrace();
    }
    }
    public static void main(String[] args) {
        Server.getInstance().serverStart();
}
}