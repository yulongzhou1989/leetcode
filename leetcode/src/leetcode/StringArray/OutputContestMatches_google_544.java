package leetcode.StringArray;

import java.util.ArrayList;
import java.util.List;

public class OutputContestMatches_google_544 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String findContestMatch(int n) {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<n;i++){
            list.add(i+1+"");
        }
        while(list.size()!=1){
            List<String> temp = new ArrayList<String>();
            for(int i=0;i<list.size()/2;i++){
                temp.add("("+list.get(i)+","+list.get(list.size()-1-i)+")");
            }
            list = temp;
        }
        return list.get(0);
    }
}
