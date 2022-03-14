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
    int k = 0;
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
    int a = 0;
    for (int g = 0; g < R; g++) {
      for (int h = 0; h < C;h++) {
        System.out.print(board[g][h] + " ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
    while (input.hasNextInt()) {
      R_s = input.nextInt();
      C_s = input.nextInt();
      D_s = input.nextInt();
      cowStomp(R_s,C_s,D_s);
      a++;
    }
    return 0;
  }

  public static void reading(String filename) throws FileNotFoundException {
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
