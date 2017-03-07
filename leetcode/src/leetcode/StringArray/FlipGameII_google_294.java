package leetcode.StringArray;

public class FlipGameII_google_294 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWin("---+++-+---+"));
	}
	
	public static boolean canWin(String s){
        if (!s.contains("++")) return false;
        for (int i=0;i<s.length()-1;i++){
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
            	String temp = s.substring(0,i) + "--" + s.substring(i+2);
                if (!temp.contains("++"))
                	return true;
            }
        }
        
        return false;
	}

}
