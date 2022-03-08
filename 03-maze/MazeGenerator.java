import java.util.*;
import java.io.*;
public class MazeGenerator {

  
  public static void generate(char[][]maze, int startrow, int startcol) {
    makeBlank(maze);
    generator(maze,startrow,startcol);
    maze[startrow][startcol] = 'S';
    placeEnd(maze,startrow,startcol);
  }


  public static void makeBlank(char[][]maze) {
    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        maze[i][j] = '#';
      }
    }
  }


  public static void generator(char[][]maze, int row,int col) {
    //can carve: not on border, not a space, fewer than 2 neighboring spaces
    if(canCarve(maze,row,col)){
      maze[row][col] = ' ';
      ArrayList<int[]>directions = new ArrayList<int[]>();
      int[] south = {1,0};
      int[] north = {-1,0};
      int[] west = {0,-1};
      int[] east = {0,1};
      directions.add(south);
      directions.add(north);
      directions.add(west);
      directions.add(east);

      while(directions.size() > 0){
        Collections.shuffle(directions);
        generator(maze,row+directions.get(0)[0],col+directions.get(0)[1]);
        directions.remove(0);
      }
    }
  }


  public static boolean canCarve(char[][]maze, int row,int col) {
    if (row == maze.length-1 || row == 0 || col == 0 || col == maze[0].length-1) {
      return false;
    }
    if (maze[row][col] != '#') {
      return false;
    }
    int ans = 0;
    if ( row < maze.length-1 && row > 0 && col > 0 && col < maze[0].length-1) {
      if (maze[row+1][col] == ' ') {
        ans += 1;
      }
      if (maze[row-1][col] == ' ') {
        ans += 1;
      }
      if (maze[row][col+1] == ' ') {
        ans += 1;
      }
      if (maze[row][col-1] == ' ') {
        ans += 1;
      }
    }
    if (ans < 2) {
      return true;
    }
    return false;
  }


  public static void placeEnd(char[][]maze, int row, int col) {
    int placeEndRow = 0;
    int placeEndCol = 0;
    if (row < maze.length / 2 && col < maze[0].length / 2) {
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length;j++) {
          if (maze[i][j] == ' ')  {
            placeEndRow = i;
            placeEndCol = j;
          }
        }
      }
    } else {
      for (int i = maze.length -2; i > 0; i--) {
        for (int j = maze[0].length -2; j > 0;j--) {
          if (maze[i][j] == ' ')  {
            placeEndRow = i;
            placeEndCol = j;
          }
        }
      }
    }
    maze[placeEndRow][placeEndCol] = 'E';
  }


}
