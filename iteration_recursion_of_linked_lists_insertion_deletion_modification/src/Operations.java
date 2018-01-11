/*
 * By: Matthew S Montoya
 * Purpose: To practice working with LinkedLists (iNode objects), recursion/iteration, inserting and removing strings, and identifying pallindromes.
 * Last Modified: 11 January 2018
 * Note: This is the runner file.
 */
import java.util.Random;
  
public class Operations{
  public static void main(String[] args){
    
    StringNode L = new StringNode("0"+getRandString(2+(int)(Math.random()*5))); //Remember, Nodes are objects
    StringNode temp = L;
    for(int i=1; i<10; i++){
      temp.next = new StringNode(i+getRandString(2+(int)(Math.random()*5)));  //Length as determined by Math.random()
      temp = temp.next;
    }
    
    System.out.println("All Strings in the list:");
    printMyList(L);   //Non-return method
    System.out.println();
    
    boolean b = isListInOrder(L);
    System.out.println("List is ordered: "+b);    
    System.out.println();
    
    System.out.println("Count the number of k-length strings:");
    System.out.println("k\tNo. of Strings with length k");     //Creates table format
    for(int k=0; k<7; k++)
      System.out.println(k+"\t"+countKLengthStrings(L, k));    //Prints table format
    
    System.out.println("\nLongest String = "+longestStringOfMyList(L));
    System.out.println("\nLength = "+lengthOfMyList(L));
    
    L=reverseMyList(L);   //Method to reverse the LinkList
    System.out.println("\nAll Strings in the reversed list:");
    printMyList(L);     //Non-return method
    System.out.println();
    
    
    //Remove a string
    System.out.println("Remove a given String");
    StringNode LL = removeAStringFromMyList(L, L.next.next.head);   //CREATE NODE LL (USE AS TEMP!!!)   
    System.out.println("All the strings in the new list:");    
    printMyList(LL);
    System.out.println();
    
    //Insert a string
    System.out.println("Insert a String into a position of the new list:");
    LL=insertAStringIntoMyList(LL, "Hello World", 3);  //Temp Node LL + String + Position
    printMyList(LL);
    System.out.println();
    
    //Is list in order?
    b=isListInOrder(L);     //Check regular L, NOT NEW LL!!!
    System.out.println("List is ordered: "+b);    
    System.out.println();
    
    //Adds Palindromes to LL
    LL=insertAStringIntoMyList(LL, "ABBA", 3);
    LL=insertAStringIntoMyList(LL, "DoGeeseSeeGod", 3);  //Remember uppercase/lowercase are irrevelant
    
    //verifies countPalindromes for LL is working
    int c = countPalindromes(LL);  //when a word read foward is the same read backwards
    System.out.println("Palindrome: ABBA");
    System.out.println("Palindrome: DoGeeseSeeGod");
    System.out.println();
    System.out.println("Found "+c+" palindromes.");  
  }
  
  
  //generate random string of length provided
  static String getRandString(int length){
    
    String xyz = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";     //Use as base string \/ Set up as a base string to avoid .toUppercase()
    String nString = "";
  
    for (int j=0; j<length; j++) {                  //Use a loop to make the string (length) charactors long
      char c = xyz.charAt((int)(Math.random() *26));
      nString = nString + c;
    }
    return nString;
  }
 
  
  //recursive method to print all Strings. NO LOOPS
  public static void printMyList(StringNode M){
    if(M == null)     //base case
      return;
    System.out.println(M.head);
    printMyList(M.next);   //recursive call
  }
  

  //recursive method to retrive num of strings that have length of int k.
  public static int countKLengthStrings(StringNode M, int k){
    
    //StringNode t = M; //create copy for mod
    
    int num = 0;
    if(M == null)
      return 0;
    if(k==M.head.length())
      num = 1+countKLengthStrings(M.next, k);
    else
      num = countKLengthStrings(M.next, k);
    
    return num;
  }
  

  //recursive method to retrive longest String from the list. Assume there is at least one string in the list.
  public static String longestStringOfMyList(StringNode M){
    if(M == null)
      return null;
    
    if(M.next == null)
      return M.head;
    
    String l = longestStringOfMyList(M.next);  //Memory will story as diagnol nodes returning values with each passing one (like basic recursion)
    if(M.head.length() > l.length())
      return M.head;
   return l;
  }
 
  
  //recursive method to compute length of a list
  public static int lengthOfMyList(StringNode M){
    if (M == null)    //base case
      return 0;
    
    return 1 + lengthOfMyList(M.next);   //Add one as you cycle through
  }
 
  
  //recursive method named reverseMyList that will reverse link list. return the head
  public static StringNode reverseMyList(StringNode M){
    if(M.next==null)   //base case
      return M;
    
    StringNode reversedList = reverseMyList(M.next);   //recursive call; create a new linked list
    M.next.next = M;  
    M.next = null;   //Sever the origional ties
    return reversedList;
  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  //recursive method to remove first occurance of a specific string. eg. If AA CC BB WW FF and yu remove CC, string should return AA BB WW FF
  public static StringNode removeAStringFromMyList(StringNode M, String removee){
    
    if(M==null)   //base case 1: NULL
      return M;
    
    if(M.head == removee)//base case 2: string is found in M.next
      return M.next;   
    
    return new StringNode(M.head, removeAStringFromMyList(M.next, removee)); //recurursive method: origional LinkedList w/ the modification
    
  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  //recursive method to insert a string into a specific position of a list. Positions start at 0
  public static StringNode insertAStringIntoMyList(StringNode M, String insertee, int position){
    if(M == null || position<0 || insertee == null)   //base case: NULL
      return M;
    
    if(position == 1){ //Avoid 0 to not insert after the position
      StringNode x = new StringNode();
      x.head = insertee;   //create new node && re-route
      x.next = M.next;
      M.next = x;
      return M;
    }
      else     //count down positions if current position is not found
        return new StringNode(M.head, insertAStringIntoMyList(M.next, insertee, position-1)); //return original LinkedList with the modification
  }
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
  //recursive method to verify if strings are alphabetically ordered. Return true if ordered; false otherwise
  public static boolean isListInOrder(StringNode M){
    if(M==null || M.next == null)   //base cases
      return true;
    if(M.head.charAt(0) < M.next.head.charAt(0)){ //less than b/c of ascending order
       return isListInOrder(M.next);
    }
    else
      return false;
  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
  
  /*recursive method that will count how many strings of a given linked list are palindromes
   * Method will call another recursive method to verify if a string is a palindromes
   * palindrones checks must NOT be case-sensitive */
  
  public static int countPalindromes(StringNode M){
    if(M == null)     //base case
      return 0;
    
    boolean bool = isPalindrome(M.head);   //call connecting method to test palindromes
    
    if(bool)
       return 1+countPalindromes(M.next);   //add 1 if(isPalindrome) and call-back
    else
       return countPalindromes(M.next);    //JUST call-back if false
  }
  
  //2nd method called //\\ DETERMINES IF PALINDROME
  public static boolean isPalindrome(String s){
    
    String n = s.toUpperCase();   //Set strings to uppercase to avoid errors
    
    if(n.length() == 0 || n.length() == 1)   //base case for true
      return true;
    
    if(n.charAt(0) != n.charAt(n.length()-1)) //base case for false
      return false;
    
    return isPalindrome(n.substring(1, n.length()-1));   //-1 b/c of inclusive/exclusive values
  }
}
