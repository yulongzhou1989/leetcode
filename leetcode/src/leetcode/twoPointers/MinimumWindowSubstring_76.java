package leetcode.twoPointers;

public class MinimumWindowSubstring_76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
        int [] arr = new int [256];
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i)]++;
        }
        
        int len=0;
        int from=0;
        int min=Integer.MAX_VALUE;
        for(int i=0, j=0;i<s.length();i++){
            if(--arr[s.charAt(i)]>=0) len++;
            while(len==t.length()){
                if(i-j+1<min){
                    min = i-j+1;
                    from = j;
                }
                if(arr[s.charAt(j++)]++==0) len--;
            }
        }
    
        return min==Integer.MAX_VALUE?"":s.substring(from, from+min);
    }
}
