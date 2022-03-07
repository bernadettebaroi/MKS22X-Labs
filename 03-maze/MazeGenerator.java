import java.util.*;
import java.io.*;
public class MazeGenerator {
  public static void generate(char[][]maze, int startrow, int startcol) {
    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        maze[i][j] = '#';
      }
    }
    placeEnd(maze,startrow,startcol);
    randomizer(maze,startrow,startcol);
    maze[startrow][startcol] = 'S';
  }

  public static void placeEnd(char[][]maze, int startrow, int startcol) {
    int len = maze.length-2;
    int wid = maze[0].length-2;
    int row = (int)(Math.random() * len + 1);
    int col = (int)(Math.random() * wid + 1);
    if (row == startrow && col == startcol) {
      placeEnd(maze,startrow,startcol);
    } else {
      maze[row][col] = 'E';
    }
  }

  public static int randomizer(char[][]maze, int row,int col) {
    if (maze[row][col] == ' ') {
      return -1;
    } else if (maze[row][col] == 'E') {
      return 0;
    } else {
      if (row < maze.length -1 && row > 0 && col < maze[0].length-1 && col > 0) {
        maze[row][col] = ' ';
        int s = randomizer(maze, row+1,col);
        if (s > -1) {
          return s +1;
        }
        int w = randomizer(maze,row,col-1);
        if (w > -1) {
          return w +1;
        }
        int n = randomizer(maze,row-1,col);
        if (n > -1) {
          return n+1;
        }
        int e = randomizer(maze,row,col+1);
        if (e > -1) {
          return e +1;
        }
        return -1;
      }
      return -1;
    }
  }


}
