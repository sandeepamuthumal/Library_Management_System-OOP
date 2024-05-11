/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

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
        super(name, email, phoneNumber,password);
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
        System.out.println("7. Logout");

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
            default:
                System.out.println("Invalid Input");
                break;
        }

        sideMenu();
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
    
    private void deleteBook(){
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
}
