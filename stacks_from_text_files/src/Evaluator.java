/*
 * By: Matthew S Montoya
 * Purpose: To practice implementing stacks from a text file
 * Last Modified: 15 January 2018
 * Note: This is the runner file.
 */

import java.util.*;
import java.io.*;

public class Evaluator{
  public static void main(String[] args) throws IOException{
    try {
      Scanner input = new Scanner(System.in);   //for user response
      System.out.println("Enter the name of the file.");
      String file = input.next();
      readFile(file);
      input.close();   //close file
    }  
    catch (FileNotFoundException ex){
      System.out.println("The file cannot be found. Please try again.");
    }
    catch (InputMismatchException ex){
      System.out.println("Input mismatch: The data in the files has the incorrect data type.");
    }
    catch (NumberFormatException ex){
      System.out.println("Number format error: The data in the files has the incorrect data type.");
    }
  }
  
  
  public static void readFile(String fileName) throws IOException{
    Scanner voidScanner = new Scanner(new File(fileName));   //to read the file
    String operator = null;
    int num1 = 0;   //1st number that will be operated on in the stack
    int num2 = 0;   //2nd number that will be operated on in the stack
    
    int count1 = 0;   //Stores count of numbers
    int count2 = 0;   //Stores count of operators
    
    while(voidScanner.hasNextLine()){  //checks for expressions
      GenericStack stack = new GenericStack();   //create a new stack
      
      String[] line = voidScanner.nextLine().split(" "); //array to store expressions 
      for(int i=0; i<line.length; i++) {    //compiles ratio of numbers to operators 
        if(line[i].equals("0")||line[i].equals("1")||line[i].equals("2")||line[i].equals("3")||
           line[i].equals("4")|| line[i].equals("5")||line[i].equals("6")||line[i].equals("7")||line[i].equals("8")|| line[i].equals("9")){
          count1++;     //increment count of numbers
        }
        else{
          count2++;     //increment count of operators
        }
      }
      
      if(count1-count2 != 1){   //if ratio of numbers to operators is incomplete, let user know
        System.out.println("The expression is incomplete.");
      }
      else{                     //else, begin pushing into the stack
        
        for(int j=0; j<line.length; j++) {
          if(line[j].equals("0")||line[j].equals("1")||line[j].equals("2")||line[j].equals("3")||
           line[j].equals("4")|| line[j].equals("5")||line[j].equals("6")||line[j].equals("7")||line[j].equals("8")|| line[j].equals("9")){
            stack.push(Integer.parseInt(line[j]));   //if number: pushes integer @ pos. j \/ REMEMBER TO PARSE
          }
          else{                         //otherwise store as operators
            operator = line[j];
            num1 = (Integer)stack.pop();      //pop first two numbers to work with operator
            num2 = (Integer)stack.pop();
            
            if(operator.equals("+"))   //peform math operations
              stack.push(num1+num2);
            else if(operator.equals("-"))
              stack.push(num1-num2);
            else if(operator.equals("*"))
              stack.push(num1*num2);
            else if(operator.equals("/"))
              stack.push(num1/num2);
          }
        }
        System.out.println("The total of the postfix expression is "+(Integer)stack.peek());   //Provide total to user
      }   
    }
    voidScanner.close();
  } 
}
