package contest;

public class SquirrelSimulation_573 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        if(height==0 && width==0) return 0;
        
        int dis=0;
        int minDis=0;
        
        //cal all distance
        for(int i=0;i<nuts.length;i++){
            int n2t = calDis(nuts[i], tree);
            dis += n2t*2;
        }
         
        minDis = dis-calDis(nuts[0], tree)+calDis(nuts[0], squirrel);
        
        //find a min replacement
        for(int i=1;i<nuts.length;i++){
            int newDis = dis-calDis(nuts[i], tree)+calDis(nuts[i], squirrel);
            minDis = minDis>newDis?newDis:minDis;
        }
    
        return minDis;
    }

    public int calDis(int [] a, int []b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
