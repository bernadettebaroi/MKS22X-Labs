import java.util.*;
import java.io.*;
public class Bronze {
  private int[][]board;
  private int R, C, elev_rc, R_s, C_s, D_s, N, E;
  public static void main(String[] args) {
    System.out.println();
  }
  public static Bronze(int row, int col) {

  }

  public static int setElevRc() {
    return 0;
  }

  public static long solve(String filename) {
    File text = new File(filename);
    Scanner input = new Scanner(text);
    int k = 0;
    ArrayList<int> samp = new ArrayList<int>();
    int row = input.nextInt()-1;
    int col = input.nextInt()-1;
    board = new[row][col];
  }

  public static int cowStomp() {
    return 0;
  }
}
