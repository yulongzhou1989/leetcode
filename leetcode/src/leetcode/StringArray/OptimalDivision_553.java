package leetcode.StringArray;

public class OptimalDivision_553 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String optimalDivision(int[] nums) {
		if(nums.length==0) return "";
        //a/b/c<a/(b/c), to get a/T max, T should be minimum
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
		for(int i=1;i<nums.length;i++){
			if(i==1 && i!=nums.length-1) sb.append("/(").append(nums[i]);
			else if (i!=1 && i==nums.length-1)sb.append("/").append(nums[i]).append(")");
			else sb.append("/").append(nums[i]);
		}
		
		return sb.toString();
    }
}
