package leetcode.binarytree;

import java.util.HashMap;

import common.TreeNode;

public class MostFrequentSubtreeSum_508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	HashMap<Integer, Integer> counts;//val->sum, freq->counts
    int mostFreq = 0;
    int freqSize = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        counts = new HashMap<>();
        dfs(root);
        int i=0;
        int [] res = new int [freqSize];
        for(Integer key: counts.keySet()){
            if(counts.get(key)==mostFreq) 
                res[i++] = key;
        }
        
        return res;
    }
    
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int sum = left+right+root.val;
        int count = counts.getOrDefault(sum, 0)+1;
        counts.put(sum, count);
        if(mostFreq == count)
            freqSize++;
        else if(mostFreq<count){
            freqSize = 1;
            mostFreq = count;
        }
        
        return sum;
    }

}
