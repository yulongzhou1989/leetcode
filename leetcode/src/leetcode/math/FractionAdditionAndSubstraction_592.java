package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubstraction_592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//test cases:
		//"-1/2+1/2"
		//" 1/2 + 1 +1"
	    public String fractionAddition(String s) {
			//split the string to lists saving denominators and numerators
	        List<Integer> denominators = new ArrayList<>();
			List<Integer> numerators = new ArrayList<>();
			int sign = 1;
			//flag to indicate denominator or numerator
			boolean nFlag = true;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='-' || s.charAt(i)=='+'){
					sign = s.charAt(i)=='-'?-1:1;
					if(i!=0){
						//handling case 2
						if(nFlag) {
							denominators.add(1);
						}
						nFlag = true;
					}
				} 
				else if(s.charAt(i) == '/') {
				    nFlag = false;
				    sign = 1;
				}
				else if(Character.isDigit(s.charAt(i))){
					StringBuilder sb = new StringBuilder();
					sb.append(s.charAt(i));
					while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
						sb.append(s.charAt(i+1));
						i++;
					}
					int num = Integer.parseInt(sb.toString());
					if(nFlag) numerators.add(num*sign);
					else denominators.add(num*sign);
					//handling case 2
					if(i==s.length() && nFlag)
						denominators.add(1);
				}
				//handling case 2
				if(i==s.length()-1 && nFlag && numerators.size()>denominators.size()){
					denominators.add(1);
				}
			}

			if(numerators.size()==0) return "";
			int n=numerators.get(0);
			int d=n==0?1:denominators.get(0);
			if(numerators.size()==1) return n + "/" + d;
			
			//cal the res
			for(int i=1;i<numerators.size();i++){
				int [] f = calFraction(n, d, numerators.get(i), denominators.get(i));
				n = f[0];
				d = f[1];
			}
			
			return n + "/" + (n==0?1:d);
	    }
		
		//cal the fraction result of two inputs
		private int [] calFraction(int n1, int d1, int n2, int d2){
			int lcd = d1*d2/getGCD(d1, d2);
			//cal numerator
			int n = lcd/d1*n1 + lcd/d2*n2;
			//reduction 
			int gcd = Math.abs(getGCD(n, lcd));
			return new int [] {n/gcd, lcd/gcd};
		}
		
		private int getGCD(int a, int b){
			if(b==0) return a;
			return getGCD(b, a%b);
		}
}
