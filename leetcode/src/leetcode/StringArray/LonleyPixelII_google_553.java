package leetcode.StringArray;

import java.util.HashMap;
import java.util.Map;

public class LonleyPixelII_google_553 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findBlackPixel(char[][] picture, int N) {
		//boundary input
		if(picture.length==0 || picture[0].length==0) return 0;
		//save the row signature to hash, save the col count into array
		int m= picture.length, n=picture[0].length;
		Map<String, Integer> map = new HashMap<>();
		int [] colCount = new int [n]; 
		
		for(int i=0;i<m;i++){
			StringBuilder sb = new StringBuilder();
			//rowCount
			int rowCount = 0;
			for(int j=0;j<n;j++){
				sb.append(picture[i][j]);
				if(picture[i][j] == 'B') {
					colCount[j]++;
					rowCount++;
				}
			}
			if(rowCount!=N) continue;
			String s = sb.toString();
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		//get res
		int colNum = 0;
		for(String s:map.keySet()){
			//row candidates
			if(map.get(s) == N){
				for(int i=0;i<s.length();i++){
					//col candidates
					if(s.charAt(i) == 'B' && colCount[i] == N) 
						colNum++;
				}
			}
		}
		
		return colNum*N;
    }
}
