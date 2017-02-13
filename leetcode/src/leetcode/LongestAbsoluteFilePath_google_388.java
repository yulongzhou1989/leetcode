package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath_google_388 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}
	
	public static int lengthLongestPath(String input) {
		String [] pathes = input.split("\n");
		int maxLen = 0;
		Deque<Integer> stack = new ArrayDeque<> ();
		stack.push(0);
		for (String s: pathes){
			int level = s.lastIndexOf("\t") + 1;
			while (level + 1< stack.size()) stack.pop();
			int len = stack.peek() + s.length()-level+1;
			stack.push(len);
			if (s.contains(".")) maxLen = maxLen<len? maxLen:len;
		}
		
		return maxLen;
    }
	
}