package leetcode.StringArray;

public class AddBinary_67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addBinary(String a, String b) {
        int carry = 0;
        String longStr = a.length()>b.length()?a:b;
        String shortStr = a.length()<=b.length()?a:b;
        int longLen = longStr.length();
        int shortLen = shortStr.length();
        
        StringBuilder sb = new StringBuilder();
        
        for(int pos=0;pos<longLen;pos++){
            int cur;
            if (pos<shortLen)
                cur = shortStr.charAt(shortLen-pos-1) - '0' + longStr.charAt(longLen-pos-1) - '0' + carry;
            else 
                cur = longStr.charAt(longLen-pos-1) - '0' + carry;
            sb.append(cur&1);    
            carry = cur>>1;
        }
        if (carry>0) sb.append(carry);
        
        return String.valueOf(sb.reverse());
    }
}
