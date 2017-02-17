package common;

import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder result = new StringBuilder();
    	for(String s:strs){
    		result.append(s.replace("/", "//"));
    	}
        return String.valueOf(result);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new List<String> ();
        
        StringBuilder tempSb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
        	
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));