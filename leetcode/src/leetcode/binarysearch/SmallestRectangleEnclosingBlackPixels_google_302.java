package leetcode.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestRectangleEnclosingBlackPixels_google_302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(mlogm)
	public int minArea(char[][] image, int x, int y) {
		if(image==null || image.length==0 || image[0].length==0) return 0;
		int m = image.length;
		int n = image[0].length;
		int left = getBoundary(0, x, image, false, true);
		int right = getBoundary(x, image.length-1, image, false, false);
		int up = getBoundary(0, y, image, true, true);
		int down = getBoundary(y, image[0].length-1, image, true, false);
		
		return (right-left+1)*(down-up+1);
	}
	//0->mid/mid->high
	private int getBoundary(int min, int max, char [][] image, boolean vertical, boolean goLower){
		int l = min;
		int h = max;
		while(l<h){
			int mid = goLower?(l+(h-l)/2):(l+(h-l+1)/2);
			if(goLower){
				if(!hasBlack(mid, image, vertical)){
					l = mid+1;
				}else{
					h = mid;
				}
			} else {
				if(!hasBlack(mid, image, vertical)){
					h = mid-1;
				}else{
					l = mid;
				}
			}
		}
		return l;
	}
	
	//low, high, column/row #, vertical/horizontal 
	private boolean hasBlack(int mid, char [][] image, boolean vertical){
		int m = image.length;
		int n = image[0].length;
		for(int i=0;i<(vertical?m:n);i++){//scan row/column 
			if(!vertical && image[mid][i]=='1')
				return true;
			if(vertical && image[i][mid] == '1')
				return true;
		}
		
		return false;
	}
	
	//BFS TLE->O(K) K->PIXAL size
	//test case: test, empty/null string
	int [][] dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
	int minU, maxD, minL, maxR;
	public int minArea1(char[][] image, int x, int y) {
		if(image==null || image.length==0 || image[0].length==0) return 0;
		int m = image.length;
		int n = image[0].length;
		//dfs, find the max boundary of black
		Queue<int []> queue = new LinkedList<>();
		minU = m;
		maxD = 0;
		minL = n;
		maxR = 0;
		
		queue.offer(new int [] {x, y});
		
		while(!queue.isEmpty()){
			int [] pos = queue.poll();
			updateRecords(pos);
			//System.out.println("pos:"+pos[0] +"," +pos[1]);
			image[pos[0]][pos[1]] = 0;
			//search 4 dirctions
			for(int i=0;i<4;i++){
				int newX = pos[0] + dirs[i][0];
				int newY = pos[1] + dirs[i][1];
				if(newX>=0 && newX<m && newY>=0 && newY<n && image[newX][newY] == '1'){
				    queue.offer(new int [] {newX, newY});
				}
			}
		}

		return (maxR-minL+1)*(maxD-minU+1);
    }
	
	private void updateRecords(int [] pos){
		minU = Math.min(pos[0], minU);
		minL = Math.min(pos[1], minL);
		maxD = Math.max(pos[0], maxD);
		maxR = Math.max(pos[1], maxR);
	}

}
