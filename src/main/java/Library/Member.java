/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Msi
 */
public class Member extends User{
    
    public Member(String name) {
        super(name);
    }

    public Member(String name, String email, String phoneNumber, String password) {
        super(name, email, phoneNumber,password);
    }

    @Override
    public void dashboard() {
        System.out.println("");
        System.out.println("Member Dashboard");
        sideMenu();
    }

    @Override
    public void sideMenu() {
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return Book");
        System.out.println("5. Logout");
    }

}
