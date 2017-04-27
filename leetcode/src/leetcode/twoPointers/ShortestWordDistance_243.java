package leetcode.twoPointers;

public class ShortestWordDistance_243 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int shortestDistance(String[] words, String word1, String word2) {
        int p1=-1, p2=-1;
		int res = Integer.MAX_VALUE;
		for (int i=0;i<words.length;i++){
			if(words[i].equals(word1)){
			    p1=i;
				if(p2!=-1) res = Math.min(Math.abs(p1-p2), res);
			} else if(words[i].equals(word2)){
			    p2=i;
				if(p1!=-1) res = Math.min(Math.abs(p1-p2), res);
			}
		}
		
		return res;
    }	
}
