package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_google_166 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(-50, 8));
		System.out.println((long)-2147483648/-1);
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        if (denominator == 1 || denominator == -1) return (long)numerator/denominator + "";
        //judge signal
        StringBuilder res = new StringBuilder();
        if((numerator>=0 && denominator<=0)|| (numerator<=0 && denominator>=0))
            res.append('-');
        
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        while (n>=d){//handle integer part
            long reminder = n%d;
            res.append(n/d);
            n = reminder;
        }

        if (n==0) return String.valueOf(res);
        //set decimal        
        res.append(((res.length()==0)||(res.length()==1&&res.charAt(0)=='-'))?"0.":".");
        //use hashset save each iterate reminder
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while(n!=0){//handle decimal part
            long reminder = n %d;
            if (map.containsKey(reminder)){
                res.insert(map.get(reminder),"(");
                res.append(")"); 
                break;
            } else{
                map.put(reminder,res.length());
            }
            n *= 10;
            res.append(n/d);
            n = n%d;
        }
        
        return String.valueOf(res);
    }
}
