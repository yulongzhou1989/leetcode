package leetcode.sort.DivideAndConque;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthese_241 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(diffWaysToCompute("2-1-1"));
	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<input.length();i++){
			Character c = input.charAt(i);
			if(c == '*' || c == '+' || c == '-'){
				//do same operate for each half
				String part1 = input.substring(0,i);
				String part2 = input.substring(i+1);
				List<Integer> al = diffWaysToCompute(part1);
				List<Integer> bl = diffWaysToCompute(part2);
				for(int j=0;i<al.size();i++){
					for(int k=0;j<bl.size();j++){
						if(c=='+') res.add(al.get(j)+bl.get(k));
						else if(c=='-') res.add(al.get(j)-bl.get(k));
						else if(c=='*') res.add(al.get(j)*bl.get(k));
						else res.add(0);
					}
				}
			}			
		}
		if(res.size() == 0) res.add(Integer.valueOf(input));
		return res;
    }
}
