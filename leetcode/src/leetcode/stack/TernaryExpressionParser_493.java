package leetcode.stack;

import java.util.Stack;

public class TernaryExpressionParser_493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//stack way
	public String parseTernary(String e) {
        if(e==null || e.length()==0) return "";
		Stack<Character> stack = new Stack<>();
		int n = e.length();
		for(int i=n-1;i>=0; i--){
			char c = e.charAt(i);
			//System.out.println("stack:" + Arrays.toString(stack.toArray()));
			if(c =='?'){
				char res1 = stack.pop();
				char res2 = stack.pop();
				char cond = e.charAt(--i);
				stack.push(cond=='T'?res1:res2);
			}
			if(Character.isDigit(c) || c == 'F' || c == 'T'){
				stack.push(c);
			}
		}
		
		return stack.pop() + "";
	}
	
	//substring way
	public String parseTernary1(String e) {
        //3 chars as a group. search from end to top to find the question mark
		if(e == null || e.length()==0) return "";
		int n = e.length();
		
		for(int i=n-4;i>0;i--){
			if(e.charAt(i) == '?'){
			    //System.out.println("e:" + e +",substring:" + e.substring(i-1, i+3));
				e = e.substring(0, i-1) + cal(e.substring(i-1, i+4)) + e.substring(i+4);
			}
		}
		
		return e;
    }
	
	private char cal(String s){
		char condition = s.charAt(0);
		char res1 = s.charAt(2);
		char res2 = s.charAt(4);
		return condition == 'T'?res1:res2;
	}

}
