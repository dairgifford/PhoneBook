/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project6;

/**
 *
 * @author alisdairgifford
 */
public class PhoneBook{
    private Person root;
    private int count;
    
    public PhoneBook(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void inorder() throws PhoneBookException{
        if(isEmpty())
            throw new PhoneBookException("empty");
        else
            inorder(root);
    }
    private void inorder(Person curr){
        if(curr != null){
           
            inorder(curr.left);
             System.out.println(curr.toString());
            inorder(curr.right);
        }   
    }
    public int count(){
        return count;
    }
    public Person find(String name) throws PhoneBookException{
        if(isEmpty())
            throw new PhoneBookException("Empty tree");
        else{
            return find(root, name);
        }
    }
    private Person find(Person curr, String name){
        //not found
        if(curr == null)
            return null;
        else if(name.compareTo(curr.name) < 0)
            return find(curr.left, name);
        else if(name.compareTo(curr.name) > 0)
            return find(curr.right, name);
        else //found
            return curr;
    }
    public void add(String name, int phonenumber){
        root =  add(root, name, phonenumber);
        count++;
    }
    private Person add(Person curr, String name, int phonenumber){
        if(curr == null){//reached insertion point
           curr = new Person(name, phonenumber);
           return curr;
        }
        else if(name.compareTo(curr.name) < 0){
            curr.left = add(curr.left, name, phonenumber);
            return curr;
        }   
        else {
            curr.right =  add(curr.right, name, phonenumber);
            return curr;
        }
        
            
            
    }
    public Person delete(String name) throws PhoneBookException{
        if(isEmpty())
            throw new PhoneBookException("empty tree");
        else{
            count--;
            return delete(root, name);
        }
            
    }
    private Person delete(Person curr, String name){
        if(curr == null)
           return null;
        else if(name.compareTo(curr.name) < 0)
            curr.left = delete(curr.left, name);
        else if(name.compareTo(curr.name) > 0)
            curr.right = delete(curr.right, name);
        else
            curr = deletePerson(curr);
        return curr;
    }
    private Person deletePerson(Person curr){
        if(curr.left == null && curr.right == null) // curr is leaf
            return null;
        else if(curr.right == null) // no right child
            return curr.left;
        else if(curr.left == null) // no left child
            return curr.right;
        else{ //node has two children
            Person successor = findLeftmost(curr.right);
            curr.name = successor.name;
            curr.phonenumber = successor.phonenumber;
            curr.right = deleteLeftmost(curr.right);
            return curr;
        }
    }
    
    private Person findLeftmost(Person right){
        if(right.left == null)
            return right;
        else
            return findLeftmost(right.left);
    }
    private Person deleteLeftmost(Person curr){
        if(curr.left == null)
            return curr.right;
        else{
            curr.left = deleteLeftmost(curr.left);
            return curr;
        }
            
    }
}
