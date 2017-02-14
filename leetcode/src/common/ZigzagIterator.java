package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

	private Queue<Integer> v1, v2;
	private int currentPos;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = new LinkedList<Integer> (v1);
        this.v2 = new LinkedList<Integer> (v2);
        currentPos = v1.size() == 0?2:1;
    }

    public int next() {
    	if (currentPos == 1){
    		if (v2.size()>0) currentPos = 2;
    		return this.v1.remove();
    	}
    	else{
    		if (v1.size()>0) currentPos = 1;
    		return this.v2.remove();
    	}
    }

    public boolean hasNext() {
        if (v1.size() == 0 && v2.size() == 0) return false;
        return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

/*Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].*/