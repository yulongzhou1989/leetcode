package contest;

public class SubmissionDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLUSlength(String a, String b) {
        if(!a.equals(b)) return a.length()>b.length()?a.length():b.length();
        else return -1;
    }
}
