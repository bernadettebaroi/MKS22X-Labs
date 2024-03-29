public class Recursion {
  public static void main(String[] args) {
    /*printAllWords(3);
    char[] list = {};
    printNoDoubleLetterWords(3,list);
    String ans = "";
    System.out.println(reverse(ans));
    System.out.println(sqrt(100));
    System.out.println(sqrt(4));
    System.out.println(fibIter(0, 1, 0));
    System.out.println(fibIter(1, 1, 0));
    System.out.println(fibIter(2, 1, 0));
    System.out.println(fibIter(3, 1, 0));
    System.out.println(countNoDoubleLetterWords(3,""));*/
  }
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length : either how many more letters or the total length depending on implementation
  *@param word   : the partial word so far.
  */
  public static void printAllWords(int length,String word){
    if (length > 0) {
      for (char c = 'a'; c <= 'z'; c++) {
        printAllWords(length-1,word+c);
      }
    } else {
      System.out.println(word);
    }
  }


  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using,
  *@precondition: letters contains at least 2 characters, and has no duplicates.
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (length == 0) {
      System.out.println("");
    }
    if (length > 0) {
      for (int i = 0; i < letters.length;i++) {
        char c = letters[i];
        if (word.length() == 0 || c != word.charAt(word.length()-1)) {
          printNoDoubleLetterWords(length-1,word+c,letters);
        }
      }
    } else {
      System.out.print(word);
    }
  }
  /*
  *@param s any string
  *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
  */
  public static String reverse(String s){
    if (s.length() == 0) {
      return "";
    }
    if (s.length() == 1) {
      return s;
    } else {
      return s.charAt(s.length()-1) + reverse(s.substring(0,s.length()-1));
    }
  }

  /*
  *@param n any non-negative value you want to take the sqrt of
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n){
    return sqrt(n,1);
  }

  public static double sqrt(double n, double guess){
    if ( 0.001 <= Math.abs((guess*guess - n) / n * 100)) {
      guess = (n/guess + guess) / 2;
      return sqrt(n,guess);
    } else {
      return guess;
    }
  }

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z.
  *Repetition allowed except when letters are adjacent.
  */
  public static long countNoDoubleLetterWords(int length,String word){
    //Hint: not a wrapper method, but you must call it starting with "" as your word.
    if (length == 0) {
      return 1;
    }
    long sum = 0;
    if (length > 0) {
      for (char i = 'a'; i <= 'z';i++) {
        if (word.length() == 0 || i != word.charAt(word.length()-1)) {
          sum += countNoDoubleLetterWords(length-1,word+i);
        }
      }
    }
    return sum;
  }


  /*
  *@param n any non-negative value
  *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
  */
  public static int fibIter(int n, int f1, int f2){
    //DO NOT call fibIter more than once
    if (n > 0) {
      return fibIter(n-1, f2, f1+f2);
    } else {
      return f2;
    }
  }

}
