import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private Queue<Integer> frontier;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    if (frontier.size() < 2) {
      return true;
    }
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    return false;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    int siz = frontier.size()/2;
    int a = 0;
    while (a < siz && frontier.size() > 0) {
      int x = frontier.poll();
      int y = frontier.poll();
      map[x][y] = ASH;
      if (y+1 < map[x].length && map[x][y+1]== TREE) {
        map[x][y+1] = FIRE;
        frontier.add(x);
        frontier.add(y+1);
      }
      if (x+1 < map.length && map[x+1][y]== TREE) {
        map[x+1][y] = FIRE;
        frontier.add(x+1);
        frontier.add(y);
      }
      if (x-1 >= 0 && map[x-1][y]== TREE) {
        map[x-1][y] = FIRE;
        frontier.add(x-1);
        frontier.add(y);
      }
      if (y-1 >= 0 && map[x][y-1]== TREE) {
        map[x][y-1] = FIRE;
        frontier.add(x);
        frontier.add(y-1);
      }
      a++;
    }
  }

  public double averageOfNRuns(double repititions, int size, double density) {
    double ans = 0.0;
    double n = repititions;
    while (n != 0) {
      BurnTrees b = new BurnTrees(size,size,density);
      while(!b.done()) {
        b.tick();
      }
      ans += b.getTicks();
      n--;
    }
    return ans/repititions;
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    frontier = new LinkedList<>();
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        frontier.add(i);
        frontier.add(0);
      }
    }
    tick();
  }



    public static void main(String[]args){
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .05;
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }

      /*
      double n = DENSITY;
      while (n <= .96) {
        if (0.5 < n && n < 0.65) {
          BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
          double average = b.averageOfNRuns(100,500,n);
          System.out.println("density of " + n + " is " + average);
          n += 0.01;
        } else {
          BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
          double average = b.averageOfNRuns(100,500,n);
          System.out.println("density of " + n + " is " + average);
          n += 0.05;
        }
      }
      */

      //BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
      //int ans = b.animate(DELAY);//animate all screens
      //System.out.println(ans);//print the final answer

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer

      //double average = b.averageOfNRuns(10,100,.6);
    }







  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
