package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

import common.NestedInteger;

public class NestedListWeightSumII_364 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		//re-save the unweighted count each deepth
		int weighted = 0;
		int unWeighted = 0;
		while(nestedList.size()>0){
			//temp save next level
			List<NestedInteger> nextLevel = new ArrayList<>();
			for(NestedInteger ni: nestedList){
				if(ni.isInteger()){
					unWeighted += ni.getInteger();
				}else{
					nextLevel.addAll(ni.getList());
				}
			}
			
			weighted += unWeighted;
			nestedList = nextLevel;
		}
		
		return weighted;
    }

}
