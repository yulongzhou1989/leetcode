package leetcode.sort.DivideAndConque;

public class QuickSort {
  public int[] quickSort(int[] array) {
    if(array == null || array.length == 0) return array;
    int n = array.length;
    quickSort(0, n-1, array);
    return array;
  }
  
  private void quickSort (int s, int e, int [] array){
    if(s < e){
      int pi = partition(s, e, array);//get the pivort position
      quickSort(s, pi, array);
      quickSort(pi + 1, e, array);
    }
  }
  
  private int partition(int s, int e, int [] array){
    int pi = getPivort(s, e);
    swap (pi, e, array); // put the pivort to the end
    int left = s;
    int right = e - 1;
    
    while (left<=right){
      if(array[left] < array[e]){
        left++;
      }
      else if(array[right] >= array[e]){
        right--;
      }else{
        swap(left++, right--, array);
      }
    }
    swap (left, e, array);//put the pivort to the right place
    
    return left;
  }
  
  private void swap (int a, int b, int [] array){
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
  
  private int getPivort(int s, int e){
    return s + (int)(Math.random() * (e - s + 1));
  }
}
