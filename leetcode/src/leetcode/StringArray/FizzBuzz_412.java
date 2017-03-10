package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String> ();
        
        for (int i=1;i<=n;i++){
            if(i%3==0 && i%5!=0) res.add("Fizz");
            else if (i%5==0 && i%3!=0) res.add("Buzz");
            else if (i%5==0 && i%3==0) res.add("FizzBuzz");
            else res.add(String.valueOf(i));
        }
        
        return res;
    }

}
