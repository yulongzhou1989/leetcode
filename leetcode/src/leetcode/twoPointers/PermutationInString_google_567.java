package leetcode.twoPointers;

public class PermutationInString_google_567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1==0) return true;
        if(len1>len2) return false;
        
        int [] arr = new int [26];
        
        for(int i=0;i<len1;i++){
            arr[s1.charAt(i)-'a']++;
        }
        
        for(int i=0, j=0;i<len2;i++){
            if(--arr[s2.charAt(i)-'a']<0){
                //slide left window, and reset the arr
                while(++arr[s2.charAt(j++)-'a']!=0);
            } else if(i-j+1==len1) 
                return true;
        }
        
        return false;
    }
}
