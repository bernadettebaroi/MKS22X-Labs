import java.util.*;
import java.io.*;
public class MazeGenerator {
  public static void generate(char[][]maze, int startrow, int startcol) {
    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        maze[i][j] = '#';
      }
    }

    randomizer(maze,startrow,startcol,0);

    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        System.out.print(maze[i][j]);
      }
      System.out.print("\n");
    }

  }

  public static int randomizer(char[][]maze, int row,int col, int s) {
    if (emptySpace(maze,row,col)) {
      return 1;
    } else if (s > 5) {
      maze[row][col] = 'E';
      return 0;
    } else {
      if (s == 0) {
        maze[row][col] = 'S';
      }
      s+=1;
      maze[row][col] = ' ';
      int random = randomizer(maze, row+1, col,s);
      if (random > -1) {
        maze[row+1][col] = ' ';
      }
      int random1 = randomizer(maze, row-1, col,s);
      if (random1 > -1) {
        maze[row-1][col] = ' ';
      }
      int random2 = randomizer(maze, row, col+1,s);
      if (random2 > -1) {
        maze[row][col+1] = ' ';
      }
      int random3 = randomizer(maze, row, col-1,s);
      if (random3 > -1) {
        maze[row][col-1] = ' ';
      }
      return -1;
    }
  }

  public static boolean emptySpace(char[][]maze, int row, int col) {
    int ans = 0;
    if (row +1 < maze.length-1 && maze[row+1][col] == ' ') {
      ans += 1;
    }
    if (row -1 > 0 && maze[row-1][col] == ' ') {
      ans += 1;
    }
    if (row +1 < maze[0].length-1 && maze[row][col+1] == ' ') {
      ans += 1;
    }
    if (col -1 > 0 && maze[row][col-1] == ' ') {
      ans += 1;
    }
    if (ans < 2) {
      return true;
    }
    return false;
  }

}
