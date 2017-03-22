package leetcode.design.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	Map<Integer,Integer> mapKey;
    Map<Integer,Integer> mapValue;
    int count=0;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        mapKey = new HashMap<Integer,Integer>();
        mapValue = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(mapKey.containsKey(val)) return false;
        else {
            mapKey.put(val,count);
            mapValue.put(count,val);
            count = mapKey.size();
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!mapKey.containsKey(val)) return false;
        else {
            int i = mapKey.get(val);
            mapKey.remove(val);
            //swap current to lastone
            if(i == mapValue.size()-1){
                mapValue.remove(i);
            } else{
                mapKey.put(mapValue.get(mapValue.size()-1),i);
                mapValue.put(i,mapValue.get(mapValue.size()-1));
                mapValue.remove(mapValue.size()-1);
            }
            count = mapKey.size();
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(mapValue.size());
        return mapValue.get(index);
    }
	
	//O(n) time
//	 List<Integer> list;
//
//	    /** Initialize your data structure here. */
//	    public RandomizedSet() {
//	        list = new ArrayList();
//	    }
//	    
//	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//	    public boolean insert(int val) {
//	        if(list.contains(val)) return false;
//	        else {
//	            list.add(val);
//	            return true;
//	        }
//	    }
//	    
//	    /** Removes a value from the set. Returns true if the set contained the specified element. */
//	    public boolean remove(int val) {
//	        if(!list.contains(val)) return false;
//	        else {
//	            list.remove(list.indexOf(val));
//	            return true;
//	        }
//	    }
//	    
//	    /** Get a random element from the set. */
//	    public int getRandom() {
//	        Random rand = new Random();
//	        int index = rand.nextInt(list.size());
//	        return list.get(index);
//	    }

}
