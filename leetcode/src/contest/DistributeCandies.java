package contest;

import java.util.HashSet;

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int distributeCandies(int[] candies) {
        int diff = 0;
        int len = candies.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            if(set.add(candies[i])) diff++;
        }
        
        return diff>len/2?len/2:diff;
    }
}
