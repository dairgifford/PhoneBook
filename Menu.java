/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 Binary Search Trees.
(10 pts)Write a program that provides a way for you to store and retrieve telephone numbers. Design a console program that provides the following operations:
Add: Adds a person’s name and phone number to the phone book.
Delete: Deletes a given person’s name and phone number from the phone book, given only the name.
Find: Locates a person’s phone number, given only the person’s name.
Count: Count the number of people in the phone book.
Quit: Quits the application, after first displaying the phonebook(in order traversal)
You can proceed as follows:
 
(5 points)Design and implement the class Person which represents the name and phone number of a person. You will store instances of this class in the phone book.
 
(10 points)Design and implement the class PhoneBook, which represents the phone book. The class should contain a reference to the root node of a binary search tree as a data field. This tree contains the people in the book.
 
(5 points)Design and implement the class Menu, which provides the program’s user interface. The program should display the phonebook when the user quits the program. Please upload a zip file including all the classes, interface, and exception.
*/
package project6;
import java.util.Scanner;
/**
 *
 * @author alisdairgifford
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();
        pb.add("Calisdair", 1112223333);// putting in some values
        pb.add("Balisdair", 1112223333);
        pb.add("Ealisdair", 1112223333);
        pb.add("Dalisdair", 1112223333);
        pb.add("Falisdair", 1112223333);
        pb.add("Alisdair", 1112223333);
        
        System.out.println("PHONE BOOK PROGRAM MENU");
        System.out.println("Type 'a' to add someone to the phone book");
        System.out.println("Type 'd' to delete from the phone book");
        System.out.println("Type 'f' to find someone in the phone book");
        System.out.println("Type 'c' to count the names in the phone book");
        System.out.println("Type 'q' to quit the phone book program and print the phone book");
        int sentinel = 0;
        while(sentinel != 23){
        System.out.println("What do you want to do?");
        char c = input.next().charAt(0);
        String x = input.nextLine();
        if(c == 'a'){
            String tempname;
            int tempphone;
            System.out.print("You want to add, enter the name of who you want to add: ");
            tempname = input.nextLine();
            System.out.print("Now enter the phone number with no dashes or parentheses, just numbers: ");
            tempphone = input.nextInt();
            pb.add(tempname, tempphone);
            System.out.println(tempname + " has been added!");
            
        }
        else if(c == 'd'){
            String tempname;
            System.out.print("You want to delete, enter the name of who you want to delete: ");
            tempname = input.nextLine();
            pb.delete(tempname);
            System.out.println(tempname + " has been deleted!");
        }
        else if(c == 'f'){
            String tempname;
            System.out.print("You want to find someone, enter the name of who you want to find: ");
            tempname = input.nextLine();
            System.out.println("Here they are: " + pb.find(tempname).toString());
        }
        else if(c == 'c'){
            System.out.println("You want to count, currently there are " + pb.count() + " people in the phone book");
        }
        else if(c == 'q'){
            System.out.println("You want to quit, so first we're gonna print the whole phone book");
            pb.inorder();
            sentinel = 23;
        }
        else{
            System.out.println("That character does not cause anything to happen - try again.");
        }

        }
        System.out.println("You're out of the loop");
    }
    
}
