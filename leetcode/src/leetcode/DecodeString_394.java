package leetcode;

public class DecodeString_394 {
	
	public static void main (String [] args){
		System.out.println(decodeString("3[a]2[bc]"));
	}
	
	public static String decodeString(String s){
		StringBuilder sb = new StringBuilder();
	}
	
	
	public static String decodeString1(String s){
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<s.length();i++){
			if (s.charAt(i)>'0' && s.charAt(i)<='9'){
				int times = s.charAt(i)-'0';
				//move pos
				i=i+2;
				StringBuilder sb1 = new StringBuilder();
				while(s.charAt(i)!=']'){
					sb1.append(s.charAt(i++));
				}
				for(int j=0;j<times; j++){
					sb.append(sb1);
				}
			}else {
				sb.append(s.charAt(i));
			}
		}
		
		return String.valueOf(sb);
	}
}
