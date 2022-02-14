public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(5);
    if (test.addQueen(0,0)) {
      System.out.println("true");
    }
    if (test.addQueen(1,0)) {
      System.out.println("false");
    }
  }
}
