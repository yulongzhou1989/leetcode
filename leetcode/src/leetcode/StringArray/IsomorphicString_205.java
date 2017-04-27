package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString_205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIsomorphic(String s, String t) {

		Map<Character, Character> maps = new HashMap<>();
		Map<Character, Character> mapt = new HashMap<>();
		
		for(int i=0;i<s.length();i++){
			Character sc = s.charAt(i);
			Character tc = t.charAt(i);
			if(!maps.containsKey(sc) && !mapt.containsKey(tc)){
				maps.put(sc, tc);
				mapt.put(tc, sc);
			}
			else if(maps.containsKey(sc) && mapt.containsKey(tc)){
				if(maps.get(sc)!=tc && maps.get(tc)!=sc) return false;
			}
			else {
				return false;
			}	
		}
		
		return true;
    }
}
