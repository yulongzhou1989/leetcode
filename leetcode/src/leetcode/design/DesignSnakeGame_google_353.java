package leetcode.design;

import leetcode.design.objects.SnakeGame;

public class DesignSnakeGame_google_353 {


	//[[3,3,[[0,1],[0,2],[1,2],[2,2],[2,1],[2,0],[1,0]]],
	//["R"],["R"],["D"],["D"],["L"],["L"],["U"],["U"],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["R"],["U"],["L"],["D"]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] moves = {"R","R","D","D","L","L","U","U","R","R","D","D","L","L","U","R","U","L","D"};
		SnakeGame sg = new SnakeGame(3,3, new int [][] {{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}});
		for(String m: moves)
			System.out.println(sg.move(m));
	}

}
