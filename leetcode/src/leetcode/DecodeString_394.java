package leetcode;

import java.util.Stack;

public class DecodeString_394 {
	
	public static void main (String [] args){
		System.out.println(decodeString("10[leetcode]"));
	}
	
	public static String decodeString(String s){
		//StringBuilder sb = new StringBuilder();
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> resStack = new Stack<String>();
		String res = "";
		
		for(int i=0;i<s.length();){
			if (s.charAt(i)>='0' && s.charAt(i)<='9'){
				int count = 0;
				while(s.charAt(i)>='0' && s.charAt(i)<='9'){
					count = 10*count + s.charAt(i)-'0';
					i++;
				}
				countStack.push(count);
			}
			else if (s.charAt(i) == '['){
				resStack.push(res);
				res = "";
				i++;
			}
			else if (s.charAt(i) == ']'){
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTime = countStack.pop();
				for (int j=0;j<repeatTime;j++){
					temp.append(res);
				}
				res = String.valueOf(temp);
				i++;
			}else{
				res += s.charAt(i++);
			}
		}
		
		return res;
	}
	
	
	public static String decodeString1(String s){
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<s.length();i++){
			if (s.charAt(i)>'0' && s.charAt(i)<='9'){
				int times = s.charAt(i)-'0';
				//move pos
				i=i+2;
				StringBuilder sb1 = new StringBuilder();
				while(s.charAt(i)!=']'){
					sb1.append(s.charAt(i++));
				}
				for(int j=0;j<times; j++){
					sb.append(sb1);
				}
			}else {
				sb.append(s.charAt(i));
			}
		}
		
		return String.valueOf(sb);
	}
}
