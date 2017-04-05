package leetcode.StringArray;

public class getModifiedArray_google_370 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] getModifiedArray(int length, int[][] updates) {
        //set the start value, end+1, -value;
        int [] res = new int [length];
        for(int i=0;i<updates.length;i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            res[start] += val;
            if(end<length-1){
                res[end+1] -= val;
            }
        }
        
        //sum += res[i];
        int sum=0;
        for(int i=0;i<res.length;i++){
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
    }
}
