public class Driver {
  public static void main(String[] args) {
    //countSolutions test
    QueenBoard test0 = new QueenBoard(1);
    System.out.println(test0.countSolutions());
    QueenBoard test1 = new QueenBoard(2);
    System.out.println(test1.countSolutions());
    QueenBoard test2 = new QueenBoard(3);
    System.out.println(test2.countSolutions());
    QueenBoard test3 = new QueenBoard(4);
    System.out.println(test3.countSolutions());
    QueenBoard test4 = new QueenBoard(5);
    System.out.println(test4.countSolutions());
    QueenBoard test5 = new QueenBoard(6);
    System.out.println(test5.countSolutions());
    QueenBoard test6 = new QueenBoard(7);
    System.out.println(test6.countSolutions());
    QueenBoard test7 = new QueenBoard(8);
    System.out.println(test7.countSolutions());

    /* //test for throwing exception
    QueenBoard test8 = new QueenBoard(4);
    test8.solve();
    System.out.println(test8);
    test8.solve();*/
  }
}
