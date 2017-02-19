package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidWordAbbr {
	
	private Map<String, List<String>> dic;
	
	public ValidWordAbbr(String[] dictionary) {
        dic = new HashMap<String, List<String>> ();
        for(String s: dictionary){
        	String key = makeKey(s);
        	if (dic.get(key) == null){
        		List<String> ls = new ArrayList<String>();
        		ls.add(s);
        		dic.put(key, ls);
        	}
        	else {
        		if (!dic.get(key).contains(s))
        			dic.get(key).add(s);
        	}
        }
    }
    
    public boolean isUnique(String word) {
    	String key = makeKey(word);
    	if (dic.get(key)==null || (dic.get(key)!=null && dic.get(key).size() == 1 && dic.get(key).get(0).equals(word)))
    		return true;
    	else 
    		return false;
    }

    private String makeKey(String s){
    	String key = "";
    	if (s.length() <=2)
    		key = s;
    	else{
    		key = s.charAt(0)+""+(s.length()-2)+""+s.charAt(s.length()-1);
    	}
    	return key;
    }
    
    /**
     * Your ValidWordAbbr object will be instantiated and called as such:
     * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
     * boolean param_1 = obj.isUnique(word);
     */
}
