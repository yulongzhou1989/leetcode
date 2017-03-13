package leetcode.search;

import java.util.Arrays;

public class Heaters_google_475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findRadius(int[] houses, int[] heaters) {
        //sort heaters array for binary search
        Arrays.sort(heaters);
        int res = 0;
        //iterate to find the min distance between each heaters
        for(int i=0;i<houses.length;i++){
            int index = Arrays.binarySearch(heaters, houses[i]);
            // binarySearch returns the index or the insertedPoint(-insertedpoint-1)
            if (index<0) index = -(index+1);
            int diff1 = index>0?Math.abs(houses[i]-heaters[index-1]):Integer.MAX_VALUE;
            int diff2 = index<heaters.length?Math.abs(houses[i]-heaters[index]):Integer.MAX_VALUE;
            
            res = Math.max(res, Math.min(diff1, diff2));
        }
        
        return res;
    }
	
	public int binarySearch(int val, int [] arr){
		int low = 0;
		int high = arr.length-1;
		
		while (low<=high){
			int middle = (low+high)/2;
			if (arr[middle]==val){
				return middle;
			}
			if (arr[middle]<val){
				low = middle+1;
			}
			if (arr[middle]>val){
				high = middle-1;
			}
		}
		
		return -high;
	}
	
}
