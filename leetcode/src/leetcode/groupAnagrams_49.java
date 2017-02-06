package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = {"abc", "bca", "dea"};
		System.out.println(groupAnagrams(strs));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) return new ArrayList<List<String>> ();
		Map<String, List<String>> map = new HashMap<String, List<String>> ();
		
		for(int i=0;i<strs.length;i++){
			char [] c = strs[i].toCharArray();
			Arrays.sort(c);
			String s = String.valueOf(c);
			
			if (!map.containsKey(s)){
				map.put(s, new ArrayList<String>());
			}
			map.get(s).add(strs[i]);
		}
		
		return new ArrayList<List<String>> (map.values());
	}
	
	public static List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> result = new ArrayList<> ();
		
		if (strs.length == 0){
			return result;
		}
		
		List<String> l = new ArrayList<> ();
		l.add(strs[0]);
		result.add(l);
		
		for(int i=1;i<strs.length; i++){
			boolean flag = false;
			for (int j=0;j<result.size();j++){
				List <String> currentList = result.get(j);
				String currentStr = currentList.get(currentList.size()-1);
				if (judgeEquel(currentStr,strs[i])){
					result.get(j).add(strs[i]);
					flag = true;
				}
			}
			if (!flag){
				List<String> l1 = new ArrayList<> ();
				l1.add(strs[i]);
				result.add(l1);
			}
		}
		
		return result;
    }
	
	public static boolean judgeEquel(String a, String b){
		if (a.length() != b.length())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer> ();

		for (int i=0; i<a.length(); i++){
			if (map.get(a.charAt(i)) == null){
				map.put(a.charAt(i), 1);
			} else {
				map.put(a.charAt(i), map.get(a.charAt(i))+1);
			}
			if (map.get(b.charAt(i)) == null){
				map.put(b.charAt(i), -1);
			} else {
				map.put(b.charAt(i), map.get(b.charAt(i))-1);
			}
		}
		
		for (int i=0;i<a.length();i++){
			if (map.get(a.charAt(i)) !=0){
				return false;
			} 
		}
			
		return true;
	}
	
	
}
