package leetcode.linkedListAndQueueAndStack;

import java.util.HashMap;
import java.util.Map;

import common.RandomListNode;

public class CopyListWithRandomPointer_138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode n = head;
        while(n!=null){
            map.put(n,new RandomListNode(n.label));
            n = n.next;
        }
        
        n = head;
        while(n!=null){
            map.get(n).next = map.get(n.next);
            map.get(n).random = map.get(n.random);
            n = n.next;
        }
        
        return map.get(head);
    }
}
