package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(greyCode(4));
	}

	public static List<Integer> greyCode(int n){
		List<Integer> result  = new ArrayList<Integer> ();
		for (int i=0;i<1<<n; i++){
			result.add(i^i>>1);
		}
		return result;
	}
}
