package leetcode.sort.DivideAndConque;

public class MergeSort {
	  public int[] mergeSort(int[] array) {
	    if(array == null || array.length<2) return array;
	    int n = array.length;
	    int [] cache = new int [n];
	    sort(0, n-1, array, cache);
	    return array;
	  }
	  
	  
	  private void sort(int l, int r, int [] array, int [] cache){
	    if(l < r){
	      int mid = l + (r - l) / 2;
	      sort(l, mid, array, cache);
	      sort(mid + 1, r, array, cache);
	      merge(l, r, mid, array, cache);
	    }
	  }
	  
	  private void merge(int l, int r, int mid, int [] array, int [] cache) {
	    int lIndex = l;
	    int rIndex = mid + 1;
	    
	    for(int i = l; i <= r; i++){// cache array
	      cache[i] = array[i];
	    }
	    
	    while(lIndex <= mid && rIndex <= r){
	      if(cache[lIndex] < cache[rIndex]){
	        array[l++] = cache[lIndex++];
	      }else{
	        array[l++] = cache[rIndex++];
	      }
	    }
	    
	    while(lIndex <= mid){//copy the element left in the right side
	      array[l++] = cache[lIndex++];
	    }
	  }
}
