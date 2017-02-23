package leetcode.StringArray;

public class ReverseVowelsOfAString_google_345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels("hello"));
	}
	
	public static String reverseVowels(String s) {
        if (s.length()<1) return s;
        
        char [] sarr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        
        for (int i=0,j=sarr.length-1; i<j;i++,j--){
            while (i<j && vowels.indexOf(sarr[i])==-1) i++;
            while (i<j && vowels.indexOf(sarr[j])==-1) j--;
            
            char temp = sarr[i];
            sarr[j] = sarr[i];
            sarr[i] = temp;
        }
        
        return new String(sarr);
    }
	
//	public static String reverseVowels(String s) {
//        
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        String vowels = "aeiouAEIOU";
//        Character c1 = null,c2 = null;
//        
//        for (int i=0,j=s.length()-1;i<=j;){
//            if(vowels.indexOf(s.charAt(i))==-1){
//                sb1.append(s.charAt(i));
//                i++;  
//            } else {
//                if (c2!=null){
//                    sb1.append(c2);
//                    j++;
//                    c2 = null;
//                }
//                c1 = s.charAt(i);
//                i++;
//            }
//            if(vowels.indexOf(s.charAt(j))==-1){
//            	sb2.append(s.charAt(j));
//            	j++;
//            } 
//            else {
//                if (c1!=null){
//                    sb2.append(c1);
//                    i++;
//                    c1 = null;
//                }
//                c1 = s.charAt(j);
//                j++;
//            }
//        }
//        
//        return sb1.append(sb2.reverse()).toString();
//    }

}
