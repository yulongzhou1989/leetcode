package leetcode.Heap;

public class SuperUglyNumber_google_313 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] primes = new int [] {2, 3, 5};
		System.out.println(nthSuperUglyNumberI(3, primes));
	}
	
	// Basic idea is same as ugly number II, new ugly number is generated by multiplying a prime 
	// with previous generated ugly number. One catch is need to remove duplicate
	public static int nthSuperUglyNumberI(int n, int [] primes){
		int [] ugly = new int [n];
		int [] idx = new int[primes.length];
		
		ugly[0] = 1;
		for(int i=1;i<n;i++){
			//find next
			ugly[i] = Integer.MAX_VALUE;
			for(int j=0; j< primes.length; j++)
				ugly[i] = Math.min(ugly[i], primes[j]*ugly[idx[j]]);
			//slip duplicate
			for(int j=0; j<primes.length;j++){
				while(primes[j]*ugly[idx[j]]<=ugly[i]) idx[j]++;
			}
		}
		
		return ugly[n-1];
	}

}
