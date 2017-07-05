package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DesignLogStorageSystem_635 {

	public class LogSystem {

	    List<String []> list;
		
		HashMap<String, Integer> index = new HashMap<>();
		
		private void initialIndex(){
			index.put("Year", 4);
			index.put("Month", 7);
			index.put("Day", 10);
			index.put("Hour", 13);
			index.put("Minute", 16);
			index.put("Second", 19);
		}
		
	    public LogSystem() {
	        initialIndex();
			list = new ArrayList<>();
	    }
	    
	    public void put(int id, String timestamp) {
	        list.add(new String [] {Integer.toString(id), timestamp});
	    }
	    
	    public List<Integer> retrieve(String s, String e, String gra) {
			List<Integer> res = new ArrayList<>();
			if(!index.containsKey(gra)) return res;
			int idx = index.get(gra);
			for(String [] sArr:list){
				if(sArr[1].substring(0, idx).compareTo(s.substring(0, idx))>=0 
				&& sArr[1].substring(0, idx).compareTo(e.substring(0, idx))<=0){
					res.add(Integer.valueOf(sArr[0]));
				}
			}
			
			return res;
	    }
	}

	/**
	 * Your LogSystem object will be instantiated and called as such:
	 * LogSystem obj = new LogSystem();
	 * obj.put(id,timestamp);
	 * List<Integer> param_2 = obj.retrieve(s,e,gra);
	 */
}
