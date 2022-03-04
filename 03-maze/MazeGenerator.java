import java.util.*;
import java.io.*;
public class MazeGenerator {
  public static void generate(char[][]maze, int startrow, int startcol) {
    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        maze[i][j] = '#';
      }
    }
    randomizer(maze,startrow,startcol);
    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        System.out.print(maze[i][j]);
      }
      System.out.print("\n");
    }

  }

  public static int randomizer(char[][]maze, int row,int col) {
    if (!emptySpace(maze,row,col)) {
      return -1;
    } else {
      int random = (int)(Math.random() * 4 + 1);
      if (random == 0 ) {
        maze[row][col] = ' ';
        if (randomizer(maze, row+1,col) == -1) {
          randomizer(maze, row-1,col);
        }
        randomizer(maze, row+1,col);
        return 0;
      } else if (random == 1) {
        maze[row][col] = ' ';
        if (randomizer(maze, row-1,col) == -1) {
          randomizer(maze, row+1,col);
        }
        randomizer(maze,row-1,col);
        return 0;
      } else if (random == 2) {
        maze[row][col] = ' ';
        if (randomizer(maze, row, col+1) == -1) {
          randomizer(maze, row,col-1);
        }
        randomizer(maze, row, col+1);
      } else {
        maze[row][col] = ' ';
        if (randomizer(maze, row, col-1) == -1) {
          randomizer(maze, row,col+1);
        }
        randomizer(maze, row,col-1);
        return 0;
      }
    }
    return 0;
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
