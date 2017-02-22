package leetcode;

public class Google_StrobogrammaticNumber_246 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isStrobogrammatic(String num){
		//Character [] c1 = {'0','1','2','3','4','5','6','7','8','9'};
		//Character [] c2 = {'0','1','N','N','N','N','9','N','8','6'};
		int len = num.length();
		int n = len%2 == 0?len/2:len/2+1;
		for(int i=0,k=len-1;i<n;i++){
			//if (c1[num.charAt(i)-'0'] != c2[num.charAt(k)-'0']) return false;
			if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(k)))
	            return false;
		}
		
		return true;
	}

}
