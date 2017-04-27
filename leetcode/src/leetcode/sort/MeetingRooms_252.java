package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

import common.Interval;

public class MeetingRooms_252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals==null || intervals.length<2) return true;
		//sort the array by start time asc
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b){
				return a.start == b.start?a.end-b.end:a.start-b.start;
			}
		});
		//iterate intervals and check overlap
		for(int i=1;i<intervals.length;i++){
			if(intervals[i].start<intervals[i-1].end) return false;
		}
		
		return true;
    }
}
