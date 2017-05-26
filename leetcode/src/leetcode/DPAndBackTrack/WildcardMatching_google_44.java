package leetcode.DPAndBackTrack;

public class WildcardMatching_google_44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isMatch("a","a*"));
	}
	/*
	 * For each element in s
	 *  If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
	 * If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
	 * If not match, then we check if there is a * previously showed up,
     *  if there is no *,  return false;
     *  if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.
		
	 * e.g.
		
	 *	abed
	 *	?b*d**
		
	 * a=?, go on, b=b, go on,
	 *	e=*, save * position star=3, save s position ss = 3, p++
	 *	e!=d,  check if there was a *, yes, ss++, s=ss; p=star+1
	 *	d=d, go on, meet the end.
	 *	check the rest element in p, if all are *, true, else false;
	 */

	public boolean isMatch(String s, String p) {
        int i=0,  j=0, match=0, startIdx = -1;
        while(i<s.length()){
          if(j<p.length() && (p.charAt(j)=='?' || s.charAt(i)==p.charAt(j))){
            i++;
            j++;
          }
          else if(j<p.length() && p.charAt(j)=='*'){
            startIdx = j;
            match = i;
            j++;
          }
          else if(startIdx!=-1){
            j = startIdx+1;
            match++;
            i = match;
          }
          else return false;
        }
    
        while(j<p.length() && p.charAt(j)=='*')
          j++;
    
        return j==p.length();
    }
}
