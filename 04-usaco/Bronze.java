import java.util.*;
import java.io.*;
public class Bronze {
  private int[][]maze;
  private int R, C, elev_rc, R_s, C_s, D_s, N, E;

  public static Bronze(int row, int col) {
    maze[][] = maze[row][col];
    R = row;
    C = col;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col;j++) {
        int z = Math.random() * 40;
        maze[row][col] = z;
      }
    }
    setElevRc(maze);
  }
  public static setElevRc() {

  }

  public static long solve(String filename) {

  }
  public Bronze() {

  }

  public static cowStomp() {

  }
}
