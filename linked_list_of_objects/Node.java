/*
 * By: Matthew S Montoya
 * Purpose: To practice creating linked lists of objects and finding their largest and smallest values
 * Last Modified: 11 January 2018
 * Note: This is NOT the runner file.
 */

public class Node{
  
  private String data;
  private Node next;     //Kind of like recursion, it calls itself.
  
  public Node(){
  }
  
  public Node(String data, Node next){
    this.data = data;
    this.next = next;
  }
  
  public Node(String data){
    this.data = data;     //refer to data field, not data parameter
    this.next = null;
  }

//Getters  
  public String getData(){
    return data;
  }
  public Node getNext(){
    return next;
  }
  
//Setters
  public void setData(String d){
    data = d;
  }
  
  public void setNext(Node n){
    next = n;
  }
  
  /* LET'S SAY THAT WE'RE CREATING NODES:
   * 
   * Node n;
   * n = new Node("hello", anotherNode); //Assuming "anotherNode" has already been created
   * n now holds the data "hello" and a refrence to the 2nd node named "anotherNode"
   * n.getData(); //Will output "hello"
   * n.getNext(); //Will output "anotherNode" b.c. it points to the next node
   * 
   * 
   * 
   * FOR BOXES
   * length
   * width
   * height
   * isCube
   * volume
   * next:
   * 
   * 
   * Singularly linked lists can only traverse forward!!!
   * x.getNext();
   * x.getNext.getData();
   * Cannot do x.getPrev()
   * 
   * DOUBLY Linked Lists: START FROM THE END
   * Eg, Nodes a, b, c,
   * Node c = new Node("c", null);
   * Node b = new Node("b", c);
   * Node head = new Node("a", b);
   * OR
   * Node head = new Node("a", new Node("b", new Node("c", null)));      //Just created all 3 nodes in one
   * 
   * EMPTY data list
   * Node head = null; //linked list is empty
   * 
   * 
   * public static String getThird(Node head){
   * return head.getNext.getNext.getData();
   * }
   * 
   * public static void insertSecond(Node head, String s){
   * Node newNode = new Node(s, null);     //set data
   * newNode.setNext(head.getNext());      //set newNode.next to whatever head.next was
   * head.setNext(newNode);                //sets head.next to the new node
   * }
   * 
   * TRAVERSING with a while-loop
   * public static int size(Node head){
   * Node list = head;                   //So head doesn't move
   * int count = 0;
   * 
   * while(list != null){
   * list = list.getNext();
   * count++
   * }
   * return count;
   * }
   * 
   * ADDING to the end
   * public static void addLast(Node head, String s){
   * //find last node
   * while(head.getNext() != null){
   * head = list.getNext();
   * }
   * //head refers to last node
   * head.setNext(new Node (s, null));
   * }
   * 
   * public static void addLast(Node head, String s){
   * Node prev = null;
   * Node curr = list;
   * while(curr!= null){
   * prev = curr;
   * curr = curr.getNext();
   * }
   * prev.setNext(new Node(s, null));
   * }
   * 
   * ADDING to an empty list:
   * public static void addLast(Node head, String s){
   * if(list == null){
   * return new Node(s, null);
   * }
   * Node temp = head;
   * while(temp.getNext() != null){
   * temp = temp.getNext();
   * temp.setNext(new Node(s, null));
   * }
   * return list;
   *  
   * 
  
