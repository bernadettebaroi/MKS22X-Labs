import java.util.*;
import java.io.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
  public static void main(String[]args){
    /*
    System.out.println("11 3 - 4 + 2.5 *");
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println("should be 30.0" + "\n");
    System.out.println("10 2.0 +");
    System.out.println(eval("10 2.0 +"));
    System.out.println("should be 12.0"+ "\n");
    System.out.println("8 2 + 99 9 - * 2 + 9 -");
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println("should be 893.0" + "\n");
    System.out.println("1 2 3 4 5 + * - -");
    System.out.println(eval("1 2 3 4 5 + * - -"));
    System.out.println("should be 26.0" + "\n");
    System.out.println("25");
    System.out.println(eval("25"));
    System.out.println("should be 25.0" + "\n");
    //eval("");
    //eval("1 1 1 - * +");
    //eval("1 1 1 +");
    */
  }


  public static double eval(String s){
    if (s == "") {
      throw new IllegalArgumentException("too few operands");
    }
    Scanner input = new Scanner(s);
    Deque<Double> deque = new ArrayDeque<Double>();
    while (input.hasNext()) {
      if (input.hasNextDouble()) {
        deque.addLast(input.nextDouble());
      } else {
        String c = input.next();
        if (deque.size() < 2) {
          throw new IllegalArgumentException("too few operands");
        }
        switch(c) {
          case "+" :
           deque.addLast(deque.pollLast()+deque.pollLast());
           break;
          case "-" :
            double a = deque.pollLast();
            double b = deque.pollLast();
            deque.addLast(b-a);
            break;
          case "*":
            deque.addLast(deque.pollLast()*deque.pollLast());
            break;
          case "/":
            double d = deque.pollLast();
            double e = deque.pollLast();
            deque.addLast(e/d);
            break;
          case "%":
            double i = deque.pollLast();
            double j = deque.pollLast();
            deque.addLast(i%j);
            break;
        }
      }
    }
    if (deque.size() > 1) {
      throw new IllegalArgumentException("too many operands");
    }
    return deque.getFirst();
  }
}
