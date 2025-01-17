/*
 * By: Matthew S Montoya
 * Purpose: To practice reading files with buffered reader and file reader, as well as working with classes in separate programs
 * Last Modified: 11 January 2018
 * Note: This is NOT the runner file.
 */
public class Package
{
  
  public double length;
  public double width;
  public double height;
  
  public Package(double l, double w, double h)
  {
    length=l;
    width=w;
    height=h;
  }
  
//getters
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
    return (length*width*height);
  }
  
//setters
  
  public void setDeminsions(double l, double w, double h){
    length = l;
    width = w;
    height = h;
    
  }
  public void setLength(double l){
    length = l;
  }
  public void setWidth(double w){
    width = w;
  }
  public void setHeight(double h){
    height = h;
  }

//Other
  public boolean isCube(){
    if(length==width && width==height)
      return true;
    else
      return false;
  }
}
