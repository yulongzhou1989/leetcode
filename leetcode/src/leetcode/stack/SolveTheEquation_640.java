package leetcode.stack;

import java.util.Stack;

public class SolveTheEquation_640 {
	public String solveEquation(String s) {
        if(s.length()==0) return s;
		//before = number->neg, x->pos, after = number pos, x->neg
		int sign = -1;
		int xCount = 0;
		int numCount = 0;
		int curSign = 1;
		Stack<Integer> numStack = new Stack<>();
        int i=0;
		while(i<s.length()){
            //System.out.println(s.charAt(i));
			if(s.charAt(i)=='x'){
				if(i==0 || s.charAt(i-1) == '-' || s.charAt(i-1) == '+' || s.charAt(i-1) == '='){
					xCount += sign*-1*curSign;
				}else {
					xCount += -1*numStack.pop();
				}
                //System.out.println(xCount);
			}
			else if (s.charAt(i) == '+'){
				curSign = 1;
			}
            else if (s.charAt(i) == '-'){
				curSign = -1;
			}
			else if (s.charAt(i) == '='){
				sign *= -1;
                curSign = 1;
			}
			else if (Character.isDigit(s.charAt(i))){
				StringBuilder sb = new StringBuilder();
				while(i<s.length() && Character.isDigit(s.charAt(i))){
					sb.append(s.charAt(i));
					i++;
				}
				numStack.push(sign*curSign*Integer.valueOf(sb.toString()));
				//System.out.println(sign + "," + curSign + "," + numStack.peek());
                continue;
			}
            i++;
		}
		
		while(!numStack.isEmpty()){
			numCount += numStack.pop();
		}
		
		if(xCount == 0 && numCount == 0){
			return "Infinite solutions";
		}
		if(xCount == 0 && numCount!=0){
			return "No solution";
		}
        //System.out.println(xCount);
		
		int res = numCount/xCount;
		
		return "x=" + res;
    }
}
