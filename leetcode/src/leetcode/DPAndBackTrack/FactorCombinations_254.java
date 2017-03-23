package leetcode.DPAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_254 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(String.valueOf(getFactors(12)));
	}

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        helper(resList, new ArrayList<Integer>(), n,2);
        return resList;
    }
    
    private void helper(List<List<Integer>> resList, List<Integer> tempList, int n, int pos){
        if(n==1 && tempList.size()>1) resList.add(new ArrayList<Integer>(tempList));
        for(int i=pos;i<=n;i++){
            if(n%i==0) {
                tempList.add(i);
                helper(resList, tempList,n/i, i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
