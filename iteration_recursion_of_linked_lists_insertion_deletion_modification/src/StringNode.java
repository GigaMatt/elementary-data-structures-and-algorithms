/*
 * By: Matthew S Montoya
 * Purpose: To practice working with LinkedLists (iNode objects), recursion/iteration, inserting and removing strings, and identifying pallindromes.
 * Last Modified: 11 January 2018
 * Note: This is NOT the runner file.
 */

public class StringNode{
  public String head;     //Data as a String (DaaS)
  public StringNode next; //Points to next node
  
  StringNode(){}
  
  StringNode(String s){
    head = s;   //head DaaS ONLY
  }
  
  StringNode(String s, StringNode tail){
    head = s;      //head DaaS
    next = tail;   //points "next" node to a (new) tail node
  }
}
