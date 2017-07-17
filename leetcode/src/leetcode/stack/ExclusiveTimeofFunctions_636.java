package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.util;

public class ExclusiveTimeofFunctions_636 {
	
	public static void main(String [] args){
		List<String> list = new ArrayList<>();
		String s = "0:start:0,1:start:5,2:start:6,3:start:9,4:start:11,5:start:12,6:start:14,7:start:15,1:start:24,1:end:29,7:end:34,6:end:37,5:end:39,4:end:40,3:end:45,0:start:49,0:end:54,5:start:55,5:end:59,4:start:63,4:end:66,2:start:69,2:end:70,2:start:74,6:start:78,0:start:79,0:end:80,6:end:85,1:start:89,1:end:93,2:end:96,2:end:100,1:end:102,2:start:105,2:end:109,0:end:114";
		list = util.stringToArrayList1(s);
		//System.out.println(exclusiveTime(8, list));
	}
	
	public int[] exclusiveTime(int n, List<String> logs) {
        if(n==0 || logs.size()<=1) return new int [] {};
		Stack<Integer> stack = new Stack<>();
		int [] res = new int [n];
		int preTime = 0;
		for(String log:logs){
			String [] l = log.split(":");
			int idx = Integer.valueOf(l[0]);
			int time = Integer.valueOf(l[2]);
			if(l[1].equals("start")){
				if(!stack.isEmpty())
					res[stack.peek()] += time-preTime;
				stack.push(idx);
				preTime = time;
			}else if(l[1].equals("end")){
				res[stack.peek()] += time-preTime+1;
				stack.pop();
				preTime = time + 1;
			}
		}
		return res;
	}
}
