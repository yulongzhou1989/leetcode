package leetcode.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordAbbreviation_google_527 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> wordsAbbreviation(List<String> dict) {
		int len = dict.size();
		int [] prefix = new int [len];
		String [] ans = new String [len];
		
		//initial abbreviations
		for(int i=0;i<len;i++){
			prefix[i] = 1;
			ans[i] = makeAbbr(dict.get(i),1);
		}
		//check same abbreviation
		for(int i=0;i<len; i++){
			while(true){
				HashSet<Integer> set = new HashSet<>();
				for(int j=i+1;j<len;j++){
					if(ans[j].equals(ans[i])) set.add(j);
				}
				if(set.isEmpty()) break;
				set.add(i);
				//if has 2 same abbrs, increase prefix
				for(int k:set){
					ans[k] = makeAbbr(dict.get(k), ++prefix[k]);
				}
			}
		}
		return Arrays.asList(ans);		
    }
	
	//prefLen is the prefix letters length
	private String makeAbbr(String o, int prefLen){
		int num = o.length()-prefLen-1;
		if(num<=1) return o;
		String res = o.substring(0, prefLen) + num + o.substring(o.length()-1);
		return res;
	}
}
