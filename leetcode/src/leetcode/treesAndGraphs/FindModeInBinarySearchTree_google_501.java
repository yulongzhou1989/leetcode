package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import common.TreeNode;

public class FindModeInBinarySearchTree_google_501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
		//System.out.println(Arrays.toString(findMode(t1)));
	}

/*	static int max=0;
    static Map<Integer, Integer> map;
    static List<Integer> list;
*/
    //On space, on time
//    public static int[] findMode(TreeNode root) {
//        //in order search
//        map = new HashMap<Integer, Integer>();
//        list = new ArrayList<Integer>();
//        inOrder(root);
//        int [] res = new int [list.size()];
//        for(int i=0;i<list.size();i++){
//            res[i] = list.get(i);
//        }
//        return res;
//    }
//    
//    static void inOrder(TreeNode root){
//        if (root == null) return;
//        if (root.left!=null) inOrder(root.left);
//        if(!map.containsKey(root.val)){
//            map.put(root.val, 1);
//        }else {
//            map.put(root.val, map.get(root.val)+1);
//        }
//        if (max==map.get(root.val)) list.add(root.val);
//        else if (max<map.get(root.val)){
//            list.clear();
//            list.add(root.val);
//            max = map.get(root.val);
//        }
//        if(root.right!=null) inOrder(root.right);
//    }
    
    int curCount = 0;
    int maxMode = 0;
    int curValue= 0;
    List<Integer> list;

    public int[] findMode(TreeNode root) {
        list = new ArrayList<Integer>();
        //in order search
        inOrder(root);
        int [] res = new int [list.size()];
<<<<<<< HEAD
        for(int i=0;i<list.size();i++){
        	res[i] = list.get(i);
        }
=======
        for(int i=0;i<list.size();i++) res[i] = list.get(i);
>>>>>>> 708b06d2eaa0621076dcacb014b6f71ce8f062a9
        return res;
    }
    
    void inOrder(TreeNode root){
        if (root == null) return;
        if (root.left!=null) inOrder(root.left);
        if (root.val==curValue) curCount++;
        else {
            curValue = root.val;
            curCount = 1;
        }
        if (maxMode==curCount) list.add(curValue);
        else if (maxMode<curCount){
            list.clear();
            list.add(root.val);
            maxMode = curCount;
        }
        if(root.right!=null) inOrder(root.right);
    }
    
    //O(1) space
    
}
