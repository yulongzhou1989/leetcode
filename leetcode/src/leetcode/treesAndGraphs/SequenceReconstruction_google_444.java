package leetcode.treesAndGraphs;

import java.util.List;

import common.util;

public class SequenceReconstruction_google_444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> seqs = util.stringToArrayList("[1,2],[1,3],[2,3]");
		int [] org = new int [] {1,2,3};
		System.out.println(sequenceReconstruction(org, seqs));
	}
	
	public static boolean sequenceReconstruction(int [] org, List<List<Integer>> seqs){
		if(seqs == null || seqs.size()==0) return false;
		
		int orgLen = org.length;
		int [] idx = new int [orgLen+1];
		boolean [] pairs = new boolean[orgLen];
		
		for(int i=0;i<orgLen;i++){
			idx[org[i]] = i;
		}
		int emptySize = 0;
		//Every sequence in seqs should be a subsequence in org. This part is obvious.
		//Every 2 CONSECUTIVE elements in org should be consecutive elements in some sequence from seqs. 
		for(List<Integer> seq: seqs){
			if(seq.isEmpty()) emptySize++;
			for(int i=0;i<seq.size();i++){
				if(seq.get(i)>orgLen || seq.get(i)<0) return false;
				if(i>0 && idx[seq.get(i-1)]>=idx[seq.get(i)]) return false;
				if(i>0 && idx[seq.get(i-1)] +1 == idx[seq.get(i)]) pairs[idx[seq.get(i-1)]] = true;
			}
		}
		
		if(emptySize==seqs.size()) return false;
		
		for(int i=0;i<orgLen-1;i++){
			if(!pairs[i]) return false;
		}
		
		return true;
	}

}
