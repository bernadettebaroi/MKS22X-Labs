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
        System.out.print(board[i][j] + " ");
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
    board[R1][C1] = 1;
    movements(R1,C1);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M;j++) {
        if (board2[i][j] >= 1 && T != 0) {
          movements(i,j);
        }
      }
    }
    int a = board[R2][C2];
    int b = board1[R2][C2];
    int c = board2[R2][C2];
    System.out.println(a);
    System.out.println(b);
    System.out.println(c + "\n");
  }

  public static void movements(int r, int c) {
    T--;
    if(r+1 < N && board1[r+1][c] != -1) {
      board2[r+1][c] += 1;
    }
    if (r-1 >= 0 && board1[r-1][c] != -1) {
      board2[r-1][c] += 1;
    }
    if (c+1 < M && board1[r][c+1] != -1) {
      board2[r][c+1] += 1;
    }
    if (c-1 >= 0 && board1[r][c-1] != -1) {
      board2[r][c-1] += 1;
    }
    swap();
  }

  public static void swap() {
    for (int i = 0; i < N;i++) {
      for (int j = 0; j < M;j++) {
        board1[i][j] = board2[i][j];
      }
    }
    for (int a = 0; a < N;a++) {
      for (int b = 0; b < M;b++) {
        board[a][b] = board2[a][b];
      }
    }
  }

}
