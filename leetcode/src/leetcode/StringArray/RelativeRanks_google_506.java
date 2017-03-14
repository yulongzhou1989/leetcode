package leetcode.StringArray;

import java.util.Arrays;
import java.util.Comparator;

public class RelativeRanks_google_506 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] findRelativeRanks(int[] nums) {
        //save array to 2d array to record the original position
        int [][] numArr = new int [nums.length][2];
        
        for (int i=0;i<nums.length;i++){
            numArr[i][0] = nums[i];
            numArr[i][1] = i;
        }
        
        //sort the array
        Arrays.sort(numArr, new Comparator<int []>(){
            @Override
           public int compare(int [] o1, int [] o2){
             return o2[0]-o1[0];  
           } 
        });
        
        String [] result = new String [nums.length];
        for(int i=0;i<numArr.length;i++){
            if (i==0){
                result[numArr[i][1]] = "Gold Medal";
            } else if (i==1){
                result[numArr[i][1]] = "Silver Medal";
            } else if (i==2) {
                result[numArr[i][1]] = "Bronze Medal";
            } else {
                result[numArr[i][1]] = i+1+""; 
            }
        }
        
        return result;
    }
}
