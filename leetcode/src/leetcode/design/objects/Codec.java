package leetcode.design.objects;

import java.util.ArrayList;
import java.util.List;

public class Codec {
	
	List<String> list = new ArrayList<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(list.contains(longUrl)) return String.valueOf(list.indexOf(longUrl));
        list.add(longUrl);
		return String.valueOf(list.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
       int index = Integer.valueOf(shortUrl);
	   return index<list.size()?list.get(index):"";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
