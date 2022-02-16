public class Driver {
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(6);
    System.out.println(test.addQueen(2,2));
    System.out.println(test.toString());
    test.removeQueen(2,2);
    System.out.println(test.toString());
  }
}
