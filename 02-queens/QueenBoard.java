public class QueenBoard {
  private int[][]board;

  /** initialize a square 2d array of the specified size. All values should be 0 */
  public QueenBoard(int size){
    board = new int [size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String ans = "";
    for (int i = 0; i < board.length;i++) {
      for (int j = 0; j < board[i].length;j++) {
        if (board[i][j] == -1) {
          ans += "Q ";
        } else {
          //ans += "_"
          ans += board[i][j] + " ";
        }
      }
      ans += "\n";
    }
    return ans;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  public boolean addQueen(int r, int c){
    if (board[r][c] == 0) {
      for (int x = 0; x < board.length; x++) {
          if (r+x < board.length && x < board.length) {
            board[r+x][c] += 1;
          }
          if (r+x < board.length && c+x < board[r+x].length) {
            board[r+x][c+x] += 1;
          }
          if (r+x < board.length && c-x >= 0) {
            board[r+x][c-x] += 1;
          }
          board[r][c] = -1;
      }
      return true;
    } else {
      return false;
    }
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  public void removeQueen(int r, int c){
    for (int x = 0; x < board.length; x++) {
      if (r+x < board.length) {
        board[r+x][c] -= 1;
      }
      if (r+x < board.length && c+x < board.length ) {
        board[r+x][c+x] -= 1;
      }
      if (r+x < board.length && c-x >= 0) {
        board[r+x][c-x] -= 1;
      }
      board[r][c] = 0;
    }
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalArgumentException ("Error Message: the board starts with non-zero value");
        }
      }
    }
    return solve(0);
  }

  public boolean solve(int x){
    if (x >= board.length) {
      return true;
    } else {
      for (int i = 0; i < board.length; i++) {
        if (addQueen(x,i)) {
          if(solve(x+1)) {
            return true;
          }
          removeQueen(x,i);
        }
      }
      return false;
    }
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions(){
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalArgumentException ("Error Message: the board starts with non-zero value");
        }
      }
    }
    return countSolutions(0);
  }

  public int countSolutions(int start){
    if (start == board.length) {
      return 1;
    } else {
      int c = 0;
      for (int j = 0; j < board.length;j++) {
        if(addQueen(start,j)) {
          c+= countSolutions(start+1);
          removeQueen(start,j);
        }
      }
      return c;
    }
  }






}
