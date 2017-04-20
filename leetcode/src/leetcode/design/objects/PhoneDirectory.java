package leetcode.design.objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PhoneDirectory {
	List<Integer> list;
    HashSet<Integer> set;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        list = new ArrayList<>();
        set = new HashSet<>();
        for(int i=0;i<maxNumbers;i++){
            list.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(list.size()>0) {
            int res = list.get(0);
            list.remove(0);
            set.add(res);
            return res;
        }
        else return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(set.contains(number)) return false;
        else return true;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(set.remove(number)) {
            list.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
