package contest;

import common.TreeNode;

public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) return true;
        if(s==null && t!=null) return false;
        
        if(s.val == t.val && checkSame(s,t)){
            return true;
        } else{
            return isSubtree(s.left, t)||isSubtree(s.right,t);
        }
    }
    
    public boolean checkSame(TreeNode a, TreeNode b){
        if((a!=null && b==null) ||(a==null && b!=null)) return false;
        if(a==null && b==null) return true;
        if(a.val!=b.val) return false;
        return checkSame(a.left, b.left) && checkSame(a.right, b.right);
    }

}
