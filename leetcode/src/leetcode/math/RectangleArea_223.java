package leetcode.math;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleArea_223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(computeArea(-2,-2,2,2,-2,-2,2,2));
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//cal total area with overlap
		int area = Math.abs(D-B)*Math.abs(C-A)+Math.abs(H-F)*Math.abs(G-E);
		// check if no intersection
		if(E>=C || G<=A || D<=F || B>=H) return area;
		//get Redundent area, choose smaller points
		int rAreaLength = Math.abs((C<G?C:G)-(E>A?E:A));
		int rAreaHeight = Math.abs((D<H?D:H)-(B>F?B:F));
				
		return area - rAreaHeight*rAreaLength;
    }
}
