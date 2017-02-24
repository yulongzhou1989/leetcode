package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.Interval;

public class MergeIntervals_google_56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//The idea is that for the result distinct interval,
	// the latter ones' start should bigger than the previous one's end
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        int [] start = new int [intervals.size()];
        int [] end = new int [intervals.size()];
        
        for (int i =0;i<intervals.size();i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        for (int i=0,j=0;i<start.length;i++){
            if (i==start.length-1 || start[i+1]>end[i]){
                res.add(new Interval(start[j], end[i]));
                j = i+1;
            }
        }
        
        return res;
    }

}
