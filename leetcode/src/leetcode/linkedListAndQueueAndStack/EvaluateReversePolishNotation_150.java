package leetcode.linkedListAndQueueAndStack;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int evalRPN(String[] tokens) {
        if (tokens.length==0) return 0;
        Stack<String> stack = new Stack<String>();
        for(String s:tokens){
            if(!isOperator(s)) stack.push(s);
            else {
                String second = stack.pop();
                String first = stack.pop();
                stack.push(cal(s, first, second).toString());
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) return true;
        return false;
    }
    
    private Integer cal(String o, String first, String second){
        Integer a = Integer.parseInt(first);
        Integer b = Integer.parseInt(second);
        if(o.equals("+")) return a+b;
        else if(o.equals("-")) return a-b;
        else if(o.equals("*")) return a*b;
        else if(o.equals("/")) return a/b;
        else return 0;
    }

}
