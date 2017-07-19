package leetcode.math;

public class NthDigit_google_400 {
	public int findNthDigit(int n) {
        //找规律1-9 ->9 , 10->99 2*90 100->999 3*900
		int start = 1;
		long base = 9;
		int count = 1;
		
		while(n> base*count){//find how many digits for the 
			n -= base*count;
			count++;
			base *= 10;
			start *= 10;
		}
		
		start += (n-1)/count;//find which number at that digits
		String s = Integer.toString(start);
		return s.charAt((n-1)%count)-'0';//find the digit at that number and return
    }
}
