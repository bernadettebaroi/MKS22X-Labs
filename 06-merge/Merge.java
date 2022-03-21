import java.util.Arrays;
public class Merge {
  public static void main(String[]args){
    int[] left = {6, 3, 2, 4};
    int[] right = {9, 1, 5, 2};
    System.out.println(Arrays.toString(merge(left,right)));

  }
  public static int[] merge(int [] left, int[] right) {
    int len = left.length + right.length;
    int[] data = new int[len];
    int le = 0;
    int ri = 0;
    for (int i = 0; i < len-1; i++)  {
      if (le < left.length && ri < right.length) {
        if (left[le] < right[ri]) {
          data[i] = left[le];
          le++;
        } else if (right[ri] < left[le]) {
          data[i] = right[ri];
          ri++;
        }
      }
    }
    return data;
  }
  public static void merge(int[] destination, int [] left, int[] right) {

  }
  public static void mergesort(int[]data) {

  }
}
