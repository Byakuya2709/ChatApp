/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DataBaseConnection {
     private static DataBaseConnection instance;
    private Connection connection;
    
    private String hostName = "localhost:3306";
    private String dbName = "";
    private String userName = "root";
    private String password = "";
    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
    
    public static DataBaseConnection getInstance(String dbName){
             if(instance == null){
                 
                     instance = new DataBaseConnection(dbName);
             }
        return instance;
    }
     public static DataBaseConnection getInstance(){
             if(instance == null){
                     instance = new DataBaseConnection();
             }
        return instance;
    }
    private DataBaseConnection(String dbName){
        this.dbName=dbName;
    
    }

    private DataBaseConnection() {
     
    }
    public Connection connectToDatabase() throws SQLException {
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            throw e;
        }
    }
//    tao database
    public void createDatabaseIfNotExists() throws SQLException {
        Statement statement = null;
        try {
            statement = (Statement) connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.executeUpdate(sql);
            System.out.println("Database created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
//  
//    tao bang users
    public void createTableUsers() throws SQLException {
        // SQL statement to create a table named "users"
       String sql = "CREATE TABLE IF NOT EXISTS " + dbName + ".users (" +
             "userID INT AUTO_INCREMENT PRIMARY KEY," +
             "userName VARCHAR(50) NOT NULL," +
             "numberPhone INT NOT NULL," +
             "gender VARCHAR(100) NOT NULL," + // Add a comma here
             "avt VARCHAR(255) DEFAULT 'default_avatar.jpg')" // Corrected default value syntax
        ;
        
        try (Statement statement = (Statement) connection.createStatement()) {
            // Execute the SQL statement to create the table
            statement.executeUpdate(sql);
            System.out.println("Table 'users' created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            throw e;
        }
    }
   public void createTableAccounts() throws SQLException {
    // Câu lệnh SQL để tạo bảng có tên "accounts"
    String sql = "CREATE TABLE IF NOT EXISTS " + dbName + ".accounts (" +
                 "accountID INT AUTO_INCREMENT PRIMARY KEY," +
                 "account VARCHAR(50) NOT NULL UNIQUE," +  // Thêm ràng buộc UNIQUE
                 "password VARCHAR(100) NOT NULL," +
                 "userID INT," +  // Thêm cột userID
                 "FOREIGN KEY (userID) REFERENCES users(userID)" + // Thêm ràng buộc khóa ngoại
                 ")";
        
    try (Statement statement = (Statement) connection.createStatement()) {
        // Thực hiện câu lệnh SQL để tạo bảng
        statement.executeUpdate(sql);
        System.out.println("Table 'accounts' created successfully!");
    } catch (SQLException e) {
        System.out.println("Error creating table: " + e.getMessage());
        throw e;
    }
}

    public String getDbName() {
        return dbName;
    }


       /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
