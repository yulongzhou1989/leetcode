package leetcode.math;

import java.util.Arrays;

public class CountPrimes_204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int countPrimes(int n) {
        //default is prime true
		boolean [] isPrime = new boolean [n];
		
		Arrays.fill(isPrime, true);
		
		for(int i=2;i<=Math.sqrt(n);i++){
			for(int j=i*i;j<n;j+=i){
				isPrime[j] = false;
			}
		}
		int count=0;
		for(int i=2;i<n;i++){
			if(isPrime[i]) count++;
		}
		
		return count;
    }
    
    public int countPrimes1(int n) {
        //default is prime true
		boolean [] isPrime = new boolean [n];
		
		Arrays.fill(isPrime, true);
		
		for(int i=2;i<=Math.sqrt(n);i++){
			for(int j=i*i;j<n;j+=i){
				isPrime[j] = false;
			}
		}
		int count=0;
		for(int i=2;i<n;i++){
			if(isPrime[i]) count++;
		}
		
		return count;
    }
}
