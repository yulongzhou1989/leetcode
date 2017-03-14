package leetcode.StringArray;

public class ValidWordAbbreviation_google_408 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validWordAbbreviation("abbreviation",
				"a10n"));
	}

    public static boolean validWordAbbreviation(String word, String abbr) {
        for(int i=0;i<abbr.length();){
           if (word.length() == 0) return false;
           //if is number, remove number length
           String num = "";
           if (abbr.charAt(i)>'0' && abbr.charAt(i)<='9' ){
               while(i<abbr.length() && abbr.charAt(i)>='0' && abbr.charAt(i)<='9'){
                   num += abbr.charAt(i++);
               }
               if (Integer.valueOf(num)>word.length()) return false;
               word = word.substring(Integer.valueOf(num));
           }
           else {
           	if (word.charAt(0)!=abbr.charAt(i++)) return false;
               word = word.substring(1);
           }
       }
       
       if (word.length() == 0) return true;
       else return false;
   }
}
