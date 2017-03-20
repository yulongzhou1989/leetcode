package leetcode.StringArray;

public class ReverseStringII_google_541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseStr(String s, int k) {
        if (k==0) return s;
        StringBuilder sb = new StringBuilder();
        //if k>s.length, k = s.length
        k=k>s.length()?s.length():k;
        for(int i=0,j=1,m=0;i<s.length();i++){
            if (j%2==1){
                int pos = k*j<s.length()?(k*j-1-m):(s.length()-m-1);
                sb.append(s.charAt(pos));
                m++;
            }
            else 
                sb.append(s.charAt(i));
            //if i+1 is multiple of k, j++, m
            if ((i+1)%k==0) {
                j++;
                m=0;
            }
        }
        return String.valueOf(sb);
    }
}
