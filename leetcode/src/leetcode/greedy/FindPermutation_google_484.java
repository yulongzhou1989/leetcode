package leetcode.greedy;

public class FindPermutation_google_484 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findPermutation(String s) {
        int [] res = new int [s.length()+1];
        for (int i=0; i<res.length; i++){
            res[i] = i+1;
        }
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='D') {
                for (int j=i;j>=0;j--){
                    if (s.charAt(j) == 'D'){
                        swap(res,j,j+1); 
                    }else{
                        break;
                    }
                }
            }
        }
        
        return res;
    }
    
    void swap(int [] res, int a, int b){
        int temp = res[a];
        res[a] = res[b];
        res[b] = temp;
    }
}
