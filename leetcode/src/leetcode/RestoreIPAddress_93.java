package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_93 {

	public static void main(String [] args){
		System.out.println(restoreIpAddresses1("010010"));
	}
	
	public static List<String> restoreIpAddresses(String s) {	
		List<String> ret = new ArrayList<String>();
		restoreIpDFS(ret,"",s, 0, 0);
		return ret;
    }	
	
	public static List<String> restoreIpAddresses1(String s){
		List<String> ret = new ArrayList<String>();
		for(int i=1;i<4; i++){
			for (int j= i+1; j<4+i; j++){
				for (int k= j+1; k<j+4 && k<s.length(); k++){
					String first = s.substring(0, i);
					String second = s.substring(i, j);
					String third = s.substring(j, k);
					String fourth = s.substring(k);
					if (isValidate(first) && isValidate(second) && isValidate(third) && isValidate(fourth)){
						ret.add(first+"."+second+"."+third+"."+fourth);
					}
				}
			}
		}
		
		return ret;
	}
	
	public static boolean isValidate(String s){
		if (s.charAt(0) - '0' == 0 && s.length()>1 || s.length()>3 || Integer.valueOf(s)>255){
			return false;
		}
		return true;
	}
	
	public static void restoreIpDFS(List<String> ret, String restore, String s, int idx, int count){
		if (count>4) return;
		if (count == 4 && idx == s.length()){
			ret.add(restore);
		}
		for(int i=1;i<4;i++){
			if (idx+i>s.length()) break;
			String currentNumStr = s.substring(idx,idx+i);
			if (currentNumStr.charAt(0)-'0' == 0 && currentNumStr.length()>1 ||
					i==3 && Integer.valueOf(currentNumStr)>255) continue;
			restoreIpDFS(ret, restore+currentNumStr + (count==3?"":"."), s, idx+i, count+1);
		}
	}
	
	public static void getIpAddressList(List<String> r, List<Integer> tempList, String s, int leftNum){
		if (leftNum == 1){
			if (s.length()>3) return;
			else {
				int lastNum = Integer.valueOf(s);
				if (lastNum>255) return;
				else if ((lastNum>0 && s.charAt(0) - '0' == 0) || (lastNum == 0 && s.length()>1)) return;
				else {
					tempList.add(lastNum);
					StringBuilder sb = new StringBuilder();
					for(Integer i:tempList){
						sb.append(i).append(".");
					}
					sb.deleteCharAt(sb.length()-1);
					r.add(String.valueOf(sb));
					tempList.remove(tempList.size()-1);
				}
			}
		}
		else {
			for (int i=1;i<s.length() && i<=3;i++){
				if (s.charAt(0) - '0' == 0 && i>1) continue;
				Integer currentNum = Integer.valueOf(s.substring(0,i));
				if (currentNum>255) continue;
				tempList.add(currentNum);
				getIpAddressList(r, tempList, s.substring(i), leftNum-1);
				tempList.remove(tempList.size()-1);
			}	
		}
	}
}
