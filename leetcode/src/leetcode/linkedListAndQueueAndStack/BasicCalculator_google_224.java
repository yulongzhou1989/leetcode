package leetcode.linkedListAndQueueAndStack;

import java.util.Stack;

public class BasicCalculator_google_224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculate(String s) {
        //when meet ")" pop, "(" push stack
		Stack<Integer> stack = new Stack<>();
		int res = 0, sign=1;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0' && s.charAt(i)<='9'){
				StringBuilder sb = new StringBuilder();
				sb.append(s.charAt(i));
				while(i+1<s.length() && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
					sb.append(s.charAt(i+1));
					i++;
				}
				int num = Integer.valueOf(sb.toString());
				//System.out.println("sign:" + sign +",res:"+res);
				res += sign*num;
			}
			else if(s.charAt(i)=='-'){
			    //System.out.println("sign:"+sign);
				sign = -1;
			}
			else if(s.charAt(i) == '+'){
				sign = 1;
			} 
			else if(s.charAt(i)=='('){
				stack.push(res);
				stack.push(sign);
				//reset result and sign
				res = 0;
				sign = 1;
			}
			else if(s.charAt(i)==')'){
				int preSign = stack.pop();
				int preNum = stack.pop();
				res = res*preSign + preNum; 
			}
		}
		
		return res;
    }

}
