import java.util.*;
import java.io.*;
public class Silver {
  private static int[][]board;
  private static int[][]board1;
  private static int[][]board2;
  private static int N, M, T, R1, C1, R2, C2;
  public static void main(String[] args) throws FileNotFoundException{
    String name = "ctravel.1.in";
    solve(name);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M;j++) {
        System.out.print(board1[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
  public static long solve(String filename)throws FileNotFoundException{
    File text = new File(filename);
    Scanner input = new Scanner(text);
    N = input.nextInt();
    M = input.nextInt();
    T = input.nextInt();
    board = new int[N][M];
    board1 = new int[N][M];
    board2 = new int[N][M];
    int i = 0;
    while (input.hasNext() && i < N) {
      String g = input.next();
      for (int j = 0; j < M; j++) {
        if (g.charAt(j) == '*') {
          board[i][j] = -1;
          board1[i][j] = -1;
          board2[i][j] = -1;
        } else {
          board[i][j] = 0;
          board1[i][j] = 0;
          board2[i][j] = 0;
        }
      }
      i++;
    }
    R1 = input.nextInt() -1;
    C1 = input.nextInt() -1;
    R2 = input.nextInt() -1;
    C2 = input.nextInt() -1;
    go();
    return 0;
  }

  public static void go() {
    if (T == 0) {
    } else {
      board2[R1][C1] = 1;
      movements(R1,C1);
      for (int i = 0; i < N;i++) {
        for (int j = 0; j < M;j++) {
          if (board1[i][j] >= 1) {
            movements(i,j);
          }
        }
        swap(board);
      }
      T--;
      go();
    }
  }

  public static void movements(int r, int c, int[][]bor) {
    if(r+1 < N && board2[r+1][c] != -1) {
      board2[r+1][c] += 1;
    }
    if (r-1 >= 0 && board2[r-1][c] != -1) {
      board2[r-1][c] += 1;
    }
    if (c+1 < M && board2[r][c+1] != -1) {
      board2[r][c+1] += 1;
    }
    if (c-1 >= 0 && board2[r][c-1] != -1) {
      board2[r][c-1] += 1;
    }
  }

  public static void clear() {
    for (int i = 0; i < N;i++) {
      for (int j = 0; j < M;j++) {
        board1[i][j] = board[i][j];
      }
    }
  }

  public static void swap(int[][] orig, int[][] copy) {
    for (int i = 0; i < N;i++) {
      for (int j = 0; j < M;j++) {
        copy[i][j] = orig[i][j];
      }
    }
  }


}
