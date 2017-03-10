package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int num: nums){
            if (!map.containsKey(num)){
                map.put(num, true);
            }else {
                return true;
            }
        }
        
        return false;
    }
}
