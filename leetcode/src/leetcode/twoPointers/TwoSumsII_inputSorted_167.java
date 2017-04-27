package leetcode.twoPointers;

public class TwoSumsII_inputSorted_167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0) return new int []{};
        int l=0;
		int h=numbers.length-1;
		while(l<h){
			if(numbers[l]+numbers[h] == target) return new int [] {l+1, h+1};
			else if(numbers[l]+numbers[h]<target) l++;
			else h--;
		}
		return new int [] {};
    }
}
