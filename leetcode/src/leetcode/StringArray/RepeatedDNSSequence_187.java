package leetcode.StringArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNSSequence_187 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
		List<String> res = new ArrayList<>();
		for(int i=0;i<s.length()-9;i++){
			String temp = s.substring(i, i+10);
			if(!set.add(temp) && !res.contains(temp)) res.add(temp); 
		}
		return res;
    }
    
}
