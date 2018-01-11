/*
 * By: Matthew S Montoya
 * Purpose: To practice creating linked lists of objects and finding their largest and smallest values
 * Last Modified: 11 January 2018
 * Note: This is the runner file.
 */

import java.util.*;
import java.io.*;
public class Runner{
  public static void main(String[] args){
    
    //Open the text file
    Scanner input = new Scanner(System.in);
    System.out.println("What is the name of the text file?");    //get name of file
    String fileName = input.next();
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
  try{
      Package[] packageArray = new Package[6];
      int i = 0;                   //Used for position
      
      FileReader fw = new FileReader("array.txt");     //Assuming the text file is within the same folder
      BufferedReader br = new BufferedReader(fw);
      double[] tempPack;                              //temporary array of packages
      
      while(br.ready())
      {
        String thisLine = br.readLine();              //Break the file into lines
        System.out.println(thisLine);
        String[] lineParts = thisLine.split(" ");    //Splits line at spaces (x.split)
        for(int p=0; p<lineParts.length; p++){
          System.out.println(lineParts[p]);
        }
        
        //Call method to parse String
        tempPack = convert(lineParts);      //Convert Strings to doubles \\//Problem Area   !!!
        
        //Create LinkedList of boxes
        Package newPack = new Package(tempPack[0], tempPack[1], tempPack[2]);
        Box head = new Box();
        int i =0;
        
        while(i<newPack.length){               //store the line into a new node of l, w, h
          iterator = new Box();
          head.next = iterator;
          iterator.length = tempPack[0];     //0 = length
          iterator.width = tempPack[1];      //1 = width
          iterator.height = tempPack[2];     //2 = height
          i++;                               //use counter to cycle through
        }
      }
      br.close();
      
    }catch(Exception e){
      System.out.println("Error: Exception e");
    }  
  }
  
//Parse method (parsing Strings into doubles)    
  public static Box convert(String[] lineParts){
    double[] parsed = new double[lineParts.length];
    for(int i=0; i < lineParts.length; i++){
      System.out.println(lineParts[i]);
      double temp = Double.parseDouble(lineParts[i]);
      parsed[i] = temp;
      System.out.println(parsed[i]);
    }
    return parsed;                          //Return double values to store in objects
  }
  LinkedList list=new LinkedList();
    //list.printAllBoxes();     //prints all boxes in the linkedList
    //printReverse();      //Reverse-prints all boxes in the linkedList
  
  //Find the smallest box
  public static void printSmallestBox(){     //MUST call getNextBox() to iterate over the linked list
    Box smallestBox = head;
    int i=1;           //Use as a counter
    int smallestPosition = 1;
    
    while(head != null){           //while the linked list isn't empty, cycle through
      getNextBox();
      if(iterator.getVolume() < smallestBox){   //if volume of current box is smaller than smallest, it become the smallest
        smallestBox = iterator;
        smallestPosition = i;      //the position of the smallest box is recorded
        iterator = iterator.next;
        i++; 
      }
      System.out.println("The smallest box is number "+smallestPosition+", with a volume of "+smallestBox.getVolume());
    }
  }
  
  //Find the largest Box 
  public static void printLargestBox(){      //MUST call getNextBox() to iterate over the linked list
    
    Box largestBox = head;
    int i=1;                //counter
    int largestPosition = 1;   //separate from counter
    
    while(head != null){
      getNextBox();
      if(iterator.getVolume() < largestBox){ //use iterator as head and compare to rest of linked list
        largestBox = iterator;
        largestPosition = i;    //retrive position if a larger box is found
        iterator = iterator.next;
        i++;  //use counter to traverse through linked list 
      }
      System.out.println("The largest box is number "+largestPosition+", with a volume of "+largestBox.getVolume());
    }
  }
  
  //Find the number of cubic boxes WILL REQUIRE ITERATION
  public static void numberOfCubicBoxes(){
    
    int numberOfCubicBoxes = 0;
    int i=1;                        //traverse counter
    
    while(head != null){
      //initalizeIterator();         //Makes no sense without setting "getNextBox" to "iterator = iterator.next"   !!!
      getNextBox();
      if(iterator.isCube() == true) //use iterator as head and compare to rest of linked list
        numberOfCubicBoxes++;    //use as counter for the number of cubic boxes
      iterator = iterator.next;
      i++;
    }
      System.out.println("There are "+numberOfCubicBoxes+" cubic boxes");
    }
  
  boolean remNode = removeNode(4);           //removes node at position 4
  boolean inputNode = insertNode(b, 5);      //inserts node at position 5
}
