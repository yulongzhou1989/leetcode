package leetcode.dp;

public class ShortestPalindrome_214 {
	//find the longest palindrome substring, and then add additional part
	public String shortestPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1) return s;
		int n = s.length();
		boolean [][] pal = new boolean [n][n];//from index i->j is palindrome
		for(int i=0;i<n;i++){
			pal[i][i] = true;
			int [] even = initialPal(i-1, i+1, s, pal);
			int [] odd = initialPal(i, i+1, s, pal);
			
		}
		
    }
	
	
	private int [] initialPal(int i, int j, String s, boolean [][] pal){
		int n = s.length();
		int [] res = new int [] {-1, -1};
		while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
			pal[i][j] = true;
			i++;
			j--;
		}
	}
}
