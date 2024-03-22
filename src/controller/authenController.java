/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import component.User;
import connection.DataBaseConnection;
import java.sql.ResultSet;
import model.Model_Account;
import model.Model_User;

/**
 *
 * @author admin
 */
public class authenController {
    
    Connection connection =null;

    public authenController() {
        DataBaseConnection dbConnection = DataBaseConnection.getInstance("chatapp");

        try {
            connection = (Connection) dbConnection.connectToDatabase();
            System.out.println(dbConnection.getDbName());
            System.out.println("Kết nối thành công tới: " + connection);
            
            // Chọn cơ sở dữ liệu sau khi thiết lập kết nối
            connection.setCatalog(dbConnection.getDbName());
        } catch (java.sql.SQLException e) {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }
    
    
    public int createUser(String userName, int numberPhone, String gender) {
    String sql = "INSERT INTO users (userName, numberPhone, gender) VALUES (?, ?, ?)";
    int userId = -1; //
    
    try (PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, userName);
        pstmt.setInt(2, numberPhone);
        pstmt.setString(3, gender);
        
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User created successfully!");
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1); // Lấy userID từ khóa tự tăng
            }
        } else {
            System.out.println("Failed to create user. No rows affected.");
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Error creating user: " + e.getMessage());
    }
    
    return userId;
}

    public boolean createAccount(String account, String password, int userID) {
    String sql = "INSERT INTO accounts (account, password, userID) VALUES (?, ?, ?)";
    
    try (PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql)) {
        pstmt.setString(1, account);
        pstmt.setString(2, password);
        pstmt.setInt(3, userID);
        
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Account created successfully!");
            return true; // Trả về true nếu tạo tài khoản thành công
        } else {
            System.out.println("Failed to create account. No rows affected.");
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Error creating account: " + e.getMessage());
    }
    
    return false;
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
    
    public boolean accountExists(String account) {
    String query = "SELECT COUNT(*) FROM accounts WHERE account = ?";
    try (
            PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(query)) {
            pstm.setString(1, account);
            try (ResultSet resultSet = pstm.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    } catch (java.sql.SQLException e) {
        System.err.println("Error checking if account exists: " + e.getMessage());
    }
    return false;
}
    public Model_Account getOneAccount(String account) {
    PreparedStatement pstm = null;
    String selectOneQuery = "SELECT * FROM accounts WHERE account = ?";
    try {
        pstm = (PreparedStatement) connection.prepareStatement(selectOneQuery);
        pstm.setString(1, account);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            int accountID = resultSet.getInt("accountID");
            String taikhoan = resultSet.getString("account");
            String password = resultSet.getString("password");
            String userID =resultSet.getString("userID");
        
            return new Model_Account(accountID,taikhoan, password, userID);
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
            int numberPhone = resultSet.getInt("numberPhone");
            String gender = resultSet.getString("gender");
            String avt = resultSet.getString("avt");
        
            return new Model_User(userId,userName, gender, avt, numberPhone);
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
