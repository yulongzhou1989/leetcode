package leetcode.greedy;

import java.util.Arrays;

import common.Interval;

public class MeetingRoomsII_google_253 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minMeetingRooms(Interval[] intervals) {
        int [] start = new int [intervals.length];
        int [] end = new int [intervals.length];
        
        //get start and end arrays
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        //sort 2 arrays
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        for (int i=0,j=0;i<start.length;i++){
            if (start[i]<end[j]) rooms++;
            else j++;
        }
        
        return rooms;
    }
}
