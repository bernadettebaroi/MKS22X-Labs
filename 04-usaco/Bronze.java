import java.util.*;
import java.io.*;
public class Bronze {
  private static int[][]board;
  private static int R, C, elev_rc, R_s, C_s, D_s, N, E;

  public static void main(String[] args) throws FileNotFoundException{
    String name = "makelake.1.in";
    solve(name);
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C;j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public static long solve(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner input = new Scanner(text);
    R = input.nextInt();
    C = input.nextInt();
    E = input.nextInt();
    N = input.nextInt();
    board = new int[R][C];
    int i = 0;
    while (input.hasNextLine() && i < R) {
      for (int j = 0; j < C; j++) {
        board[i][j] = input.nextInt();
      }
      i++;
    }
    while (input.hasNextLine() && N > 0) {
      R_s = input.nextInt();
      C_s = input.nextInt();
      D_s = input.nextInt();
      cowStomp(R_s,C_s,D_s);
      N--;
    }
    return 0;
  }

  public static void outpu() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++ ) {
        if (E - board[i][j] < 0) {
          board[i][j] = 0;
        } else {
          board[i][j] = E - board[i][j];
        }
      }
    }
  }

  public static void cowStomp(int r, int c, int inch) {
    int largest = board[r][c];
    for (int i = r-1; i < r+2; i++) {
      for (int j = c-1; j < c+2; j++ ) {
        if (largest <= board[i][j]) {
          largest = board[i][j];
        }
      }
    }
    for (int i = r-1; i < r+2; i++) {
      for (int j = c-1; j < c+2; j++ ) {
        if (largest <= board[i][j]) {
          board[i][j]-=inch;
          int b = board[i][j];
          for (int g = r-1; g < r+2; g++) {
            for (int h = c-1; h < c+2; h++ ) {
              if (board[g][h] >= b) {
                board[g][h] = b;
              }
            }
          }
        }
      }
    }
  }


}
