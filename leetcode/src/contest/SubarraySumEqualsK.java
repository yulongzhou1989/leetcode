package contest;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        
        int counter = 0;
        
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) {
                    counter++;
                    //break;
                }
                //if(sum>k) break;
            }
        }
        
        return counter;
    }
}
