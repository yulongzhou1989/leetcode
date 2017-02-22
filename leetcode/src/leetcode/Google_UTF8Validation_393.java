package leetcode;

public class Google_UTF8Validation_393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {248, 130, 130,130}; 
		System.out.println(validUtf8(num));
	}

	public static boolean validUtf8(int[] data) {
		//192:11000000,224:11100000, 240:11110000,128:10000000
        int bytes = 0;
        for(int n:data){
        	if (n>=248)
        		return false;
        	else if(n>=240){
                if (bytes!=0) return false;
                else bytes = 3;
            } else if(n>=224){
                if (bytes!=0) return false;
                else bytes = 2;
            } else if(n>=192){
                if (bytes!=0) return false;
                else bytes = 1;
            } else if(n>=128){
                bytes--;
                if (bytes<0) return false;
            } else if(n<128 && bytes!=0){
                return false;
            }
        }
        
        return bytes == 0;
    }
}
