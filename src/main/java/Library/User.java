/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Msi
 */
public abstract class User {
    
    protected String name;
    protected String email;
    protected String phoneNumber;
    private String password;
    
    public User(){}
    
    public User(String name)
    {
        this.name = name;
    }
    
    public User(String name,String email,String phoneNumber, String password)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    
    public void update(String name, String email, String phoneNumber)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString()
    {
        return "Name : " + name + ", Email : " + email + ", Contact No : " + phoneNumber;
    }
    
    public abstract void dashboard();
    public abstract void sideMenu();
}
