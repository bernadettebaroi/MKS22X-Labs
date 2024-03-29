import java.util.Arrays;
public class Merge {
  public static void main(String[]args){
    int[] data = new int[1000000];
    int[] data1 = new int[1000000];
    for (int i = 0 ; i < 1000000;i++) {
      int k = (int)(Math.random() * 1000);
      data[i] = k;
      data1[i] = k;
    }
    mergesort(data);
    Arrays.sort(data1);
    boolean ans = false;
    for (int i = 0; i < data.length;i++) {
      if (data[i] == data1[i]) {
        ans = true;
      } else {
        ans = false;
      }
    }
    System.out.println("" + ans);
  }


  /*merge takes two sorted arrays and returns a new array that combines all
  *elements of both arrays in asorted order.
  *@left a sorted array (this is a precondition)
  *@right a sorted array (this is a precondition)
  *@return a sorted array that contains all elements of left and right
  */
  public static int[] merge(int [] left, int[] right) {
    int len = left.length + right.length;
    int[] data = new int[len];
    int le = 0;
    int ri = 0;
    for (int i = 0; i < len; i++)  {
      if (le < left.length && ri < right.length) {
        if (left[le] < right[ri]) {
          data[i] = left[le];
          le++;
        } else if (left[le] > right[ri]) {
          data[i] = right[ri];
          ri++;
        } else if (right[ri] == left[le]) {
          data[i] = right[ri];
          ri++;
        }
      } else if (ri < right.length){
        data[i] = right[ri];
        ri++;
      } else if (le < left.length) {
        data[i] = left[le];
        le++;
      }
    }
    return data;
  }


  /*mergesortH is the actual mergesort method.
  *@data the array to be sorted
  *@return a new array that is the sorted version of data.
  */
  public static int[] mergesortH(int [] data){
    if (data.length > 1) {
      int half = data.length / 2;
      int[] left = new int[half];
      int[] right = new int[data.length-half];
      for (int i = 0; i < half; i++) {
        left[i] = data[i];
      }
      for (int i = half; i < data.length; i++) {
        right[i-half] = data[i];
      }
      int [] tempLeft  = mergesortH(left);
      int [] tempRight  = mergesortH(right);
      int[] temp = merge(tempLeft,tempRight);
      return temp;
    } else {
      int[] temp = new int[1];
      temp[0] = data[0];
      return temp;
    }
  }


  /*mergesort uses the recursive mergesortH method to create a sorted
  *version of the array. It then copies the data back into the original
  *array. (This is for compatibility with prior sort testers)
  *@param data the array to be sorted, this will be modified by the method
  */
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }



}
