/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import com.mysql.jdbc.Connection;
import connection.DataBaseConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import views.signupView;

/**
 *
 * @author admin
 */
public class Client extends Thread{
     private static Client instance;
     private Socket socket;
     private static final int PORT = 12345;

    @Override
    public void run() {
       

        DataBaseConnection connection = DataBaseConnection.getInstance("test1");
        Connection dbConnection;
         try {
             dbConnection = (Connection) connection.connectToDatabase();
             System.out.println("Kết nối thành công tới: " + dbConnection);
            SwingUtilities.invokeLater(() -> {
                signupView sign = new signupView(); // Create a new instance of signupView
    });
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
            
    }
    
       public static Client getInstance() {
       if(instance == null){
              instance = new Client();
             }
        return instance;
    }
 
    private Client(){
         try {
          socket= new Socket("localhost",PORT);
           System.out.println("Client started.");
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    } 
//    public void serverStart(){
//        String dbName = "test1";
//        DataBaseConnection connection = DataBaseConnection.getInstance(dbName);
//    
//    try {
//        // Connect to the database and create it if it doesn't exist
//        connection.connectToDatabase();
//        connection.createTable();
//        
//        // You can now use the connection to interact with your database
//        Connection dbConnection = (Connection) connection.getConnection();
//        System.out.println("Kết nối thành công tới: "+dbConnection);
//        signupView sign = new signupView();
//        // Perform database operations...
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//     
//    }
       

// main method
    public static void main(String[] args) {
        Client.getInstance().start();
    }
}
