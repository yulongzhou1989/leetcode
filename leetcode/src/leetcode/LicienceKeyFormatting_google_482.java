package leetcode;

public class LicienceKeyFormatting_google_482 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(licenceKeyFormatting1("2-4A0r7-4k",4));
	}

	public static String licenseKeyFormatting(String S, int K) {
        
        String noDashStr = S.replace("-", "");
        if (K>noDashStr.length())
        {
        	return noDashStr;
        }
        int first = noDashStr.length()%K;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<noDashStr.length(); i++){
        	Character c = noDashStr.charAt(i);
        	if (c>='a' && c<='z'){
        		sb.append((char)(c-'a'+'A'));
        	}else {
        		sb.append(c);
        	}
        	if (i+1 == first){
        		sb.append("-");
        	}else if (i-first+1>0 && (i-first+1)%K == 0 && i!=noDashStr.length()-1) { 
        		sb.append("-");
        	}
        }
        
        return String.valueOf(sb);
    }
	
	public static String licenceKeyFormatting1(String S, int K){
		StringBuilder sb = new StringBuilder();
		for (int i=S.length()-1;i>=0;i--){
			if (S.charAt(i)!='-') sb.append(sb.length()%(K+1)==K?"-":"").append(S.charAt(i));
		}
		return String.valueOf(sb.reverse()).toUpperCase();
	}
}
