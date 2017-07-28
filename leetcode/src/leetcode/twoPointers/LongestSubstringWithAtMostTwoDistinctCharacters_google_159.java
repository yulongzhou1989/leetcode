package leetcode.twoPointers;

public class LongestSubstringWithAtMostTwoDistinctCharacters_google_159 {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0) return 0;
		int k = 2;
		int [] count = new int [256];
		int len = 0;
		int max = 0;
		//slide window, j is the start point and i is the end point.
		//if meet different character, len ++, if len>k, move left pointer,
		//keeping pop out the character until pop out a different character to make the length
		//back to k again.
		for(int i=0,j=0;i<s.length();i++){
			if(count[s.charAt(i)]++==0) len++;
			if(len>k){
				while(--count[s.charAt(j++)]>0);
				len--;
			}
			
			max = Math.max(max, i-j+1);
		}
	
		return max;
    }
	
	public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int n = s.length();
		int k = 2;
		int [] map = new int [256];
		int max = 0, len = 0;
		for(int i=0, j=0;i<n;i++){
            if(map[s.charAt(i)]++==0) len++;//又用个新字符
			while(j<n && len>k){
				if(--map[s.charAt(j)]==0) len--;//释放字符
				j++;
			}
            //System.out.println(j);
			max = Math.max(i-j+1, max);
			
		}
		
		return max;
    }
}
