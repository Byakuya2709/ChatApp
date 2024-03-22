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
    private String avtUrl;
    private int phoneNumber;
    
    public Model_User(int userId, String userName, String gender, String avtUrl, int phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.avtUrl = avtUrl;
        this.phoneNumber = phoneNumber;
    }
    
    // Validation methods
    private static boolean isValidUserName(String userName) {
        return userName != null && !userName.isEmpty();
    }
    
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return Pattern.compile(passwordRegex).matcher(password).matches();
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^0\\d{9}$";
        return Pattern.compile(phoneRegex).matcher(phoneNumber).matches();
    }
    
    // Utility methods
    public static int convertStringToInt(String numberString) {
        return Integer.parseInt(numberString);
    }
    
    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvtUrl() {
        return avtUrl;
    }

    public void setAvtUrl(String avtUrl) {
        this.avtUrl = avtUrl;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
