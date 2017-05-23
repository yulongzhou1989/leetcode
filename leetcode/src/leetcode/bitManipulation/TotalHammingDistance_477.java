package leetcode.bitManipulation;

public class TotalHammingDistance_477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int totalHammingDistance(int[] nums) {
		
		int res = 0;
		//count each bit
		for(int i=0;i<32;i++){
			int bitCount = 0;
			for(int j=0;j<nums.length;j++){
				bitCount += (nums[j]>>i) &1;
			}
			res += bitCount*(nums.length-bitCount);
		}
		
		return res;
	}
	
	
	//On*n
    public int totalHammingDistance1(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                res+=getHammingDis(nums[i], nums[j]);
            }
        }
        
        return res;
    }
    
    
    public int getHammingDis(int a, int b){
        int xor = a^b;
        int count = 0;
        while(xor!=0){
            xor = xor&(xor-1);
            count++;
        }
        
        return count;
    }
}
