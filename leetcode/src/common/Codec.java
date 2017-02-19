package common;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder result = new StringBuilder();
    	for(String s:strs){
    		result.append(s.replace("/", "//")).append(" / ");
    	}
        return String.valueOf(result);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode1(String s) {
        List<String> result = new ArrayList<String> ();
        
        StringBuilder tempSb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) != '/' || i == s.length()-1){
        		tempSb.append(s.charAt(i));
        	}
        	else {
        		if (s.charAt(i+1) == '/'){
        			tempSb.append('/');
        			i++;
        		}
        		else{
        			result.add(String.valueOf(tempSb));
        			tempSb = new StringBuilder();
        		}
        	}
        }
        
        return result;
    }
    
    public List<String> decode(String s) {
//        List<String> strs = new ArrayList<String>();
//        String[] array = s.split(" / ", -1);
//        for (int i=0; i<array.length-1; ++i)
//            strs.add(array[i].replace("//", "/"));
//        return strs;
    	 List<String> l = new ArrayList<String>();
         String [] arr = s.split(" / ", -1);
         for(String str:arr){
             l.add(str.replace("//","/"));
         }
         l.remove(l.size()-1);
         return l;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));