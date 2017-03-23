package leetcode.bitManipulation;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProductOfWordLengths_google_318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxProduct(String[] words) {
        if(words.length==0) return 0;
        int max = 0;
        int [] value = new int [words.length];
        
        //26 letters which is less than 31 bit length, one letter in one position
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                value[i] |= 1<<(words[i].charAt(j)-'a');   
            }
        }
        //if value[i]&value[j] == 0, means totally different
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if ((value[i]&value[j])==0 && words[i].length()*words[j].length()>max){
                    max = words[i].length()*words[j].length();
                }
            }
        }
        
        return max;
    }
}
