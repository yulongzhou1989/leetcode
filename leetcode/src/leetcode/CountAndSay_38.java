package leetcode;

public class CountAndSay_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(6));
	}

	public static String countAndSay(int n) {
		
		String currentStr = "1";
		
		for (int i=0;i<n-1;i++){
			StringBuilder sb = new StringBuilder();
			int count = 1;
			char pre = currentStr.charAt(0);
			//build ith string
			for (int j=1;j<currentStr.length();j++){
				if(currentStr.charAt(j) == pre){
					count++;
				} else if (currentStr.charAt(j) != pre) {
					sb.append(count).append(pre);
					pre = currentStr.charAt(j);
					count = 1;
				}
			}
			sb.append(count).append(pre);
			
			currentStr = sb.toString();
		}
		
		return currentStr;
    }
}
