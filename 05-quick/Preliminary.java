import java.util.Arrays;
public class Preliminary {
  public static void main(String[]args){
    int[] ary = {2, 10, 15, 23, 0, 5};
    System.out.println("startlist " + Arrays.toString(ary));
    quicksort(ary, 0,5);
    System.out.println("result of quick sort " + Arrays.toString(ary));
    Arrays.sort(ary);
    System.out.println("should be " + Arrays.toString(ary));
  }


  public static int partition ( int [] data, int start, int end){
    int pivotIndex = (int)(Math.random() * (end-start +1) + start);
    System.out.print(pivotIndex + " " + "\n");
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
    System.out.println("sort after call " + Arrays.toString(data));
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
    int k = partition(data,lo,hi);
    if (lo == hi || k == 0 || k == data.length -1) {
      return;
    } else {
      if (k > 0 && k < data.length-1) {
        hi = k -1;
        quicksort(data,0,hi);
        lo = k+1;
        quicksort(data,lo,data.length-1);
      }
      return;
    }
  }

}
