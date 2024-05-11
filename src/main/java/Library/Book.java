/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Msi
 */
public class Book {
    private String ISBN;
    private String bookName;
    private String author;
    private double price;
    private boolean isAvailable;
    private String status;
    
    public Book(String ISBN,String bookName,String author,double price)
    {
        this.ISBN = ISBN;
        this.author = author;
        this.bookName = bookName;
        this.price = price;
        this.isAvailable = true;
        this.status = "In Stock";
    }
    
    public void setBook(String ISBN,String bookName,String author,double price)
    {
        this.ISBN = ISBN;
        this.author = author;
        this.bookName = bookName;
        this.price = price;
    }
    
    public void purchaseBook()
    {
        if(isAvailable == true)
        {
            isAvailable = false;
            this.status = "Purchased";
        }
        else
        {
            System.out.println("Out of stock");
        }     
    }
    
    public void borrowBook()
    {
        if(isAvailable == true)
        {
            isAvailable = false;
            this.status = "Borrowed";
        }
        else
        {
            System.out.println("Out of stock");
        }     
    }
    
    @Override
    public String toString()
    {
        return "ISBN : " + ISBN + ", Book Name : " + bookName + ", Author : " + author + ", Status : " + status;
    }
    
    public String getName()
    {
        return bookName;
    }
}
