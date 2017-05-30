package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_google_282 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
		helper(res, target, num, "", 0, 0, 0);
		return res;
    }
	
	private void helper(List<String> res, int target, String num, String path, int pos, long eval, long multi){
		if(pos == num.length()) {
			if(eval==target)
				res.add(path);
			return;
		}
		for(int i=pos;i<num.length();i++){
		    //remove dulplicate
		    if(i!=pos && num.charAt(pos)=='0') break;
			long cur = Long.parseLong(num.substring(pos,i+1));
			//if first recursive
			if(pos==0){
				helper(res, target, num, path+cur, i+1, cur, cur);
			}else{
				//+/-/*
				helper(res, target, num, path+"+"+cur, i+1, eval+cur, cur);
				helper(res, target, num, path+"-"+cur, i+1, eval-cur, -cur);
				helper(res, target, num, path+"*"+cur, i+1, eval-multi+multi*cur, multi*cur);
			}
		}
	}
}
