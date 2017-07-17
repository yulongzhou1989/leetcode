package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import common.Interval;

public class InsertInterval_57 {
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> list = new ArrayList<>();
		//add intervals before newInterval start
		int i=0, n=intervals.size();
		while(i<n && intervals.get(i).end<newInterval.start){
			list.add(intervals.get(i++));
		}
		//merge
		while(i<n && intervals.get(i).start<=newInterval.end){
			newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
									   Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		list.add(newInterval);
		//add tail
		while(i<n){
			list.add(intervals.get(i++));
		}
		
		return list;
    }
}
