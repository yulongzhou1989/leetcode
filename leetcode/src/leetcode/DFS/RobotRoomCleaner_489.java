package leetcode.DFS;

import java.util.HashSet;
import java.util.Set;

/*
 * For this question is a standard DFS question
 * before start a DFS first check if when can expend this node.
 * if we can, searching 4 directions and do dfs recursion and don't forget to 
 * recover the container object back to the orginal status.
 * 
 */
public class RobotRoomCleaner_489 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Robot {
		// Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
	    public boolean move() {return true;};
        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft() {};
		public void turnRight() {};
	     // Clean the current cell.
        public void clean() {};
	}
	
	public void cleanRoom(Robot robot) {
        helper(robot, 0, 0, 0, new HashSet<>());
    }

    final int [][] dirs = new int [][] {{1, 0},{0, 1},{-1, 0},{0, -1}};

    private void helper(Robot robot, int x, int y, int d, Set<String> set) {
        if (set.add(x + "," + y)) { // not visited yet
            robot.clean();
            for (int i = 0; i < 4; i++) {
                if (robot.move()) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];
                    helper(robot, nextX, nextY, d, set);
                    robot.turnLeft();
                    robot.turnLeft();//backward
                    robot.move();//baockward move
                    robot.turnRight();
                    robot.turnRight();//forward again    
                }
                robot.turnRight();
                d = (d + 1) % 4;
            }
        }
    }

}
