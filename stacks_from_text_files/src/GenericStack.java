/*
 * By: Matthew S Montoya
 * Purpose: To practice implementing stacks from a text file
 * Last Modified: 15 January 2018
 * Note: This is NOT the runner file.
 */

public class GenericStack{
 private Node top;   //Create 3rd class \/ To be of any object
 GenericStack next;
 
 public GenericStack(){   //create stack
   top=null;
 }
 
 public boolean isEmpty(){
   return (top==null);
 }
 
 public void push(Object newItem){
   top = new Node(newItem, top);
 }
 
 public Object pop(){
   if(top == null){
     System.out.println("Trying to pop when stack is empty");
     return null;   
   }   
   else{
     Node temp = top;
     top = top.next;
     return temp.info;         
   }
 }
 
 public void popAll(){
   top=null;
 }
 public Object peek(){
   if(isEmpty()){
     System.out.println("Trying to peek when stack is empty");
     return null;
   }
   else{
     return top.info;
   } 
 }
}
