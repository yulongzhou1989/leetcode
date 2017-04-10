package common;

import java.util.ArrayList;
import java.util.List;

public class util {

	public static List<List<Integer>> stringToArrayList(String s){
		List<List<Integer>> res = new ArrayList<>();
		if(s.length()<2) return res;
		s = s.replace("[", "");
		s = s.substring(0, s.length()-1);
		String [] lists = s.split("]");
		for(String list:lists){
			String [] elements = list.split(",");
			List<Integer> temp = new ArrayList<>();
			for(String e: elements){
				if(e.length()!=0) {
					temp.add(Integer.valueOf(e));
				}
			}
			res.add(temp);
		}
		
		return res;
	}
}
