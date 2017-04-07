package leetcode.StringArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency_google_451 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String frequencySort(String s) {
        if(s==null ||s.length()==0) return s;
		
		Map<Character, Integer> map = new HashMap<>();
		//save s to map
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)) map.put(c,0);
			map.put(c, 1 + map.get(c));
		}
		//store list array by frequency
		List<Character> [] freqArr = new List [s.length()+1];
		for(Character c:map.keySet()){
			int i = map.get(c);
			if(freqArr[i]==null) freqArr[i] = new ArrayList<>();
			freqArr[i].add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=freqArr.length-1;i>0;i--){
			if(freqArr[i]!=null) {
				//append the string by frequency
				for(Character c: freqArr[i]){
					for(int j=0;j<i;j++)
						sb.append(c);
				}
			}
		}
		
		return String.valueOf(sb);
    }

}
