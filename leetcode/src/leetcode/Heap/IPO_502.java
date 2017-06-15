package leetcode.Heap;

import java.util.PriorityQueue;

public class IPO_502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Pair{
		int profit;
		int capital;
		
		public Pair(){
			
		}
		
		public Pair(int profit, int capital){
			this.profit = profit;
			this.capital = capital;
		}
	}
	
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		if(k==0 || Profits.length==0 || Capital.length==0) return W;
        //use 2 priority queue, one for profits, one for capital
		int n = Profits.length;
		
		PriorityQueue<Pair> profQ = new PriorityQueue<>(n, (a, b)->(b.profit-a.profit));
		PriorityQueue<Pair> capQ = new PriorityQueue<>(n, (a,b)->(a.capital-b.capital));
		
		for(int i=0;i<k;i++){
			while(!capQ.isEmpty() && capQ.peek().capital<=W){
				profQ.add(capQ.poll());
			}
			
			if(profQ.isEmpty()) break;
			
			if(profQ.size()>0){
				W+=profQ.poll().profit;
			}
		}
		
		return W;
    }

}
