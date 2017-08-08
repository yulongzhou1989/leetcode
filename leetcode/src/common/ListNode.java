package common;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode (int x) {val = x;}
	
	public static ListNode fromArray(int [] arr){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for(int v : arr){
			cur.next = new ListNode(v);
			cur = cur.next;
		}
		return dummy.next;
	}
	
	@Override
	public String toString(){
		String res = "";
		ListNode cur = this;
		while(cur != null){
			res += cur.val + ",";
			cur = cur.next;
		}
		return res;
	}
}
