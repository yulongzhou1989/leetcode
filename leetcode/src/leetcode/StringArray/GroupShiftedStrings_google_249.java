package leetcode.StringArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_google_249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strings = new String [] {"abc","am"};
		System.out.println(groupStrings(strings).toString());
	}
	
	public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String s:strings){
            if (s.length()==0) continue;
            //revert curret string to a key which is the difference between each letter
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<s.length();i++){
                int val = s.charAt(i)-s.charAt(0);
                val = val<0?(val+26):val;
                sb.append(val).append(",");
            }
            String key = String.valueOf(sb);
            if (!map.containsKey(key)){
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            } else {
                map.get(key).add(s);
            }
        }
        
        return new ArrayList<List<String>> (map.values());
    }

}
