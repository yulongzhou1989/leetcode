package leetcode.linkedListAndQueueAndStack;

import java.util.Stack;

public class BasicCalculatorII_227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calculate(String s) {
        //go over string to save numbers and operators into stack
		Stack<Integer> stack = new Stack<>();
		int num = 0, sign='+';
		for(int i=0;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				StringBuilder sb = new StringBuilder();
				sb.append(s.charAt(i));
				while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
					sb.append(s.charAt(i+1));
					i++;
				}
				num = Integer.valueOf(sb.toString());
			}
			if((!Character.isDigit(s.charAt(i))&& s.charAt(i)!=' ')|| i==s.length()-1){
				if(sign=='+'){
					stack.push(num);
				}
				if(sign=='-'){
					stack.push(-num);
				}
				if(sign=='*'){
					stack.push(stack.pop()*num);
				}
				if(sign=='/'){
					stack.push(stack.pop()/num);
				}
				sign = s.charAt(i);
				num=0;
			}
		}
		
		int res = 0;
		while(!stack.isEmpty()){
			res += stack.pop();
		}
		
		return res;
    }
}
