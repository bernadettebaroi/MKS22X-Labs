import java.util.Arrays;
public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public static void main(String[]args){
    MyDeque<Integer> test =  new MyDeque<Integer>(8);
    System.out.println(test.size());
    test.addFirst(5);
    System.out.println(test.toString());
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
      end = (initialCapacity/2);
    }
  }

  public int size(){
    int empty = 0;
    int ans = end - start;
    for (int i = start; i <= end; i ++) {
      if (data[i] != null) {
        empty += 1;
      }
    }
    return ans - empty;
  }

  public String toString(){
    String ans = "[";
    int i = start;
    while (i != end) {
      if (i < data.length -1 ) {
        ans += data[i] + ", ";
        i++;
      } else if (i == data.length -1 ) {
        ans += data[i] + ", ";
        i = 0;
      }
    }
    if (i == end) {
      ans += data[i];
    }
    ans += "]";
    return ans;
  }

  public void addFirst(E element){
    if (start < data.length-1) {
      data[start] = element;
      start++;
    } else if (start == data.length -1 && data[0] == null) {
      data[start] = element;
      start = 0;
    }
    size++;
  }

  public void addLast(E element){
    if (end < data.length -1) {
      data[end] = element;
      end++;
    } else if (end == data.length -1) {
      data[end] = element;
      end = 0;
    }
    size++;
  }

  public E removeFirst(){
    data[start] = null;
    return data[start];
  }

  public E removeLast(){
    data[end] = null;
    return data[end];
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];

  }

  private void resize() {
    data = Arrays.copyOf(data,(data.length*2) +1);
  }



}
