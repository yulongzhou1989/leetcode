package leetcode.design;

import java.util.List;

public class DesignExcelSumFormula_631 {
	public class Excel {
		
		public class Formula{
			int topLeft;
			int topRight;
			int bottomLeft;
			int bottomRight;
			int r;
			
			public Formula(int topLeft, int topRight, int bottomLeft, int bottomRight, int r){
				this.topLeft = topLeft;
				this.topRight = topRight;
				this.bottomLeft = bottomLeft;
				this.bottomRight = bottomRight;
				this.r = r;
			}
		}
		
		List<Formula> formulaList;
		int [][] sheet;

	    public Excel(int H, char W) {
	        sheet = new int [H][W];
	    }
	    
	    public void set(int r, char c, int v) {
	        
	    }
	    
	    public int get(int r, char c) {
	        
	    }
	    
	    public int sum(int r, char c, String[] strs) {
	        
	    }
		
	}
}
