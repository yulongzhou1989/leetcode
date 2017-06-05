package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParanthese_301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //dfs
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
		getParentheses(s, res, 0, 0, new char [] {'(',')'});
		return res;
    }
	
	private void getParentheses(String s, List<String> res, int preI, int preJ, char [] pair){
		//remove the ) when counter<0
		for(int i=preI, counter=0;i<s.length();i++){
			if(s.charAt(i)==pair[0]) counter++;
			if(s.charAt(i)==pair[1]) counter--;
			if(counter>=0) continue;
			for(int j=preJ;j<=i;j++){
				if(s.charAt(j)==pair[1] && (j==preJ || s.charAt(j-1)!=pair[1]))
					getParentheses(s.substring(0,j) + s.substring(j+1,s.length()), res, i, j, pair);
			}
			return;
		}
		
		String reversed = new StringBuilder(s).reverse().toString();
		//chech (()
		if(pair[0] == '(')
			getParentheses(reversed, res, 0, 0, new char []{')','('});
		else
			res.add(reversed);
	}
}
