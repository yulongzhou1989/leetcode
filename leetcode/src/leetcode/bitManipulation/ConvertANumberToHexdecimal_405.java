package leetcode.bitManipulation;

public class ConvertANumberToHexdecimal_405 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toHex(int num) {
		StringBuilder res = new StringBuilder();
        while(num!=0){
			int digNum = num&15;
			res.insert(0, digNum>9? (char)('a' + (digNum-10)) : digNum+"");
			num>>>=4;
		}
		
		return res.toString();
    }

}
