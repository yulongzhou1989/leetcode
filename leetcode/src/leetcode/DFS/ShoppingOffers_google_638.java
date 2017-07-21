package leetcode.DFS;

import java.util.List;

public class ShoppingOffers_google_638 {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(needs.size()==0) return 0;
        return helper(price, special, needs);
    }
    
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int res = Integer.MAX_VALUE;
        //apply each offer
        for(int i=0;i<special.size();i++){
            boolean invalid = false;
            for(int j=0;j<special.get(i).size()-1;j++){
                int remain = needs.get(j) - special.get(i).get(j);
                needs.set(j, remain);
                if(remain<0) invalid = true;
            }
            if(!invalid){
                res = Math.min(res, helper(price, special, needs) + special.get(i).get(needs.size()));
            }
            //reset 
            for(int j=0;j<special.get(i).size()-1;j++){
                needs.set(j, needs.get(j)+special.get(i).get(j));
            }
        }
        int sum = 0;
        //cal non discount price
        for(int i=0;i<needs.size();i++){
            sum += price.get(i) * needs.get(i);
        }
        
        return Math.min(res, sum);
    }
}
