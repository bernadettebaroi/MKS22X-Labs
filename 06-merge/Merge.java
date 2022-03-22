import java.util.Arrays;
public class Merge {
  public static void main(String[]args){
    int[] left = {1, 2, 3, 4};
    int[] right = {3, 4, 5, 6, 9};
    System.out.println(Arrays.toString(merge(left,right)));

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
        } else if (right[ri] > left[le]) {
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
    //********************
    //COMPLETE THIS METHOD
    //********************
    //if more than 1 element{
      //left = copy half of data
      //right = copy other half of data
      //sort each half and merge them together
    //}
    return new int[1]; //so this compiles
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
