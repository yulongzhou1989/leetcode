package leetcode.DPAndBackTrack;

import java.util.Arrays;

public class MaximalRectangle_85 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximalRectangle(char[][] matrix) {
        //left max, right min which can make an rectengle 
        //left(i,j) = max(left(i,j), currentLeft);
    	//right(i,j) = min(right(i,j), currentRight);
    	//height(i) = matrix[i]==1?height(i)+1:0;
    	
    	if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int [] left = new int [n];
    	int [] right = new int [n];
    	int [] height = new int [n];
    	int area=0;
    	Arrays.fill(right,n);
    	for(int i=0;i<m;i++){
    		int currentLeft=0, currentRight=n;
    		//left
    		for(int j=0; j<n; j++){
    			if(matrix[i][j]=='1'){
    				left[j] = Math.max(currentLeft, left[j]);
    			}else{
    				currentLeft = j+1;
    				left[j]=0;
    			}
    		}
    		//right
    		for(int j=n-1; j>=0; j--){
    			if(matrix[i][j]=='1'){
    				right[j] = Math.min(currentRight, right[j]);
    			}else{
    				currentRight = j;
    				right[j] = n;
    			}
    		}
    		//height;
    		for(int j=0;j<n;j++){
    			if(matrix[i][j]=='1') height[j]++;
    			else height[j] = 0;
    		}
    		//area
    		for(int j=0;j<n;j++){
    			area = Math.max((right[j]-left[j])*height[j], area);
    		}
    	}	
    	
    	return area;
    }
}
