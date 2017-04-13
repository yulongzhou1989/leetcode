package leetcode.linkedListAndQueueAndStack;

import java.util.Stack;

public class RemoveKDigits_402 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeKdigits("1234567890",9));
	}

	public static String removeKdigits(String num, int k) {
        //if next digit is smaller than previous one, pop out previous
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty() && num.charAt(i)<stack.peek() && k>0){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        
        //trim start 0s
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        
        return sb.length()==0?"0":String.valueOf(sb);
    }
}
