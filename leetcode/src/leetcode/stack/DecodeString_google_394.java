package leetcode.stack;

import java.util.Stack;

public class DecodeString_google_394 {
	public String decodeString(String s) {
        if(s==null || s.length()<2) return s;
		
		Stack<String> stack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		int n = s.length();
		int i = 0;
		while(i < n) {
			int num = 0;
			if(Character.isDigit(s.charAt(i))){
				while(Character.isDigit(s.charAt(i))){
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				numStack.push(num);
			}
			else if(s.charAt(i) == ']'){
				String cur = "";
				while(!stack.isEmpty() && !stack.peek().equals("[")){
					cur = stack.pop() + cur;
				}
                if(!stack.isEmpty()) stack.pop();//pop ［
				int repeatTimes = 0;
				if(!numStack.isEmpty()){
					repeatTimes = numStack.pop();
				}
				StringBuilder sb = new StringBuilder();
				while(repeatTimes-- > 0){
					sb.append(cur);
				}
				stack.push(sb.toString());
                i++;
			}
			else{
				stack.push(s.charAt(i++) + "");
			}
            
            //System.out.println(Arrays.toString(stack.toArray()));
		}
		
		String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res; 
        }
        
        return res;
    }
}
