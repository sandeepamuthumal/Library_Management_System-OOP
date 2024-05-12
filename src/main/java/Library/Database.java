/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Msi
 */
public class Database {
    
    static ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> userNames = new ArrayList<String>();
    static ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<String> bookNames = new ArrayList<String>();
    
    public void AddUser(User s)
    {
        users.add(s);
        userNames.add(s.getName());
    }
    
    public void AddBook(Book b)
    {
        books.add(b);
        bookNames.add(b.getName());
    }
    
   
    public int login(String email, String password){
        int n = -1;
       
        for(User s : users){
             
            if(s.getPassword().matches(password) && s.getEmail().matches(email))
            {
                n = users.indexOf(s);
                break;
            }
        }
        
        return n;
    }
    
    public User getUser(int n)
    {
        return users.get(n);
    }
    
    public Book getBook(int i)
    {
        return books.get(i);
    }
    
    public void removeBook(int i)
    {
        books.remove(i);
        System.out.println("Book Deleted Successfully");
    }
    
    public void getBookByName(String name)
    {
        System.out.println("");
        for(Book bk : books){
            if(bk.getName().equals(name) || bk.getName().contains(name))
            {
                System.out.println(bk.toString());
            }
        }
    }
    public static void showBooks()
    {
        System.out.println("");
        System.out.println("All Books : ");
        int i = 0;
        for (Book bk : books) {
            System.out.print(++i + ". ");
            System.out.println(bk.toString());
        }
    }
    
    public static void showMembers()
    {
        System.out.println("");
        System.out.println("All Members : ");
        int i = 0;
        for (User us : users) {
            System.out.print(++i + ". ");
            
            if(us.getClass().getSimpleName().equals("Member"))
            {
                System.out.println(us.toString());
            }
        }
    }
    
    public static void showUsers()
    {
        System.out.println("");
        System.out.println("All Users : ");
        int i = 0;
        for (User us : users) {
            System.out.print(++i + ". ");
            System.out.println(us.toString());
        }
    }
    
    public void deleteUser(int i)
    {
        users.remove(i);
        System.out.println("User Deleted Successfully");
    }
}
