/*
 * By: Matthew S Montoya
 * Purpose: To practice reading files with buffered reader and file reader, as well as working with classes in separate programs
 * Last Modified: 11 January 2018
 * Note: This is the runner file.
 */

import java.io.*;

public class Runner
{
  public static void main (String[]args) throws IOException 
  {
    try{
      Package[] packageArray = new Package[6];
      int i = 0;                   //Used for position
      FileReader fw = new FileReader("array.txt");     //Assuming the text file is within the same folder
      BufferedReader br = new BufferedReader(fw);
      double[] tempPack;           //temporary array of packages
      
      while(br.ready())
      {
        String thisLine = br.readLine(); //thisLine: used for current line to be read
        System.out.println(thisLine);
        String[] lineParts = thisLine.split(" "); //Splits line at spaces into parts
        for(int p=0; p<lineParts.length; p++){
          System.out.println(lineParts[p]);
        }
        
        //Call method to parse String
        tempPack = convert(lineParts);      //Problem Area   !!!
        Package newPack = new Package(tempPack[0], tempPack[1], tempPack[2]);
        packageArray[i] = newPack;
        i++;
      }
      br.close();
      
      //Call calculation methods (All non-return)
      smallestPackage(packageArray);
      largestPackage(packageArray);
      numberOfCubicPackages(packageArray);
      smallestCubicPackage(packageArray);  //finds the index of the smallest cubic package
      largestCubicPackage(packageArray);   //finds the index of the largest cubic package
      avgVolume(packageArray);             //finds the average volume of ALL packages
      avgVolumeCubic(packageArray);        //finds the average volume of the cubic packages
      
    }catch(Exception e){
      System.out.println("Error: Exception e");
    }  
  }
  
//Parse method (parsing Strings into doubles)    
  public static double[] convert(String[] lineParts){  //Not passing through here (Error: Empty String)   !!!
    double[] parsed = new double[lineParts.length];
    for(int i=0; i < lineParts.length; i++){
      System.out.println(lineParts[i]);
      double temp = Double.parseDouble(lineParts[i]);
      parsed[i] = temp;
      System.out.println(parsed[i]);
    }
    return parsed;                          //Return double values to store in objects
  }
  
//Smallest Package  
  public static void smallestPackage(Package[] array)
  {
    int i = 1;               //Used for counter, Start at 1 to compare package 2 to package 1
    int smallestPack = 1;   //set smallest package to 1
    while(i<array.length){
      if(array[i].getVolume() < array[i-1].getVolume())  //if currentVolume < previousVolume
        smallestPack = i;
      i++;
    }
    System.out.println("The smallest package is package "+smallestPack);
  }
  
//Largest Package  
  public static void largestPackage(Package[] array)
  {
    
    int i = 1;               //Used for counter, Start at 1 to compare package 2 to package 1
    int largestPack = 1;    //set largest package to 1
    while(i<array.length){
      if(array[i].getVolume() > array[i-1].getVolume())  //if currentVolume > previousVolume
        largestPack = i;
      i++;
    }
    System.out.println("The largest package is package "+largestPack);
  }
  
//Number of Cubic Packages
  public static void numberOfCubicPackages(Package[] array)
  {
    int i = 0;              //Used for counter, Start at 0 because we're comparing just the array
    int cubicPackages = 0;  //number of cubic packages
    while(i<array.length){
      if(array[i].getLength() == array[i].getWidth() && array[i].getWidth() == array[i].getHeight())
        cubicPackages++;
      i++;
    }
    System.out.println("There are "+cubicPackages+" cubic packages.");
  }
  
//Smallest Cubic Package
  public static void smallestCubicPackage(Package[] array)
  {
    //Get Largest Volume... this will be used as the Smallest Volume
    double largestVolume = 0;
    int i = 1;
    while(i<array.length){
      if(array[i].getVolume() > array[i-1].getVolume()){
        largestVolume = array[i].getVolume();
      }
      i++;
    }
    
    //Find smallest cubic box, if any
    double volume;
    double smallestVolume = largestVolume; //Use largest volume as Smallest Volume (for comparison)
    int scPackageIndex = 0;                //Index of where smallest package is
    int index = 0;                         //index of array
    boolean sentinel = false;              //set boolean to false, as there may not be any cubic packages
    
    while(index<array.length){
      if(array[index].getLength() == array[index].getWidth() && array[index].getWidth() == array[index].getHeight()){     //Tests for cubic measurements
        sentinel = true;
        volume = array[index].getVolume();
        if(sentinel){                    //if there is a small(est) cubic package, get volume and index
          if(volume < smallestVolume){
            smallestVolume = volume;
            scPackageIndex = index+1;
          }
        }
      }
      index++;
    }
    
    //Report Index, Dimensions, & Volume
    if(smallestVolume < largestVolume)
      System.out.println("The smallest cubic package is package number "+scPackageIndex+", with a length of "+array[index].getLength()+", a width of "+array[index].getWidth()+", a height of "+array[index].getHeight()+", and a volume of "+array[index].getVolume());
    else
      System.out.println("There are no cubic packages.");
  }
  
//Largest Cubic Package
  public static void largestCubicPackage(Package[] array)
  {
    //Get Smallest Volume... this will be used as the Largest Volume
    double smallestVolume = 0;
    int i = 1;
    while(i<array.length){
      if(array[i].getVolume() < array[i-1].getVolume()){
        smallestVolume = array[i].getVolume();
      }
      i++;
    }
    
    //Find smallest cubic box, if any
    double volume;
    double largestVolume = smallestVolume; //Use largest volume as Smallest Volume (for comparison)
    int lcPackageIndex = 0;                //index of the largest cubic package
    int index = 0;                         //index of the array
    boolean sentinel = false;              //set boolean to false, as cubic packages may not exist
    
    while(index<array.length){
      if(array[index].getLength() == array[index].getWidth() && array[index].getWidth() == array[index].getHeight()){   //Tests if cubic requirements are true
        sentinel = true;
        volume = array[index].getVolume();
        if(sentinel){                     //if there is a cubic package(s), get the volume and index
          if(volume > largestVolume){
            largestVolume = volume;
            lcPackageIndex = index+1;
          }
        }
      }
      index++;
    }
    
    //Report Index, Dimensions, & Volume
    if(largestVolume < smallestVolume)
      System.out.println("The largest cubic package is package number "+lcPackageIndex+", with a length of "+array[index].getLength()+", a width of "+array[index].getWidth()+", a height of "+array[index].getHeight()+", and a volume of "+array[index].getVolume());
    else
      System.out.println("There are no cubic packages.");
  }
  
//Average volume of all packages
  public static void avgVolume(Package[] array){
    double totalVolume = 0;                        //package dementions are doubles
    double averageVolume;
    int i =0;
    while(i<array.length){
      totalVolume += array[i].getVolume();         //Adds all package volumes
      i++;
    }
    averageVolume = totalVolume/(double) i;        //i is an interger; we need it to be a double
    System.out.println("The average volume of all the packages is "+averageVolume);
  }
  
//Average volume of cubic packages
  public static void avgVolumeCubic(Package[] array){
    int i=0;                    //use i as the counter
    double totalVolume = 0;
    double avgVolume;
    while(i<array.length);{     //length of the array
      if(array[i].getLength() == array[i].getWidth() && array[i].getWidth() == array[i].getHeight()) //tests if cubic conditions are met
        totalVolume+= array[i].getVolume();
      i++;
    }
    if(totalVolume > 0){      //if cubic conditions are true:
      avgVolume = totalVolume/(double) i;
      System.out.println("The average volume of all the cubic packages is "+avgVolume);}
    else                     //if NO cubic packages
      System.out.println("There are no cubic packages"); 
  }
}
