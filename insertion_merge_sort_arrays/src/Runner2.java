/*
 * By: Matthew S Montoya
 * Purpose: To practice insertion sort and merge sort using arrays
 * Last Modified: 15 January 2018
 * Note: This is the runner file.
 */

public class Runner2{    //Speed test
  public static void main(String[] args){

//Test the speeds of insertion and merge sort methods (copied from Runner1)
    int numOfBoxes = 10000;
    
    Box firstArray[] = arrayOfBoxes(numOfBoxes);              //Create the array
////////////////////////////////////////////////////////////
    long timeStartMillis1 = System.currentTimeMillis();  //    begin logging time
    long timeStartNano1 = System.nanoTime();            //
/////////////////////////////////////////////////////////
    
    Box iSort[] = insertionSort(firstArray);                 //Sort via insertion sort
    
////////////////////////////////////////////////////////////     
    long timeEndMillis1 = System.currentTimeMillis();    //   End logging time
    long timeEndNano1 = System.nanoTime();              //
/////////////////////////////////////////////////////////
    
    System.out.println("The time needed to sort a list of 10,000 boxes using Insertion Sort is "     //Calculate & print out times
                         +(timeEndMillis1-timeStartMillis1)+"ms.");
    

////////////////////////////////////////////////////////////
    long timeStartMillis2 = System.currentTimeMillis();  //    begin log
    long timeStartNano2 = System.nanoTime();            //
/////////////////////////////////////////////////////////
    
    Box mSort[] = mergeSort(firstArray);                    //Sort via merge
    
////////////////////////////////////////////////////////////     
    long timeEndMillis2 = System.currentTimeMillis();    //   End log
    long timeEndNano2 = System.nanoTime();              //
/////////////////////////////////////////////////////////
        
    System.out.println("The time needed to sort a list of 10,000 boxes using Merge Sort is "     //Calculate & print
                         +(timeEndMillis2-timeStartMillis2)+"ms.");
  }
  
  
  public static Box[] arrayOfBoxes(int numOfBoxes){
    
    Box[] boxes = new Box[numOfBoxes];
    int i=0;
    
    //Randomly generte l,w,h between 1 & 100
    while(i<boxes.length){      ///Only less than, NOT EQUALS; otherwise nullPointerException error
      boxes[i] = new Box();     //Iniatiate the boxes
      boxes[i].length = (int)(Math.random()*100);   //set them equal to ints
      boxes[i].width = (int)(Math.random()*100);
      boxes[i].height = (int)(Math.random()*100);
      i++;     //increment/traverse as you go along
    }
    return boxes;
  }
  
  
  //Method copyArray that will create a new array of boxes with identical values of the given one
  public static Box[] copyArray(Box[] firstArray){
    Box[] boxCopy = new Box[firstArray.length];
    
    int i=0;
    while(i<boxCopy.length){      ///Only less than, NOT EQUALS; otherwise nullPointerException error
      boxCopy[i] = new Box();     //Iniatiate the boxes
      boxCopy[i].length = (int)(firstArray[i].length);   //set them equal to ints
      boxCopy[i].width = (int)(firstArray[i].width);
      boxCopy[i].height = (int)(firstArray[i].height);
      i++;     //increment/traverse as you go along
    }
    return boxCopy;
  }
  
  
//Method: insertionSort. Must take in the new array and sort the boxes in ascending order of the volumes
  public static Box[] insertionSort(Box[] copy){
    Box temp;     //temporary box
    for (int i=1; i<copy.length; i++) {
      for(int j=i; j>0; j--){
        if(copy[j].calculateVolume()<copy[j-1].calculateVolume()){   //if the current box volume is less than the box before it...
          temp = copy[j];
          copy[j] = copy[j-1];
          copy[j-1] = temp;     //...switch it
        }
      }  
    }
    return copy;
  }
  
  
//Method: MergeSort. Must take in the new array and sort the boxes in ascending order of the volumes  
  public static Box[] mergeSort(Box[] arrayCopy){
    if (arrayCopy.length <= 1)   //Base case; if 1, array is sorted by default
      return arrayCopy;   
    
    Box[] leftHalf = new Box[arrayCopy.length / 2];                   //left side will be 1st (1/2) of array   |\/ 1/2 via each iteration  |\/ use center as random split
    Box[] rightHalf = new Box[arrayCopy.length - leftHalf.length];    //right side will be 2nd (1/2) of array  |\/ 1/2 via each iteration
    
    System.arraycopy(arrayCopy, 0, leftHalf, 0, leftHalf.length);                    //copies leftHalf.length-elements of arrayCopy to the new leftHalf array 
    System.arraycopy(arrayCopy, leftHalf.length, rightHalf, 0, rightHalf.length);    //copies rightHalf.length-elements of arrayCopy to the leftHalf array
    
    mergeSort(leftHalf);   //recursive calls
    mergeSort(rightHalf);
    
    merge(leftHalf, rightHalf, arrayCopy);  //call a second merge method to combine everything togetheer
    
    return arrayCopy;
  }
  
  
//Method Extention: Merge halves together   
  private static Box[] merge(Box[] leftHalf, Box[] rightHalf, Box[] modifiedCopy) {
    
    int leftCounter = 0, rightCounter = 0;  //to traverse through each array

    int i=0;  //genral counter
    
    while (leftCounter<leftHalf.length && rightCounter<rightHalf.length){   //positional; e.g. if i<n    |\/ minus the "i" and ALL ACTUAL NUMBERS!! -_-
      if(leftHalf[leftCounter].calculateVolume() < rightHalf[rightCounter].calculateVolume()){
        modifiedCopy[i] = leftHalf[leftCounter];     //lesser volume boxes to the left
        leftCounter++;
      }
      else{
        modifiedCopy[i] = rightHalf[rightCounter];   //greater volume boxes to the right
        rightCounter++;   //keep traversing
      }
      i++;
    }
    return modifiedCopy;
  }
}
