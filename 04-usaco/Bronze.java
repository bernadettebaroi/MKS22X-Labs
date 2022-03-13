import java.util.*;
import java.io.*;
public class Bronze {
  private static int[][]board;
  private static int R, C, elev_rc, R_s, C_s, D_s, N, E;
  public static void main(String[] args) throws FileNotFoundException{
    String name = "makelake.1.in";
    solve(name);
    System.out.println(elev_rc);
    System.out.println(N);
    for (int i = 0; i < 4;i++) {
      for (int j = 0; j < 6;j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public static int setElevRc() {
    return 0;
  }

  public static long solve(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner input = new Scanner(text);
    int k = 0;
    int row = input.nextInt();
    int col = input.nextInt();
    board = new int[row][col];
    elev_rc = input.nextInt();
    N = input.nextInt();
    int i = 0;
    while (input.hasNextLine() && i < row) {
      for (int j = 0; j < col; j++) {
        board[i][j] = input.nextInt();
      }
      i++;
    }
    ArrayList<Integer> direc = new ArrayList<Integer>();
    int a = 0;
    while (input.hasNextInt()) {
      int h = input.nextInt();
      direc.add(a, h);
      a++;
    }

    
    return 0;
  }

  public static int cowStomp() {
    return 0;
  }
}
