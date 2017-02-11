package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenece_60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(9,24));
	}

	public static String getPermutation1(int n, int k) {
		int [] nums = {1,2,3,4,5,6,7,8,9}; 
        List<List<Integer>> l = new ArrayList<List<Integer>> ();
        backwardGetPermutation(l, new ArrayList<Integer>(), n, k,  nums);
        //System.out.println(l);
        StringBuilder sb = new StringBuilder();
        for(Integer i:l.get(k-1)){
        	sb.append(i);
        }
        return sb.toString();
    }
	
	public static void backwardGetPermutation(List<List<Integer>> l, List<Integer> tempList, int n, int k, int [] nums){
		if (n == tempList.size()){
			l.add(new ArrayList<Integer> (tempList));
		}
		
		for (int i=0;i<n; i++){
			if (tempList.contains(nums[i]) || l.size()>k) continue;
			tempList.add(nums[i]);
			backwardGetPermutation(l, tempList, n, k, nums);
			tempList.remove(tempList.size()-1);
		}
	}
	
	
	public static String getPermutation (int n, int k){
		List<Integer> numbers = new ArrayList<> ();
		int [] factorial = new int [n+1];
		StringBuilder sb = new StringBuilder();
		
		//create array of factorial lookup
		int sum = 1;
		factorial[0] = 1;
		for (int i=1;i<=n;i++){
			sum*=i;
			factorial[i] = sum;
		}
		
		for(int i=1;i<=n; i++){
			numbers.add(i);
		}
		
		k--;
		
		for (int i=1; i<=n; i++){
			int index = k/factorial[n-i];
			sb.append(String.valueOf(numbers.get(index)));
			numbers.remove(index);
			k-=index*factorial[n-i];
		}
		
		return String.valueOf(sb);
	}
}
