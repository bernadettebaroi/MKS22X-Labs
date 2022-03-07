import java.util.*;
import java.io.*;
public class MazeGenerator {
  public static void generate(char[][]maze, int startrow, int startcol) {
    int row = (int)(Math.random() * maze.length-1 + 1);
    int col = (int)(Math.random() * maze[0].length-1 + 1);
    if (row == startrow && col == startcol) {
      generate(maze,startrow,startcol);
    }
    for (int i = 0; i < maze.length;i++) {
      for (int j = 0;j < maze[0].length;j++) {
        maze[i][j] = '#';
      }
    }
    maze[row][col] = 'E';
    randomizer(maze,startrow,startcol);
    maze[startrow][startcol] = 'S';
  }

  public static int randomizer(char[][]maze, int row,int col) {
    if (space(maze,row,col)) {
      return -1;
    } else if (maze[row][col] == 'E') {
      return 0;
    } else {
      maze[row][col] = ' ';
      int s = randomizer(maze, row+1,col);
      if (s > -1) {
        return s +1;
      }
      int n = randomizer(maze,row-1,col);
      if (n > -1) {
        return n+1;
      }
      int e = randomizer(maze,row,col+1);
      if (e > -1) {
        return e +1;
      }
      int w = randomizer(maze,row,col-1);
      if (w > -1) {
        return w +1;
      }
      maze[row][col] = ' ';
      return -1;
    }
  }

  public static boolean space(char[][]maze, int row, int col) {
    int ans = 0;
    if (row + 1 < maze.length-1 || maze[row+1][col] == '#'){
      ans +=1;
    }
    if (row -1 >= 1 || maze[row-1][col] == '#') {
      ans += 1;
    }
    if (col +1 < maze[0].length -1 || maze[row][col+1] == '#') {
      ans += 1;
    }
    if (col-1 >= 1 || maze[row][col-1] == '#') {
      ans += 1;
    }
    if (ans < 2) {
      return false;
    }
    return true;
  }


}
