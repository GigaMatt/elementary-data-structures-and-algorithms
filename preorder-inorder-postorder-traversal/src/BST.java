/*
 * By: Matthew S Montoya
 * Purpose: To practice implementing preorder, indorder, and postorder traversals
 * Last Modified: 15 January 2018
 * Note: This is NOT the runner file.
 */

public class BST{
  
  private double data;
  private BST left, right;
  private int count = 0;
  
  BST (double d, BST l, BST r){
    data = d;
    left = l;
    right = r;
    count++;
  }
  
  BST (double d){
    data = d;
    count++;
  }
  
  BST(){}
  
  public void insert(double d){
    if(d == this.data)   //if the new number is the same, set it here  \/ use "this.X" to go around the absense of a root
      this.data = d;
    else if (d <this.data) {    //else, if the new number is less, send it to the left
      if (left == null) {            //and left is null, create a new node
        left = new BST(d);
      } 
      else                           //otherwise recursively call it
        left.insert(d);
    }
    else if(d > this.data){    //else, if the new number is greater, send it to the right
      if(right == null){            //and right is null, create a new node
        right = new BST(d);
      }
      else                          //otherwise recursively call it
        right.insert(d);
    }
  }
  
  public double smallest(){
    if(this.left == null)   //base case
      return this.data;
    else
      return left.smallest();     //otherwise, recursively send it to the left (because smallest)
  }
  
  public double largest(){
    if(this.right == null)   //base case
      return this.data;
    else
      return right.largest();     //otherwise, recursively send it to the right (because largest)
  }
  
  public void printInOrder(){
    if(this.left != null)     //traverse through the left side
      left.printInOrder();    
    System.out.println(data+" ");   //print the left side, then center, then right
    if(this.right != null)   //traverse through the right side
      right.printInOrder();
  }
  
  public void printPreOrder(){
    System.out.println(this.data+" ");   //print node first
    if(this.left != null)   //then traverse the left side
      left.printPreOrder();
    if(this.right != null)  //then traverse the right side
      right.printInOrder();
  }
  
  public void printPostOrder(){
    if(this.left != null)   //traverse the left side (then print) -- then process node
      left.printPostOrder();
    if(this.right != null)  //traverse the right side (then print)
      right.printPostOrder();
    System.out.println(data+" ");   //print the number
  }
}
