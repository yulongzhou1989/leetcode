
package leetcode.StringArray;

public class LonelyPixelI_google_531 {
	
	public static void main(String [] args){
		char [][] pics = {{'W','W','B'},{'W','B','W'},{'B','B','W'}};
		System.out.println(findLonelyPixel(pics));
	}

	public static int findLonelyPixel(char[][] picture) {
        if (picture.length == 0) return 0;
        
        int [] row = new int [picture.length];
        int [] col = new int [picture[0].length];
        for (int i=0; i<picture.length;i++){
            for (int j=0;j<picture[i].length;j++){
                if (picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        int counter = 0;
        for (int i=0; i<row.length;i++){
            for (int j=0; j<col.length;j++){
                if (row[i] == 1 && col[j] == 1 && picture[i][j]=='B' ) counter++;
            }
        }
        
        return counter;
    }
	
	//not a solution for this question
	public int findLonelyPixel1(char[][] picture) {
        int count = 0;
        for (int i=0;i<picture.length;i++){
            for (int j=0;j<picture[i].length;j++){
                if (picture[i][j] == 'B'){
                    if ((i==0 || i>0 && picture [i-1][j]!='B') && (i==picture.length-1 || i<picture.length-1 && picture[i+1][j]!='B')
                    && ((j==0 || j>0 && picture [i][j-1]!='B') && (j==picture[i].length-1 || j<picture[i].length-1 && picture[i][j+1]!='B')))
                        count++;
                }            
            }
        }
        
        return count;
    }
}
