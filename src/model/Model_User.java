/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class Model_User {
    private int userId;
    private String userName;
    private String gender;
    private String password;
    private String avtUrl;
    private int numberPhone;
    
    
    public Model_User(){
        
    }
    
    public Model_User(int userId, String userName,String gender, String password, String avtUrl, int numberPhone) {
        this.gender= gender;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.avtUrl = avtUrl;
        this.numberPhone = numberPhone;
    }
     private static boolean isValidUserName(String userName) {
        // Add your username validation logic here
        return userName != null && !userName.isEmpty();
    }
    public static boolean isValidPassword(String password) {
        // Define a regular expression for the password rules
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(passwordRegex);

        // Use the pattern to create a Matcher object
        return pattern.matcher(password).matches();
    }
     //    sdt
     public static boolean isValidPhoneNumber(String phoneNumber) {
         String phoneRegex = "^0\\d{9}$";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(phoneRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(phoneNumber);

        // Return true if the phone number matches the pattern
        return matcher.matches();
    }
      public static int convertStringToInt(String numberString) {
        return Integer.parseInt(numberString);
    }
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAvtUrl() {
        return avtUrl;
    }

    public int getNumberPhone() {
        return numberPhone;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvtUrl(String avtUrl) {
        this.avtUrl = avtUrl;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

//    public static int generateUniqueUserID() {
//        int numberOfDigits = 5;
//        Set<Integer> uniqueDigits = generateUniqueNonZeroStartingDigits(numberOfDigits);
//
//        // Check if there are enough unique digits
//        if (uniqueDigits.size() < numberOfDigits) {
//            throw new IllegalStateException("Not enough unique digits.");
//        }
//
//        int userID = 0;
//
//        for (int digit : uniqueDigits) {
//            userID = userID * 10 + digit;
//        }
//
//        return userID;
//    }
//
//    public static Set<Integer> generateUniqueNonZeroStartingDigits(int numberOfDigits) {
//        if (numberOfDigits > 9) {
//            throw new IllegalArgumentException("Cannot generate " + numberOfDigits + " digits without starting with 0 and without duplicates.");
//        }
//
//        Set<Integer> uniqueDigits = new HashSet<>();
//        Random random = new Random();
//
//        while (uniqueDigits.size() < numberOfDigits) {
//            int digit = random.nextInt(9) + 1; // Numbers from 1 to 9 (non-zero starting)
//            uniqueDigits.add(digit);
//        }
//
//        return uniqueDigits;
//    }
}
