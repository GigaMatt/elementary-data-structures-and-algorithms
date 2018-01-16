/*
 * By: Matthew S Montoya
 * Purpose: To practice insertion sort and merge sort using arrays
 * Last Modified: 15 January 2018
 * Note: This is NOT the runner file.
 */

public class Box{
  
  public double length;
  public double width;
  public double height;
  public double volume;
  
  public Box(double l, double w, double h)
  {
    length=l;
    width=w;
    height=h;
    volume = length*width*height;
  }
  
  public Box(){}
  
//getters
  public double calculateVolume(){
    return (length*width*height);
  }
}
