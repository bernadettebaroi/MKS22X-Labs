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
    System.out.println("11 3 - 4 + 2.5 *");
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println("should be 30.0" + "\n");
    System.out.println("10 2.0 +");
    System.out.println(eval("10 2.0 +"));
    System.out.println("should be 12.0"+ "\n");
    System.out.println("8 2 + 99 9 - * 2 + 9 -");
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println("should be 893.0");
  }


  public static double eval(String s){
    Scanner input = new Scanner(s);
    Deque<Double> deque = new ArrayDeque<Double>();
    String temp = "";
    while (input.hasNext()) {
      if (input.hasNextDouble()) {
        deque.addLast(input.nextDouble());
      } else {
        String c = input.next();
        if (deque.size() < 2) {
          break;
        }
        switch(c) {
          case "+" :
           System.out.println(deque.addFirst(deque.pollFirst()+deque.pollFirst()));
           break;
          case "-" :
            double a = deque.pollFirst();
            double b = deque.pollFirst();
            System.out.println(deque.addFirst(b-a));
            break;
          case "*":
            System.out.println(deque.addFirst(deque.pollFirst()*deque.pollFirst()));
            break;
          case "/":
            double d = deque.pollFirst();
            double e = deque.pollFirst();
            System.out.println(deque.addFirst(e/d));
            break;
        }
      }
    }
    System.out.println(temp);
    System.out.println(deque);
    return deque.getFirst();
  }

}
