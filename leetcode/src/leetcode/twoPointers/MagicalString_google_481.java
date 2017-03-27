package leetcode.twoPointers;

public class MagicalString_google_481 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int magicalString(int n) {
        if (n==0) return 0;
        else if (n<=3) return 1;
        int [] res = new int [n+1];
        res[0] = 1;
        res[1] = 2;
        res[2] = 2;
        int head = 2, tail = 3, num = 1, result = 1;
        //head is the lower speed pointer, and the tail is the faster pointer
        while(tail<n){
            for(int i=0;i<res[head];i++){
                res[tail] = num;
                if(num==1 && tail<n) result++;
                tail++;
            }
            num = num^3;
            head++;
        }
        return result;
    }
}
