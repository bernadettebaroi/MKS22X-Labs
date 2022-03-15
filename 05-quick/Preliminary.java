public class Preliminary {
  public static void main(String[]args){
    int[] data = {997,998,999,4,3,2,1,0};
    partition(data,3,7);

  }
  /*Modify the array as per directions above.
  *@return the index of the final position of the pivot element.
  */
  public static int partition ( int [] data, int start, int end){
    int pivotIndex = (int)(Math.random() * end);
    int P = data[pivotIndex];
    int len = end-start+1;
    int[] scartch = new int[len];
    int i = 0;
    int j = end-start;
    for (int a = start; a <= end; a++) {
      if (a != pivotIndex && i!=j) {
        if (data[a] < P) {
          scartch[i] = data[a];
          i++;
        } else if (data[a] > P) {
          scartch[j] = data[a];
          j--;
        }
      }
      if (i==j) {
        scartch[i] = P;
        break;
      }
    }
    System.out.println(pivotIndex);
    for (int e = 0; e < data.length; e++) {
      System.out.print(data[e] + " ");
    }
    System.out.println();

    for(int f = 0; f < len;f++) {
      data[start] = scartch[f];
      start++;
    }
    for (int d = 0; d < len; d++) {
      System.out.print(scartch[d] + " ");
    }
    System.out.println();

    for (int e = 0; e < data.length; e++) {
      System.out.print(data[e] + " ");
    }
    System.out.println();

    return 0;
  }

}
