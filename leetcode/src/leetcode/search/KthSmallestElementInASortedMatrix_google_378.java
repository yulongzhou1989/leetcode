package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInASortedMatrix_google_378 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		System.out.println(kthSmallest(matrix, 5));
	}
	
	public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || k==0) return 0;
        //int [] res = new int [matrix.length*matrix[0].length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                int insertIndex = binarySearch(list, matrix[i][j]);
                insertIndex = insertIndex>=0?insertIndex:-(insertIndex+1);
                list.add(insertIndex, matrix[i][j]);
            }
        }
        return list.get(k-1);
    }
    
    public int binarySearch(List<Integer> list, int num){
        int high = list.size()-1;
        int low = 0;
        while(low<=high){
            int middle = (high+low)/2;
            if (list.get(middle) == num) return middle;
            if (list.get(middle) < num) low = middle+1;
            if (list.get(middle) > num) high = middle-1;
        }
        return -low-1;
    }

}
