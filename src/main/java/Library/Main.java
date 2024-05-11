/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Msi
 */
public class Main {

    static Scanner s;
    static Database database;

    public static void main(String[] args) {

        System.out.println("Welcome to Library Management System!");
        database = new Database();
        s = new Scanner(System.in);

        //add two books initially
        Book book1 = new Book("13: 978-0988262591", "The Phoenix Project", "Gene Kim", 8000.00);
        Book book2 = new Book("13: 978-0132350884", "Clean Code", "Robert C. Martin", 10000.00);

        database.AddBook(book1);
        database.AddBook(book2);

        menu();
    }

    private static void menu() {
        int num;
        System.out.println("\n0. Exist\n1. Login\n2. Sign Up");
        num = s.nextInt();
        switch (num) {
            case 1:
                login();

            case 2:
                newUser();
        }
    }

    private static void login() {
        System.out.println("");
        System.out.println("Login");

        System.out.println("Enter email:");
        String email = s.next();
        System.out.println("Enter password:");
        String password = s.next();

        String hashedPassword = hashPassword(password);
        int n = database.login(email, hashedPassword);

        if (n != -1) {
            User user = database.getUser(n);
            System.out.println("Welcome " + user.getName());
            user.dashboard();
        } else {
            System.out.println("Invalid email or phone number");
            login();
        }
    }

    private static void newUser() {
        System.out.println("");
        System.out.println("Sign Up");
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter phone number:");
        String phoneNumber = s.next();
        System.out.println("Enter email:");
        String email = s.next();
        System.out.println("Enter password:");
        String password = s.next();
        System.out.println("1. Admin\n2. Member");
        int n2 = s.nextInt();

        String hashedPassword = hashPassword(password);

        User user;
        if (n2 == 1) {
            user = new Admin(name, email, phoneNumber, hashedPassword);
        } else {
            user = new Member(name, email, phoneNumber, hashedPassword);
        }

        database.AddUser(user);
        System.out.println("User created successfully");
        login();
    }

    // Hash the password using SHA-256
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
