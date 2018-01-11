import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;   //info so that way the file can be read.

public class TwoDimensionalarray{
  
  public static void main(String[] args){          //Main Method
    int[] size = new int[2];
      Scanner scanner = new Scanner(System.in);
    System.out.println("What is the name of the file?");
   

    try{
      String s = scanner.nextLine();
      size = Vehicles(s);
      double[][] array = Car(s, size);
       
   totalpumped(array); //methods being called
      fuelavg(array);
      amountavg(array);
      maxgas(array);
      mingas(array);
    
    }catch(FileNotFoundException e){
      System.err.println("File not found:" + e.getMessage());
    }catch(IOException e){
      System.err.println("File not found:" + e.getMessage());
    }
    
    
    double fuelexpense[][];           //syntax of declairing two dimensional arrays
    fuelexpense = new double[0][0];
    double sum = 0;

  }
  //how many total gallons were pumped in each vehical
  public static void totalpumped(double[][] a){
    System.out.println();
    double s = 0;
    for(int i= 0; i< a.length; i++) {            
      for(int j = 0; j<a[i].length; j ++){
        s = s+a[i][j];
      }
      System.out.println("car " + (i+1) + " had "+ s + " gallons ");
      s = 0;
    }
  }
  // going to find the average amount of gas pumped during a fueling for each vehicle
  public static void fuelavg(double[][] b){
    System.out.println();
    double g = 0;
    for(int i = 0; i<b.length; i++){
      for(int j=0; j<b[i].length;j++){
        g = g+b[i][j];
      }
      g = g/b.length;
      System.out.println("car " + (i+1) + " had "+ g + " average ");
      g = 0;
    }
  }
  
  //Average gas pumped for each colmn    
  public static void amountavg(double[][] c){
    System.out.println();
    double a = 0;
    for(int j=0; j<c[0].length;j++){
      for(int i=0; i<c.length; i++){
        a = a+c[i][j];
      }
      
      a = a/c.length;
      System.out.println( "pump " + (j+1) + " avg " + a);
      a = 0;
    }
  }
  
  
  
  
//Max amount of gas pumped into each vehicle in a week
  public static void maxgas(double[][] d){
    System.out.println();
    for(int i = 0; i<d.length; i++){
      double max = d[i][0]; // assign the firt value of the row as max
      for(int j=0; j<d[i].length; j++){
        if(d[i][j] > max)
          max = d[i][j];
        
      }
      System.out.println("Car" + (i+1) + " " + max + " Max ");
    }
  }
  
  // min amount of gas pumped into each vehicle in a week
  public static void mingas(double[][] e){
    System.out.println();
    for(int i =0; i <e.length; i++){ 
      double min = e[i][0];
      for(int j=0; j<e[i].length; j++){
        if(e[i][j] < min )
          min = e[i][j];
      }
      System.out.println("Car" + (i+1) + " " + min + " Min");
    }
  }
  
  
  public static int[] Vehicles(String fileName) throws IOException {  //file method to go through and read piece of information from the file
    Scanner sc = new Scanner(new File(fileName)).useDelimiter("(\\b)");// delimiter is to force the method to read white space
    sc.useLocale(Locale.US);
    double note = 0;
    int row = 1;
    int col =1;
    int flag = 0; // signals the to stop counting columns
    String name;
    
    int[] size = new int[2];
    
    while(sc.hasNextDouble()) { // can read number in the text file
      note = sc.nextDouble();
      if(sc.hasNext()){        //to check last space 
        name = sc.next();  // looking at the next character in the file
      }
      else{
       break; // command to get out of while loops 
      }
      if(name.contains("\n")){//if it is or is not a new line
        row++;         // going to know how many rows and columns
        flag = 1;
      }
      else if(name.equals(" ")){
        if(flag != 1)
          col++;
      }else if(name.equals(".")){
        note = sc.nextDouble();
        name = sc.next();
        if(name.contains("\n")){
          row++;
          flag=1;
        }
        if(flag != 1)
          col++;
      }
      //System.out.println(note);
    }
    
    size[0] = row;
    size[1] = col;
    return size;
  }
  
  public static double[][] Car(String fileName, int[] size) throws IOException {  //file method to plug in the information for the array
    Scanner sc = new Scanner(new File(fileName)).useDelimiter("(\\b)");
    sc.useLocale(Locale.US);
    double note = 0;
    int row = 0;
    int col =0;
    int flag =0;
    String name;
    
    double[][] fileArray = new double[size[0]][size[1]]; // made an array to read rows and columns
 
    while(sc.hasNextDouble()) {
      note = sc.nextDouble();
      if(sc.hasNext()){        //to check last space 
        name = sc.next();  // looking at the next character in the file
        //System.out.println(name);
      }
      else{
        fileArray[row][col] = note;  //before you break need to put last number in 
       break; // command to get out of while loops 
      }
      if(name.contains("\n")){                              //if it is or is not a new line
          fileArray[row][col] = note;
          System.out.println("["+row+"]["+col+"] gets: "+note);
          row++;
          flag = 1;
        col = 0;
      }
      else if(name.equals(" ")){
        fileArray[row][col] = note;
        System.out.println("["+row+"]["+col+"] gets: "+note);
        col++;
      }else if(name.equals(".")){
        double dec = 0;
        dec = sc.nextDouble();
         dec= dec/10;
         note = note + dec;
         fileArray[row][col] = note;
         System.out.println("["+row+"]["+col+"] gets: "+note);
         name = sc.next();  
         col++;
         if(name.contains("\n")){
          row++;
          flag=1;
          col=0;
        }
         
      }
    }
    for(int i = 0; i <fileArray.length; i++)
      for(int j = 0; j<fileArray[i].length; j++)
      System.out.println(fileArray[i][j]);
    return fileArray;
  }
}















