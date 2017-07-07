package leetcode.dp;

public class ShortestPalindrome_214 {
	//KMP -> http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
	
	//find the longest palindrome substring start with 0, and then add additional part
	public String shortestPalindrome(String s) {
		if(s.length()<2) return s;
		int n = s.length();
        int [] arr = getLpa(s);
        //System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder(s.substring(arr[arr.length-1]));
		return sb.reverse().toString() + s;
    }
	
	//get longest proper prefix
	private int [] getLpa(String s){
		StringBuilder sb = new StringBuilder(s);
        String pattern = s + "#" + sb.reverse().toString();
		int n = pattern.length();
		int [] res = new int [n];//s && reverse(s) && #
		int len = 0;//len of the previous longest prefix
		int i =1; //loop from i->n-1;
		
		while(i<n){
			if(pattern.charAt(i) == pattern.charAt(len)){
				len++;
				res[i] = len;
				i++;
			}else{
				if(len!=0){
					len = res[len-1];//AAACAAA i=7
				}else{
					res[i] = 0;
					i++;
				}
			}
		}
		
		return res;
	}
}
