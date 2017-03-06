package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generatePossibleNextMoves("---+++-+++-+"));
	}

	public static List<String> generatePossibleNextMoves(String s) {
        String temp = "";
        List<String> res = new ArrayList<String>();
        for (int i=0;i<s.length()-1;i++){
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                temp = s.substring(0,i) + "--" + s.substring(i+2);
                res.add(temp);
            }
        }
        return res;
    }
}
