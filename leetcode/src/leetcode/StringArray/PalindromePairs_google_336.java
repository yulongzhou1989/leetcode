package leetcode.StringArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs_google_336 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//cut the string to 2 portion, keep the palindrome part, 
		// and find the reverse sequenence in the hash
		// ON*K time
		public List<List<Integer>> palindromePairs(String[] words) {
			Map<String, Integer> map = new HashMap<>();
			for(int i=0;i<words.length;i++){
				map.put(words[i],i);
			}
			List<List<Integer>> res = new ArrayList<>();
			for(int i=0;i<words.length;i++){
				String w = words[i];
				for(int j=0;j<=w.length();j++){
					String str1 = w.substring(0,j);
					String str2 = w.substring(j);
					if(isPalindrome(str1)){
						String left = new StringBuilder(str2).reverse().toString();
						if(map.containsKey(left) && map.get(left)!=i){
							res.add(Arrays.asList(map.get(left),i));
						}
					}
					if(isPalindrome(str2)){
						String left = new StringBuilder(str1).reverse().toString();
						if(map.containsKey(left) && map.get(left)!=i && str2.length()!=0){
							res.add(Arrays.asList(i, map.get(left)));
						}
					}
				}
			}
			return res;
	    }
		
		
		private boolean isPalindrome(String s){
			int i=0;
			int j=s.length()-1;
			while(i<j){
				if(s.charAt(i++)!=s.charAt(j--)) return false;
			}
			return true;
		}

}
