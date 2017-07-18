package leetcode.greedy;

public class RearrangeStringKDistanceApart_google_358 {
	public String rearrangeString(String s, int k) {
        if(s==null || s.length()==0) return "";
		int n = s.length();
		int [] count = new int [26];
		int [] valid = new int [26];
		for(int i=0;i<s.length();i++){
			count[s.charAt(i)-'a']++;
		}
        //System.out.println(Arrays.toString(count));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			int pos = getPos(valid, count, i);
			if(pos == -1) return "";
			count[pos]--;
			valid[pos] = i+k;//at least k dis till next time
			sb.append((char)('a'+pos));
		}
		
		return sb.toString();
    }
	//find the pos which has the max count with valid position
	private int getPos(int [] valid, int [] count, int index){
		int max = Integer.MIN_VALUE;
		int pos = -1;
		for(int i=0;i<26;i++){
			if(count[i]>0 && max<count[i] && index>=valid[i]){
				max = count[i];
				pos = i;
			}
		}
		
		return pos;
	}
}
