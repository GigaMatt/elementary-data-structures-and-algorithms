/*
 * By: Matthew S Montoya
 * Purpose: To practice implementing stacks from a text file
 * Last Modified: 15 January 2018
 * Note: This is NOT the runner file.
 */

public class Node {
    Object info;  //for any object type
    Node next;
        
    public Node(Object info, Node next){
            this.info=info;
            this.next=next;
    }
}
