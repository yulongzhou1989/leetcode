package leetcode.math;

public class ExcelSheetTitle_168 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String convertToTitle(int n) {
        if(n<=0) return "";
        StringBuilder sb = new StringBuilder();
		while(n>0){
			n--;
			sb.insert(0, (char)(n%26+'A'));  
			n = n/26;
		}
		return sb.toString();
    }

}
