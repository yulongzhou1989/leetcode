package leetcode.design;

import java.util.HashMap;

public class LRCCache_google_146 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class LRUCache {

	    class Node {
			public int val;
			public int key;
			public Node pre;
			public Node next;
			
			public Node(){

			}
			
			public Node(int key, int val){
			    this.key = key;
			    this.val = val;
			}
		}
		
		HashMap<Integer, Node> map;
		Node head;
		Node tail;
		int count;
		int capacity;
		
		//make a double link list to quick sort
	    public LRUCache(int capacity) {
			count = 0;
			this.capacity = capacity;
			head = new Node();
			tail = new Node();
			head.next = tail;
			head.pre = null;
			tail.pre = head;
			tail.next = null;
			map = new HashMap<>();
	    }
	    
	    public int get(int key) {
	        if(!map.containsKey(key)){
				return -1;
			} else{
				Node node = map.get(key);
				int res = node.val;
				remove(node);
				addHead(node);
				return res;
			}
	    }
	    
	    public void put(int key, int value) {
			if(!map.containsKey(key)){//add new node
				if(count==capacity){//reach capacity, remove node at tail
					map.remove(tail.pre.key);
					remove(tail.pre);
					count--;
				}
				Node node = new Node(key, value);
				addHead(node);
				map.put(key, node);
				count++;
			}else{//update node value and move it to head
				Node node = map.get(key);
				node.val = value;
				remove(node);
				addHead(node);
			}
	    }
		
		private void addHead(Node node){
			node.next = head.next;
			head.next.pre = node;
			node.pre = head;
			head.next = node;
		}
		
		private void remove(Node node){
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */

}
