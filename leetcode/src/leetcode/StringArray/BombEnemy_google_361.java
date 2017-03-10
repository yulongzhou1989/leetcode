package leetcode.StringArray;

public class BombEnemy_google_361 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxKilledEnemies1(char[][] grid) {
        int eMaxNums = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if (grid[i][j] == '0'){
                    int count = 0;
                    //cal row Es, right
                    for(int m=j;m<grid[i].length;m++){
                        if (grid[i][m] == 'W') break;
                        if (grid[i][m] == 'E') count++;
                    }
                    //cal row Es, left
                    for(int n=j;n>=0;n--){
                        if (grid[i][n] == 'W') break;
                        if (grid[i][n] == 'E') count++;
                    }
                    //cal col Es, down
                    for(int p=i;p<grid.length;p++){
                        if (grid[p][j] == 'W') break;
                        if (grid[p][j] == 'E') count++;
                    }
                    //cal col Es, up
                    for(int q=i;q>=0;q--){
                        if (grid[q][j] == 'W') break;
                        if (grid[q][j] == 'E') count++;
                    }
                    //getMax
                    eMaxNums = Math.max(eMaxNums, count);
                }
            }
        }
        
        return eMaxNums;
    }

	public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) return 0;
        int eMaxNums = 0;
        int rowHit = 0;
        int [] colHit = new int [grid[0].length];
        
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
            	//remember each row sperate by WALL
                if (j==0 || grid[i][j-1]=='W'){
                    rowHit=0;
                    for(int m=j;m<grid[i].length;m++){
                        if (grid[i][m] == 'W') break;
                        if (grid[i][m] == 'E') rowHit++;
                    }
                }
                
                if (i==0 || grid[i-1][j]=='W'){
                    colHit[j]=0;
                    for(int p=i;p<grid.length;p++){
                        if (grid[p][j] == 'W') break;
                        if (grid[p][j] == 'E') colHit[j]++;
                    }
                }
                if(grid[i][j] == '0'){
                    //getMax
                    eMaxNums = Math.max(eMaxNums, rowHit+colHit[j]);
                }
            }
        }
        
        return eMaxNums;
    }
}
