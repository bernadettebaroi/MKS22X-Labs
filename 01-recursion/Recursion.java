public class Recursion {
  public static void main(String[] args) {
    printAllWords(3);
    char[] list = {'a','b','c'};
    printNoDoubleLetterWords(3,list);
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
      for (char c = 'a'; c <= 'e'; c++) {
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
      if (length > 0) {
        for (int i = 0; i < letters.length;i++) {
          char c = letters[i];
          if (c == charAt()) {
            printNoDoubleLetterWords(length,word,letters);
          } else {
            printNoDoubleLetterWords(length-1,word+c,letters);
          }
        }
      } else {
        System.out.println(word);
      }
  }

}
