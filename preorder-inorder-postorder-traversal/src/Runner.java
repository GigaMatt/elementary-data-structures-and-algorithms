/*
 * By: Matthew S Montoya
 * Purpose: To practice implementing preorder, indorder, and postorder traversals
 * Last Modified: 15 January 2018
 * Note: This is the runner file.
 */

public class Runner{
  public static void main(String[] args){
    
    BST b = new BST();
    
    System.out.println("The random numbers inserted are:");   //creates 10 random numbers to be sorted
    for(int i=0; i<10; i++){
      double d = (int)(Math.random()*100);    //randomizes numbers as ints
      b.insert(d);
      System.out.println(d+" ");   //prints numbers
    }
    System.out.println();
    
    System.out.println("Result of inorder traversal (ascending order): ");
    b.printInOrder();       //Calls the inOrder method
    System.out.println();
    System.out.println("Result of postorder traversal: ");
    b.printPostOrder();     //Calls the postOrder method
    System.out.println();
    System.out.println("Result of preorder traversal: ");
    b.printPreOrder();      //Calls the preOrder method
    System.out.println();
    System.out.println("Smallest number is: "+b.smallest());   //prints smallest number
    System.out.println("Largest number is: "+b.largest());     //prints largest number
  }
}
