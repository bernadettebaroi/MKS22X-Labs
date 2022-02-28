import java.util.*;
import java.io.*;
public class Maze {
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;
  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */
  public static void main(String[] args) {
    String filename = args[0];
    try {
      File text = new File(filename);
      Scanner input = new Scanner(text);
      while (input.hasNextLine()) {
        System.out.println(input.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: File not Found");
    }
  }

  public static void charArr(){
    char[][] maze = new char[][];
    for(int i = 0; i < maze.length;i++) {

    }
  }


}
