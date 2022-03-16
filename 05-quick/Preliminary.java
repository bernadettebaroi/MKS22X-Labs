public class Preliminary {
  public static void main(String[]args){

  }


  public static int partition ( int [] data, int start, int end){
    int pivotIndex = (int)(Math.random() * (end-start +1) + start);
    int P = data[pivotIndex];
    int len = end-start+1;
    int[] scartch = new int[len];
    int i = 0;
    int j = end-start;
    int tracker = 0;
    int ans = 0;
    for (int a = start; a <= end; a++) {
      if (a != pivotIndex && i!=j) {
        if (data[a] == P) {
          if (tracker % 2 == 1) {
            scartch[i] = data[a];
            i++;
          } else {
            scartch[j] = data[a];
            j--;
          }
          tracker++;
        } else if (data[a] < P) {
          scartch[i] = data[a];
          i++;
        } else if (data[a] > P) {
          scartch[j] = data[a];
          j--;
        }
      }
      if (i==j) {
        scartch[i] = P;
        ans += i;
        break;
      }
    }
    ans += start;
    for(int f = 0; f < len;f++) {
      data[start] = scartch[f];
      start++;
    }
    return ans;
  }


  public static int quickselect(int []data, int k){
    return 0;
  }

}
