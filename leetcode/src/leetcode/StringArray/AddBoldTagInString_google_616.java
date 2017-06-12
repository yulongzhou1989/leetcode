package leetcode.StringArray;

public class AddBoldTagInString_google_616 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addBoldTag(String s, String[] dict) {
		
		if(s==null || s.length()==0 || dict==null || dict.length==0) return s;
        boolean [] mark = new boolean [s.length()]; 
		
		//set intervals
		for(int i=0, end=0;i<s.length();i++){
			for(int j=0;j<dict.length;j++){
				if(s.startsWith(dict[j], i)){
					end = Math.max(end, i+ dict[j].length());
				}
			}
			mark[i] = end>i;
		}
	
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s.length();i++){
			if(!mark[i]){
				sb.append(s.charAt(i));
				continue;
			}
			int j=i;
			sb.append("<b>");
			while(j<s.length() && mark[j]){
				sb.append(s.charAt(j++));
			}
			sb.append("</b>");
			i = j-1;
		}
		
		return sb.toString();
    }
}
