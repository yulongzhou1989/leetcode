package leetcode;

import java.util.ArrayList;
import java.util.List;

import common.Codec;

public class Google_EncodeAndDecodeStrings_271 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec codec = new Codec();
		List<String> ls = new ArrayList<String>();
		ls.add("fewawf1// / ");
		//ls.add(" / /rere/r\\e");
		
		System.out.println(codec.decode(codec.encode(ls)));
	}

}
