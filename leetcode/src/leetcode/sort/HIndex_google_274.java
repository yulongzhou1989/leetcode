package leetcode.sort;

public class HIndex_google_274 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//bucket sort
    public int hIndex(int[] citations) {
        int [] bucket = new int [citations.length+1];
        
        for(int c:citations){
            if (c>=citations.length) bucket[citations.length]++;
            else bucket[c]++;
        }
        int count = 0;
        for (int i=bucket.length-1;i>=0;i--){
            count+=bucket[i];
            if(count>=i) return i;
        }
        
        return 0;
    }

}
