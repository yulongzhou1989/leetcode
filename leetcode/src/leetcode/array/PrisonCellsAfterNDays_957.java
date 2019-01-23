package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays_957 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Since it is has a pattern so we need to record the pattern using a 
	//hashmap. If it becomes a loop then 
	// we can decrease curN as curN % (preN - curN) preN - curN is how long
	// it will be back to the original status again.
	//If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied. Otherwise, it becomes vacant.
    //(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
    public int[] prisonAfterNDays(int[] cells, int N) {
          int [] res = new int [cells.length];
          Map<String, Integer> map = new HashMap<>();
          while (N > 0) { // because there may be a loop, so we can reduce the loop to reduce the time.
            map.put(Arrays.toString(cells), N--);
            for (int j = 0; j < cells.length; j++) {
                if (j == 0 || j == cells.length - 1) {
                    res[j] = 0;
                } else {
                    res[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
                }
            }
            cells = res.clone();
            if (map.containsKey(Arrays.toString(cells))) { // if we have recorded this pattern, we can skip LastOccurN - currentN (after t days becomes origin)
                N = N % (map.get(Arrays.toString(cells)) - N);
            }
          }

          return cells;
    }
}
