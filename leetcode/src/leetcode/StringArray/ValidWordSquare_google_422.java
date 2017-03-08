package leetcode.StringArray;

import java.util.List;

public class ValidWordSquare_google_422 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean validWordSquare(List<String> words) {
        for (int i=0;i<words.size();i++){
            for (int j=0;j<words.get(i).length();j++){
                if (j>=words.size() || i>=words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
