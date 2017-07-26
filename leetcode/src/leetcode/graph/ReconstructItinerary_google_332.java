package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary_google_332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [][] tickets = new String [][] {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		String [][] tickets = new String [][] {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//System.out.println(String.valueOf(findItinerary(tickets)));
	}
	
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<>();
		if(tickets==null || tickets.length==0 || tickets[0].length==0) return res;
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		for(String [] t:tickets){//initial map
			String from = t[0];
			String to = t[1];
			if(!map.containsKey(from)){
				map.put(from, new PriorityQueue<>());
			}
			map.get(from).offer(to);
		}
		
		dfs(map, res, "JFK");
		
		return res;
    }
	
	private void dfs(HashMap<String, PriorityQueue<String>> map, List<String> res, String from){
		if(map.containsKey(from)){
            PriorityQueue<String> pq = map.get(from);
            while(pq!=null && !pq.isEmpty()){
                dfs(map, res, pq.poll());
            }
		}
		res.add(0, from);
	}
	
//	public static List<String> findItinerary(String[][] tickets) {
//		List<String> res = new ArrayList<>();
//		if(tickets==null || tickets.length==0) return res;
//        //save the map
//		Map<String, List<String>> map = new HashMap<>();
//		for(String [] ticket:tickets){
//			if(!map.containsKey(ticket[0])) map.put(ticket[0], new ArrayList<>());
//			map.get(ticket[0]).add(ticket[1]);
//		}
//		//dfs search
//		List<String> temp = new ArrayList<>();
//		temp.add("JFK");
//		dfs(res, map, temp, new HashSet<String>(), "JFK", "");
//		
//		return res;
//    }
	
//	private static void dfs(List<String> res, Map<String, List<String>> map, List<String> temp, HashSet<String> visited, String start, String pre){
//		visited.add(pre+"->"+start);
//		//if smaller lexical 
//		if(compare(temp, res)){
//			res.clear();
//			res.addAll(temp); 
//		}
//		if (!map.containsKey(start)) return;
//		for(String loc:map.get(start)){
//			if(!visited.contains(start+"->"+loc)) {
//				temp.add(loc);
//				dfs(res, map, temp, visited, loc, start);
//				temp.remove(temp.size()-1);
//			}
//		}
//	}
//	
//	private static boolean compare(List<String> temp, List<String> res){
//		if(res.size()==0) return true;
//		int i=0;
//		while(i<temp.size()&&i<res.size()){
//			if(temp.get(i).compareTo(res.get(i))>0) return false;
//			else if (temp.get(i).compareTo(res.get(i))<0) return true;
//			i++;
//		}
//		return temp.size()>res.size();
//	}

}
