/*
* By: Matthew S Montoya
* Purpose: To practice insertion sort and merge sort using arrays
* Last Modified: 15 January 2018
* Note: This is the runner file.
*/

public class Runner1{
  public static void main(String[] args){

//Demonstrate the code works by generating a random list of 20 boxes, printing the list before AND sorting using via insertion and merge sort.  
    int numOfBoxes = 20;
    
    Box firstArray[] = arrayOfBoxes(numOfBoxes);    //Create the array
    printArrayOfBoxen(firstArray);                  //Print the list
    Box copy[] = copyArray(firstArray);             //Copy the array
    Box iSort[] = insertionSort(copy);              //Sort via insertion sort

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Verify insetionSort is working                                                                                                       /////
    int i=0;                                                                                                                              /////
    System.out.println();                                                                                                                /////
    System.out.println("After Insertion Sort:");                                                                                        /////
    while(i<numOfBoxes){                                                                                                               /////
      System.out.println("The length, width, & height of Box #"+(i+1)+" are "+(int)iSort[i].length+", "                               /////
                           +(int)iSort[i].width +", "+(int)iSort[i].height +", with a volume of "+(int)iSort[i].calculateVolume());  /////
      i++;                                                                                                                          /////
    }                                                                                                                              /////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      printArrayOfBoxen(firstArray);                  //Print the list again
      Box mSort[] = mergeSort(copy);                  //Implement merge sort
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Verify mergeSort is working                                                                                                          /////
    int j=0;     //You're in main; i was already used                                                                                     /////
    System.out.println();                                                                                                                /////
    System.out.println("After Megre Sort:");                                                                                            /////
    while(j<numOfBoxes){                                                                                                               /////
      System.out.println("The length, width, & height of Box #"+(j+1)+" are "+(int)mSort[j].length+", "                               /////
                           +(int)mSort[j].width +", "+(int)mSort[j].height +", with a volume of "+(int)mSort[j].calculateVolume());  /////
      j++;                                                                                                                          /////
    }                                                                                                                              /////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  }
  
  
//Generate a random list of boxes for testing. Method should take in (20) the size of the list and return an array of that many boxes    
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
  
  
//Method to print the array of boxen. Each line should be the l,w,h && v of a specific box
  public static void printArrayOfBoxen(Box[] firstArray){
    System.out.println();
    System.out.println("The Random Array:");
    for(int i=0; i<firstArray.length; i++){
      System.out.println("The length, width, & height of Box #"+(i+1)+" are "+(int)firstArray[i].length+", "
                           +(int)firstArray[i].width +", "+(int)firstArray[i].height +", with a volume of "+(int)firstArray[i].calculateVolume());
    }
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
    Box temp;                            //temporary box
    for (int i=1; i<copy.length; i++){
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
  
  
    
    
    
    arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    
    
    public static int[] arraycopy(m, int[] randomizedArray){
        
        int[] randomArrayCopy = new int[randomizedArray.length];
        
        Sysrem.arraycopy(randomizedArray, 0, randomArrayCopy, 0, m);
        return randomArrayCopy;
        
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
