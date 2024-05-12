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
public class Admin extends User {

    Database db = new Database();
    static Scanner s;

    public Admin(String name) {
        super(name);
    }

    public Admin(String name, String email, String phoneNumber, String password) {
        super(name, email, phoneNumber, password);
    }

    @Override
    public void dashboard() {
        System.out.println("");
        System.out.println("Admin Dashboard");
        sideMenu();
    }

    @Override
    public void sideMenu() {
        s = new Scanner(System.in);
        System.out.println("");
        System.out.println("1. View Books");
        System.out.println("2. Add Book");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Search Book");
        System.out.println("6. View Members");
        System.out.println("7. Show Users");
        System.out.println("8. Add New User");
        System.out.println("9. Update User");
        System.out.println("10. Delete User");
        System.out.println("11. Logout");

        int userInput = s.nextInt();

        switch (userInput) {
            case 1:
                showBooks();
                break;
            case 2:
                addBook();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                searchBook();
                break;
            case 6:
                showMembers();
                break;
            case 7:
                showUsers();
                break;
            case 8:
                addUser();
                break;
            case 9:
                updateUser();
                break;
            case 10:
                deleteUser();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

        if(userInput == 11)
        {
            System.out.println("Logout successfully");
        }
        else
        {
            sideMenu();
        }
    }

    private void showBooks() {
        Database.showBooks();
    }

    private void addBook() {
        System.out.println("");
        System.out.print("Enter Book Name : ");
        String bookName = s.next();
        System.out.print("Enter ISBN : ");
        String ISBN = s.next();
        System.out.print("Enter Author : ");
        String author = s.next();
        System.out.print("Enter Price : ");
        Double price = s.nextDouble();

        Book newBook = new Book(ISBN, bookName, author, price);
        db.AddBook(newBook);

        System.out.println("Book added successfully.");
    }

    private void updateBook() {
        System.out.println("\nPlease select a book ");
        showBooks();
        System.out.print("\n\tEnter Book No : ");
        int bookNo = s.nextInt();
        System.out.print("Enter Book Name : ");
        String bookName = s.next();
        System.out.print("Enter ISBN : ");
        String ISBN = s.next();
        System.out.print("Enter Author : ");
        String author = s.next();
        System.out.print("Enter Price : ");
        Double price = s.nextDouble();

        try {
            Book book = db.getBook(bookNo - 1);
            book.setBook(ISBN, bookName, author, price);

            System.out.println("Book updated successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong, Please try again!!");
        }
    }

    private void deleteBook() {
        System.out.println("\nPlease select a book ");
        showBooks();
        System.out.print("\n\tEnter Book No : ");
        int bookNo = s.nextInt();

        try {
            db.removeBook(bookNo - 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong, Please try again!!");
        }
    }

    private void searchBook() {
        System.out.print("\nName of the book : ");
        String userInput = s.next();
        db.getBookByName(userInput);
    }

    private void addUser() {
        System.out.println("");
        System.out.println("Create New User");
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

        db.AddUser(user);
        System.out.println("User created successfully");
    }

    private void showMembers() {
        Database.showMembers();
    }

    private void showUsers() {
        Database.showUsers();
    }

    private void updateUser() {
        System.out.println("\nPlease select a user ");
        showUsers();
        System.out.print("\n\tEnter User No : ");
        int userNo = s.nextInt();
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter phone number:");
        String phoneNumber = s.next();
        System.out.println("Enter email:");
        String email = s.next();

        try {
            User user = db.getUser(userNo - 1);
            user.update(name, email, phoneNumber);
            System.out.println("User updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void deleteUser() {
        System.out.println("\nPlease select a user ");
        showUsers();
        System.out.print("\n\tEnter User No : ");
        int userNo = s.nextInt();
        db.deleteUser(userNo - 1);
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
