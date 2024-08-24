/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project6;

/**
 *
 * @author alisdairgifford
 */
public class Person {
    int phonenumber;
    String name;
    Person left;
    Person right;
    
    public Person(){
        name = null;
        phonenumber = 0;
    }
    public Person(String name, int phonenumber){
        this.name = name;
        this.phonenumber = phonenumber;
    }
    public String toString(){
        return name + " " + phonenumber;
    }
}
