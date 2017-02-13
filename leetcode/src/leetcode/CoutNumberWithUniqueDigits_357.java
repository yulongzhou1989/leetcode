package leetcode;

public class CoutNumberWithUniqueDigits_357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1;i<=10;i++){
			System.out.println(countNumbersWithUniqueDigits1(i));
		}
	}
	
	public static int countNumbersWithUniqueDigits(int n) {
		if (n>10) n = 10;
		int [] memo = new int [11];
        helper(n,  memo);
        return memo [n];
    }
	
	public static int helper (int n, int [] memo){
		int fn = 0;
		if (n==0) {
			fn = 1;
			memo[0] = 1;
		}
		else if (n==1){
			fn = 10;
			memo[1] = 10;
		}
		else if (n==2){
			fn = 9*9;
			memo[2] = 9*9 + 10;
		}
		else{
			fn =  helper(n-1, memo)*(10-n+1);
			memo[n] = memo[n-1] + fn;
		}
		
		return fn;
	}
	
	public static int countNumbersWithUniqueDigits1(int n) {
		
		if (n == 0) return 1;
		if (n == 1) return 10;
		if (n == 2) return 9*9 +10;
		if (n>10) n =10;
		
		int [] f = new int [11]; 
		f[2] = 9*9;
		int result = 9*9+10;
		
		for (int i=3;i<=n;i++){
			f[i] =  f[i-1]*(10-i+1);
			result += f[i];
		}
		
		return result;
	}
	
	public static int countNumbersWithUniqueDigits2(int n){
		if (n == 0) return 1;
		if (n == 1) return 10;
		if (n == 2) return 91;
		if (n == 3) return 739;
		if (n == 4) return 5275;
		if (n == 5) return 32491;
		if (n == 6) return 168571;
		if (n == 7) return 712891;
		if (n == 8) return 2345851;
		if (n == 9) return 5611771;
		else return 8877691;
	}
} 