import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public static void main(String[]args){
    MyDeque<Integer> test =  new MyDeque<Integer>();
    Deque<Integer> real = new LinkedList<Integer>();
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
    if (initialCapacity == 0) {
      initialCapacity = 2;
    }
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    if (data.length == 1) {
      start = 0;
      end = 0;
    } else {
      start = (initialCapacity/2);
      end = (initialCapacity/2);
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
        if (j == size) {
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
    return ans;
  }


  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException("NullPointerException: Error Message");
    }
    if (data.length== size) {
      resize();
    }
    if (end == data.length-1) {
      end = 0;
    } else {
      end++;
    }
    if (data[end] == null) {
      data[end] = element;
    }
    size++;
  }


  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException("NullPointerException: Error Message");
    }
    if (data.length == size) {
      resize();
    }
    if (data[start] == null) {
      data[start] = element;
    }
    if (start==0) {
      start = data.length-1;
    } else {
      start--;
    }
    size++;
  }


  public E removeFirst(){
    if (data.length == 0) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    E ans = data[end];
    data[end] = null;
    if (end == 0) {
      end = data.length-1;
    } else {
      end--;
    }
    size--;
    return ans;
  }

  public E removeLast(){
    if (data.length == 0) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    if (start==data.length-1) {
      start = 0;
    } else {
      start++;
    }
    E ans = data[start];
    data[start] = null;
    size--;
    return ans;
  }

  public E getFirst(){
    if (data[end] == null) {
      throw new NoSuchElementException("NoSuchElementException: Error Message");
    }
    return data[end];
  }

  public E getLast(){
    if (start == data.length-1) {
      if (data[0] == null) {
        throw new NoSuchElementException("NoSuchElementException: Error Message");
      }
      return data[0];
    } else {
      if (data[start+1] == null) {
        throw new NoSuchElementException("NoSuchElementException: Error Message");
      }
      return data[start+1];
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
    data = d;
    start = j;
  }






}
