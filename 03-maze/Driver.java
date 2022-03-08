import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String[]args){
    //files do not require an extension like .txt or .dat
    String filename = "maze6";
    try{
      Maze f;
      f = new Maze(filename);
      f.setAnimate(true);
      System.out.println(f.solve()+" steps");
      System.out.println(f);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+filename);
    }
  }
}
