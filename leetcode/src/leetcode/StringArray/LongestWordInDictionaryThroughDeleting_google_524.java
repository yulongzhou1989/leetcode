package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting_google_524 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("jpthiudqzzeugzwwsngebdeai");
		System.out.println(findLongestWord("wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi", list));
	}
	
	public static String findLongestWord(String s, List<String> d) {
		if(s==null || s.length()==0) return "";
		String res = "";

        for(String word:d){
			if(word.length()>s.length()) return "";
			int i=0, j=0;
			while(i<word.length() && j<s.length()){
				while(j<s.length()){
					if(word.charAt(i)!=s.charAt(j)){
						j++;
					}else {
						i++;
						j++;
						break;
					}
				}
			}			
			if(i==word.length()&&j<=s.length()){
				if(res.length()<word.length()) res = word;
				else if(res.length()==word.length() && word.compareTo(res)<0) res = word; 
			} 
		}
		
		return res;
    }

}
