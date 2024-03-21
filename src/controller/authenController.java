/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import component.User;
import connection.DataBaseConnection;
import java.sql.ResultSet;
import model.Model_User;

/**
 *
 * @author admin
 */
public class authenController {

    Connection connection = (Connection) DataBaseConnection.getInstance().getConnection();
    public String createUser(String userName, String password, int numberPhone, String gender) {
        String sql = "INSERT INTO users (userName, password, numberPhone, gender) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql)) {
  
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setInt(3, numberPhone);
            pstmt.setString(4, gender);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User created successfully!");
            } else {
                System.out.println("Failed to create user. No rows affected.");
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error creating user: " + e.getMessage());
            return "Failed to create user.";
        }
        return "Tạo tài khoản thành công";
    }
    
    public boolean userExists(String userName) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(query)) {
            pstm.setString(1, userName);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error checking if user exists: " + e.getMessage());
        }
        return false;
    }
    public boolean userExists(int numberPhone) {
        String query = "SELECT COUNT(*) FROM users WHERE numberPhone = ?";
        try (
                PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(query)) {
            pstm.setInt(1, numberPhone);

            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    //
                    return count > 0;
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error checking if user exists: " + e.getMessage());
            // Log the exception or handle it according to your application's needs
        }
        return false;
    }
  public Model_User getOneUser(String username) {
    PreparedStatement pstm = null;
    String selectOneQuery = "SELECT * FROM users WHERE userName = ?";
    try {
        pstm = (PreparedStatement) connection.prepareStatement(selectOneQuery);
        pstm.setString(1, username);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int userId = resultSet.getInt("userID");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            int numberPhone = resultSet.getInt("numberPhone");
            String gender = resultSet.getString("gender");
            String avt = resultSet.getString("avt");
        
            return new Model_User(userId, userName, gender, password, avt, numberPhone);
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace(); // Log the exception for debugging purposes
    } finally {
        // Close the PreparedStatement in a finally block to ensure it's always closed
        if (pstm != null) {
            try {
                pstm.close();
            } catch (java.sql.SQLException e) {
          
            }
        }
    }
    return null; // Return null if the user was not found or an exception occurred
}

}
