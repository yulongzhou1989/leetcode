package leetcode.StringArray;

public class AddStrings_415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addStrings(String num1, String num2) {
        if (num1.length()==0) return num2;
        if (num2.length()==0) return num1;
        
        StringBuilder sb = new StringBuilder();
        String numLong = num1.length()>num2.length()?num1:num2;
        String numShort = num1.length()<=num2.length()?num1:num2;
        int carry = 0;
        int i=numLong.length()-1;
        int j=numShort.length()-1;
        
        while(i>=0){
            int cur = j>=0?(numLong.charAt(i--)-'0' + numShort.charAt(j--)-'0' + carry):(numLong.charAt(i--)-'0' + carry);
            carry=0;
            if (cur>=10){
                cur = cur%10;
                carry = 1;
            }
            sb.append(cur);
        }
        if (carry==1) sb.append(carry);

        return String.valueOf(sb.reverse());
    }
}
