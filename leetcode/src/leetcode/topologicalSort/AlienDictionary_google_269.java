package leetcode.topologicalSort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary_google_269 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//code should be right
	public String alienOrder(String[] words) {
		if(words.length==0) return "";
        //save the char into map
		HashMap<Character, Set<Character>> map = new HashMap<>();
		HashMap<Character, Integer> degree = new HashMap<>();
		HashSet<Character> chars = new HashSet<>();
		//initial degree
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				chars.add(words[i].charAt(j));
			}
		}
		if(chars.size()==1){
		    return chars.iterator().next() + "";
		}
		//initial map
		for(int i=0;i<words.length-1;i++){
			String cur = words[i];
			String next = words[i+1];
			int len = Math.min(cur.length(), next.length());
			for(int j=0;j<len;j++){
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if(cur.substring(0,j).equals(next.substring(0,j)) && c1!=c2){
					if(!map.containsKey(c1)){
						map.put(c1, new HashSet());
					}	
					map.get(c1).add(c2);
					degree.put(c2, degree.getOrDefault(c2, 0)+1);
					if(!degree.containsKey(c1))
						degree.put(c1, 0);
				}
			}
		}
		
		//BFS topological sort
		Queue<Character> queue = new LinkedList<>();
		for(Character c:degree.keySet()){
			if(degree.get(c)==0)
				queue.offer(c);
		}
		
		String res = "";
		
		while(!queue.isEmpty()){
			char c = queue.poll();
			res += c;
			if(map.containsKey(c)){
				for(Character c1:map.get(c)){
					degree.put(c1, degree.get(c1)-1);
					if(degree.get(c1) == 0) queue.offer(c1);
				}
			}
		}
		
		return res.length()==chars.size()?res:"";
    }
	
	//code pass OJ
	public String alienOrder1(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}
