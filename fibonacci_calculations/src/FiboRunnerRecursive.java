/*
 * By: Matthew S Montoya
 * Purpose: To practice calculating the nth Fibonacci value iteratively and recursively
 * Last Modified: 14 January 2018
 * Note: This is the runner file.
 */
import java.lang.*;

public class FiboRunnerRecursive{
  public static void main(String[] args){
    int solveForX = 3;
    System.out.println("Recursive Loop:");
    System.out.println("n"+"\ttime(ms)"+"\ttime(ns)"+"\t\tnth Fibonacci Number");
    
    while(solveForX <= 50){
      //////////////////////////////////////////////////////
      long timeStartMillis = System.currentTimeMillis(); //begin logging time
      long timeStartNano = System.nanoTime();            //
      ////////////////////////////////////////////////////
      
      long recursiveFibonacciNumber = rFibonacciSequence(solveForX);   //Call method
      
      /////////////////////////////////////////////////////      
      long timeEndMillis = System.currentTimeMillis();   //End logging time
      long timeEndNano = System.nanoTime();              //
      /////////////////////////////////////////////////////
      System.out.println(solveForX+"\t"+(timeEndMillis-timeStartMillis)+"\t"+(timeEndNano-timeStartNano)+"\t\t"+recursiveFibonacciNumber);//Calculate & print out times
      solveForX++;   //iterate
    }
  }
  
  
//Calculate the X fibonaccci number at position n RECURSIVELY
  public static long rFibonacciSequence(int n){ 
    if(n==0)            //base case 1: pos 0
      return 0;
    if (n==1 || n==2)   //base case 2: pos 1 or 2
      return 1;
    else       //next pos equals sum of two prev Fibo numbers
      return rFibonacciSequence(n-1) + rFibonacciSequence(n-2);
  }
}
