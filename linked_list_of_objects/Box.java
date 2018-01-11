/*
 * By: Matthew S Montoya
 * Purpose: To practice creating linked lists of objects and finding their largest and smallest values
 * Last Modified: 11 January 2018
 * Note: This is NOT the runner file.
 */

public class Box{
  
  public Box next;        //only public variable
  private double length; 
  private double width;   //set dementions
  private double height;
  
    Box(double length, double width, double height){  //object creation with values 
    this.length = length;
    this.width = width;
    this.height = height;
  }
    Box(){}          //object creation without values passed through
  
//getters (double)
  public double getLength(){
    return length;
  }
  public double getWidth(){
    return width;
  }
  public double getHeight(){
    return height;
  }
  public double getVolume(){
    return length*width*height;
  }
  
//setters (void)
  public void setLength(double length){
    this.length = length;
  }
  public void setWidth(double width){
    this.width = width;
  }
  public void setHeigth(double height){
    this.height = height;
  }
  public void setNext(Box next){
    this.next = next;
  }
  
//Extras: Boolean for cubic method
  public boolean isCube(){
    if(length == width && width == height)  //test for true or false
      return true;
    else
      return false;
  }
}  
