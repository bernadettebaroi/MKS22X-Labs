import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public static void main(String[]args){
    MyDeque<Integer> test =  new MyDeque<Integer>(8);
    System.out.println("size is " + test.size());
    test.addFirst(9);
    test.addFirst(8);
    test.addFirst(7);
    test.addFirst(6);
    test.addFirst(5);
    test.addFirst(4);
    test.addFirst(3);
    test.addFirst(2);
    test.addFirst(1);
    System.out.println("toString is: " + test.toString());
    System.out.println("getFirst is: " + test.getFirst());
    System.out.println("getLast is: " + test.getLast());
    //System.out.println("to String: " + test.toString());
  }

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = (10/2);
    end = (10/2);
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    if (data.length == 1) {
      start = 0;
      end = 0;
    } else {
      start = (initialCapacity/2);
      System.out.println("start is " + start);
      end = (initialCapacity/2);
      System.out.println("end is " + end);
    }
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "[";
    int i = end;
    int j = 1;
    while (j <= size) {
      if (i == -1) {
        i = data.length-1;
      }
      if (data[i] != null) {
        if (j == size -1) {
          ans += data[i];
          break;
        } else {
          ans += data[i] + ", ";
          i--;
          j++;
        }
      }
    }
    ans += "]";
    System.out.println("Start is: " + start);
    System.out.println("End is: " + end);
    return ans;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException("NullPointerException: Error Message");
    }
    if (data.length == size) {
      resize();
    }
    if (data[start] == null) {
      data[start] = element;
      if (start-1 == -1) {
        start = data.length-1;
      } else {
        start--;
      }
    }
    System.out.println(Arrays.toString(data));
    size++;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException("NullPointerException: Error Message");
    }
    if (data.length == size) {
      resize();
    }
    if (data[end] == null) {
      data[end] = element;
      if (end+1 == data.length) {
        end= 0;
      } else {
        end++;
      }
    }
    System.out.println(Arrays.toString(data));
    size++;
  }

  public E removeFirst(){
    if (data.length == 0) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    data[start+1] = null;
    start++;
    return data[start];
  }

  public E removeLast(){
    if (data.length == 0) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    data[end-1] = null;
    end--;
    return data[end];
  }

  public E getFirst(){
    if (data.length == 0) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    if (data[start] == null) {
      int temp = start+1;
      return data[temp];
    } else {
      return data[start];
    }
  }

  public E getLast(){
    if (data.length == 0) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    if (data[end] == null) {
      int temp = end -1;
      return data[temp];
    } else {
      return data[end];
    }
  }

  private void resize() {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[data.length*2+1];
    for (int i = 0; i <= start; i++) {
      d[i] = data[i];
    }
    int j = d.length-1;
    for (int i = data.length-1; i > start;i--) {
      d[j] = data[i];
      j--;
    }
    start = j;
    data = d;
  }



}
