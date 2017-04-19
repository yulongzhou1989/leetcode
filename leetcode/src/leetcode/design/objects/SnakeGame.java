package leetcode.design.objects;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame {

	int[][] food;
	//row*width+column to save column and row position
	List<Integer> snake;
	int foodPos = 0;
	int height, width;
	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
	public SnakeGame(int width, int height, int[][] food) {
		this.height = height;
		this.width = width;
		this.food = food;
		snake = new ArrayList<>();
		snake.add(0);
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game
	 *         over when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		int[] d = new int[2];
		switch (direction) {
		case "U":
			d = dirs[1];
			break;
		case "L":
			d = dirs[3];
			break;
		case "R":
			d = dirs[2];
			break;
		case "D":
			d = dirs[0];
		}

		// new head position
		int head = snake.get(0);
		int newHeadR = head/width + d[0];
		int newHeadC = head%width + d[1];
		int newHead = newHeadR*width + newHeadC;

		// hit wall, die
		if (newHeadC >= width || newHeadC < 0 || newHeadR >= height || newHeadR < 0) {
			return -1;
		}
		
		// hit itself, die(new head is legal to be the tail)
		if (snake.contains(newHead) && snake.get(snake.size()-1) != newHead) {
			return -1;
		}
		
		// if food, eat.
		if (foodPos<food.length && food[foodPos][0] == newHeadR && food[foodPos][1] == newHeadC) {
			snake.add(0, newHead);
			// release new food
			foodPos++;
		} else {
			//no food move
			snake.add(0, newHead);
			snake.remove(snake.size() - 1);
		}
		
		//length is the snake size except the snake head
		return snake.size() - 1;
	}
}