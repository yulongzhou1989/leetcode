package leetcode.sort.DivideAndConque;

public class MergeSort {
	public int[] mergeSort(int[] array) {
	  if(array == null || array.length<2) return array;
	  int n = array.length;
	  sort(0, n-1, array);
	  return array;
	}
	  
	  
	private void sort(int l, int r, int [] array){
	  if(l<r){//split the array into 2 parts
	    int m = l + (r - l) / 2;
	    sort(l, m, array);
	    sort(m+1, r, array);
	    merge(array, l, m, r);
	  }
	}
  
	private void merge(int [] array, int l, int m, int r){
	    //cal the length of each array
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int [] cache1 = new int [n1];
		int [] cache2 = new int [n2];
		
		//copy the previous value into cache
		for(int i=0;i<n1;i++){
		  cache1[i] = array[i+l];
		}
		
		for(int j=0;j<n2;j++){
		  cache2[j] = array[m+j+1];
		}
	
		//merge two array
	    int i = 0, j = 0, k = l;
	    while(i < n1 && j < n2){
	      if(cache1[i] <= cache2[j]){
	        array[k++] = cache1[i++];
	      }else{
	        array[k++] = cache2[j++];
	      }
	    }
	    
	    while(i<n1){
	      array[k++] = cache1[i++];
	    }
	    
	    while(j<n2){
	      array[k++] = cache2[j++];
	    }
	}
}
