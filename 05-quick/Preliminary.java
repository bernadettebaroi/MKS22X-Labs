import java.util.Arrays;
public class Preliminary {
  public static void main(String[]args){
    int[] ary = {2, 10, 15, 23, 0, 5};
    System.out.println("beg" + Arrays.toString(ary));
    System.out.println(quickselect(ary, 2));
    System.out.println("should be 5");
    Arrays.sort(ary);
    System.out.println(Arrays.toString(ary));
  }


  public static int partition ( int [] data, int start, int end){
    int pivotIndex = (int)(Math.random() * (end-start +1) + start);
    System.out.println("pivot " + pivotIndex);
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
    System.out.println("sorted data: " + Arrays.toString(data));
    System.out.println("ans" + ans);
    return ans;
  }

  public static int quickselect(int[]data, int k) {
    int beg = 0;
    int end = 0;
    int a = 0 ;
    int re = partition(data, 0, data.length -1);
    if (re == 0 || re < k) {
      end = data.length -1;
    } else {
      end = re;
    }
    while (a >= 0) {
      if (re == k) {
        break;
      } else if (re < k && end != beg) {
        beg++;
        int l = end-1;
        System.out.println("star at " + beg + " end at " + l);
        beg = partition(data,beg,end);
        re = beg;
      } else if (re > k && end != beg) {
        int m = end -1;
        System.out.println("star at " + beg + " end at " + m);
        end--;
        end = partition(data, beg, end);
        re = end;
      }
      a++;
    }
    return data[k];
  }


  public static void quicksort(int[]data) {
  }

}
