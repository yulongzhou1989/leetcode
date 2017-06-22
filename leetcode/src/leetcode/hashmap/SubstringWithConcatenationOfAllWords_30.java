package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Onpk
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length==0) return res;
		
		HashMap<String, Integer> map = new HashMap<>();
		//initial hash
		for(String str:words){
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		int n = words[0].length();
		int m = words.length;
		
		if(n*m>s.length()) return res;
		for(int i=0;i<s.length()-m*n+1;i++){
			HashMap<String, Integer> curMap = new HashMap<>(map);
			for(int j=0;j<m;j++){
				String curS = s.substring(i+j*n, i+(j+1)*n);
				//System.out.println(curS);
				if (curMap.containsKey(curS)) { // is in remaining words
                int count = curMap.get(curS);
                if (count == 1) curMap.remove(curS);
					else curMap.put(curS, count - 1);
					if (curMap.isEmpty()) { // matches
						res.add(i);
						break;
					}
				} else break; // not in L
			}
		}
		
		return res;
    }

}
