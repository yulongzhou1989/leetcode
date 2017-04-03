	package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight_406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println(Arrays.deepToString(reconstructQueue(people)));
	}
	
	public static int[][] reconstructQueue(int[][] people) {
        //First sort by height desc, then sort by k
        Arrays.sort(people, new Comparator<int []>(){
           @Override 
           public int compare(int [] o1, int [] o2){
        	   return o1[0]!=o2[0]?o2[0]-o1[0]:o1[1]-o2[1];
           }
        });
        
        List<int []> res = new LinkedList<int []>();
        for(int [] p : people){
            res.add(p[1],p);
        }
        
        return res.toArray(new int [people.length][]);
    }

	/**
	 * Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
	 * For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
	 * E.g.
	 *input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	 *subarray after step 1: [[7,0], [7,1]]
	 *subarray after step 2: [[7,0], [6,1], [7,1]]
	 */
}
