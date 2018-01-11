/*Matthew  S Montoya
 * LinkedList */
public class LinkedList{
  
  private Box head;
  private Box iterator;
  
  LinkedList(){}
  
  //Add b as the last node in the linked list
  void addNode(Box b){             
    while(getNextBox() != null){          //find last node
      head = getNextBox();
    }
   head.setNext(new Box (b, null));         //set last node 
  }
  
  //Insert b in the position pos. If insertion is successful, return true, else false
  public static boolean insertNode(Box b, int pos){
    if(pos<0)
      System.out.println("Invalid Position");   //Invalid position if less than 0
    else
    {
      Box pred = head;
      for(int i=1; i<i-1; i++)
      {
        pred=pred.next;          //looks for predecessor
      }
      pred.next = new Box(b, pred.next); //creates new node
    }
  }
  
  ////Print l,w,h, v of all boxes in the linked list
  public void printAllBoxes(){
    if(head == null)
      System.out.println("There are no boxes.");
    else{
      while(head.getNext() != null){      //While the list isn't empty, dementions get printed
        System.out.println("The dementions of the boxes are" +head.getLength()+" "+head.getWidth()+" "+head.getHeight()+" with a volume of "+head.getVolume());
        head = head.getNext();      //iterates through
      }
    }
  }
  
  //remove box in position pos. Return true if successful; false if not
  public static boolean removeNode(int pos){
    Box currentLink = head;
    Box previousLink = head;
    if(pos < 0 || head == null){   //if invalid positions, return the boolean as false
      return false;
      break;
    }
    int i = 0;    //counter to traverse
    while(i != pos){  
      previousLink = currentLink;
      currentLink = currentLink.next;
      i++;      //traverses while the counter is not equal to the position
    }
    if(i==pos){                                        //if a match is found...
      if(curretLink.next != null)                      //...and there is something after the node...
        previousLink.next = previousLink.next.next;   //...the link list is re-routed around the removed node
      else
        previousLink.next = null;                     //Otherwise the previous node is assigned as the last node
    }
    head = previousLink;
    return true;                                     //And it is returned true
  }
  
  //Return box in position pos
  public static Box getBox(int pos){
    if(pos<0 || head == null){
      return;
      break;   //null if the position/head is invalid/empty
    }
    
    int i=0;
    Box list = head;
    
    while(list != null){
      if(i==pos){         //if a match is found, returns the list
        return list;
        break;
      }
      else{
        list = list.next;  //otherwise it keeps traversing
        i++;
      }
    }
    if(pos>i)
      return;  
  }

  ////Print l,w,h, v of all boxes in the linked list in reverse order
  public static void printReverse(){
    Box previousBox=null;
    Box nextBox;  
    while(head!=null){  
      nextBox=head.next;  
      head.next=previousBox;  //reverse the link
      previousBox=head;  // move the head and previousNode by 1 node
      head=nextBox;  
    }
    int i=1;   //counter to traverse
    while(previousBox != null){    //while the list issn't empty, print out dementions
      System.out.println("The dementions of box #"+i+" is "+previousBox.getLength+" "+previousBox.getWidth+" "+previousBox.getHeight+", with a volume of "+previousBox.getVolume);
      previousBox = previousBox.next;
      i++;  //add to the counter
    }
  }
  
  //Initiate the iterator 
  public static void initiateIterator(){
    iterator = head;
  }
  
  //return the box in the current iterator position
  public static Box getNextBox(){
    return iterator;
  }
}
