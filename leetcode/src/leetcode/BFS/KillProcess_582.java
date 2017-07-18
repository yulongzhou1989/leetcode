package leetcode.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcess_582 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<pid.size();i++){
            int key = ppid.get(i);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(pid.get(i));
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int p = queue.poll();
            res.add(p);
            if(map.containsKey(p)){
                for(Integer i:map.get(p)){
                    queue.offer(i);
                }
            }
        }
        
        return res;
    }
	
}
