package leetcode.StringArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall_554 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		
		//System.out.println(leastBricks());
	}

	public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer>l:wall){
            int start = 0;
            for(int i=0;i<l.size()-1;i++){
                start += l.get(i);
                if(!map.containsKey(start)) map.put(start,0);
                int cur = map.get(start);
                cur = cur+1;
                map.put(start, cur);
                max = Math.max(cur, max);
            }
        }
        
        return wall.size()-max;
    }
}
