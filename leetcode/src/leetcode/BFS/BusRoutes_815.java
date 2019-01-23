package leetcode.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * This question is BFS since it is about min distance.
 * The abnormal piece is usually visited is storing the visiting node, but
 * for this question. It is storing the relation node --- the bus, not the stop
 * Don't forget the use the q size to know different deepth.
 * 
 */
public class BusRoutes_815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//[[1,2,7],[3,6,7]]
    //1
    //6
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>(); // stops belong to which bus
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new HashSet<>());
                map.get(routes[i][j]).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        Set<Integer> visited = new HashSet<>(); // check if the bus has been visited
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                Set<Integer> set = map.get(stop);
                for (Integer bus : set) {
                    if (visited.add(bus)) {
                        for (int nextStop : routes[bus]) {
                            if (nextStop == T) {
                                return count;
                            } else {
                                queue.offer(nextStop);
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}
