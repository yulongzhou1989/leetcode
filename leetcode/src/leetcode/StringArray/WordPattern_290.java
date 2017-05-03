package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordPattern(String pattern, String str) {
        
        String [] arr = str.split(" ");
        if(pattern.length()!=arr.length) return false;
        
        Map<Character, String> map = new HashMap<>();
                
        for(int i=0;i<pattern.length();i++){
            Character c = pattern.charAt(i);
            if(!map.containsKey(c)) {
                if(map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            }else{
                if(!map.get(c).equals(arr[i])) return false;
            }
        }
        
        return true;
    }
}
