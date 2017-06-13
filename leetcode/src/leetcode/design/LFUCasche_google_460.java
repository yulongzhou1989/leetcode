package leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCasche_google_460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class LFUCache {

		//LinkedHashSet to save node in each level
		public class Node{
			public int freq;
			LinkedHashSet<Integer> linkedSet;
			Node pre;
			Node next;
			
			public Node(){
				this.freq = 0;
			}
			
			public Node(int freq){
				this.freq = freq;
				linkedSet = new LinkedHashSet<>();
				pre = next = null;
			}
		}
		
		Node head;
		int capacity;
		HashMap<Integer, Integer> valueMap; // key->val
		HashMap<Integer, Node> nodeMap;//key->freq list

	    public LFUCache(int capacity) {
	        this.capacity = capacity;
			head = new Node();
			valueMap = new HashMap<>();
			nodeMap = new HashMap<>();
	    }
	    
	    public int get(int key) {
	        if(valueMap.containsKey(key)){
	        	increaseFreq(key);
	        	return valueMap.get(key);
			}else 
				return -1;
	    }
	    
	    public void put(int key, int value) {
	        
	    }
		
		private void increaseFreq(int key){
			//find the freq node
			Node node = nodeMap.get(key);
			int freq = node.freq;
			//add the value to new freq(existed/new)
			if(node.pre == head){//new node, add to head
				Node newNode = new Node(freq + 1);
				head.next = newNode;
				newNode.next = node.next;
				node.next.pre = newNode;
				newNode.pre = head;
				nodeMap.put(key, newNode);
			}else{//add the value to next level freq
				Node preNode = node.pre;
				preNode.linkedSet.add(key);
			}
			//drop the value(drop node/delete value)
			if(node.linkedSet.size()==1){
				removeNode(node);
			}else{
				node.linkedSet.remove(key);
			}
		}
		
		private void removeNode(Node node){
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
	}

}
