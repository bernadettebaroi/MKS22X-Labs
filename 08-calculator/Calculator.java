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
    System.out.println(eval("11 3 - 4 + 2.5 *"));
  }

  public static double eval(String s){
    Scanner input = new Scanner(s);
    Deque<Double> deque = new LinkedList<Double>();
    while (input.hasNext()) {
      int temp1 = input.nextInt();
      Double temp = temp1;
      deque.addLast(temp);
    }
    System.out.println(deque);
    return deque.getFirst();
  }

}
