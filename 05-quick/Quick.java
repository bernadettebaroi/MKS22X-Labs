import java.util.Arrays;
public class Quick {
  public static void main(String[]args){
    int[] data = new int[1000000];
    for (int i = 0 ; i < 1000000;i++) {
      int k = (int)(Math.random() * 100);
      data[i] = k;
    }
    quicksort(data,0,999999);
  }


  public static int partition ( int [] data, int start, int end){
    if (start == end) {
      return start;
    }
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


  public static int quickselect(int[]data, int k) {
    int end = data.length-1;
    int start = 0;
    int a = 0;
    while (a >= 0) {
      int re = partition(data, start, end);
      if (k != re) {
        if (re < k) {
          start = re;
        }
        if (re > k) {
          end = re;
        }
        a++;
      } else {
        break;
      }
    }
    return data[k];
  }


  public static void quicksort(int[]data){
    quicksort(data,0,data.length-1);
  }


  public static void quicksort(int[]data,int lo,int hi){
    if (hi <= lo) {
      return;
    } else {
      int k = partition(data,lo,hi);
      if (k-1 >= lo || k+1<= hi) {
        quicksort(data,k+1,hi);
        quicksort(data,lo,k-1);
      }
    }
  }

}
