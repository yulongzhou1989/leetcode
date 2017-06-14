package leetcode.design;

import java.util.Arrays;
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
				
			}
			
			public Node(int freq){
				this.freq = freq;
				linkedSet = new LinkedHashSet<>();
				pre = next = null;
			}
		}
		
		Node head;
		Node tail;
		int capacity;
		HashMap<Integer, Integer> valueMap; // key->val
		HashMap<Integer, Node> nodeMap;//key->freq list
		boolean active=false;

		public LFUCache(int capacity) {
			this.capacity = capacity;
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.pre = head;
			valueMap = new HashMap<>();
			nodeMap = new HashMap<>();
			active = capacity>0;
		}
		
		public int get(int key) {
			if(valueMap.containsKey(key)){
			    Node temp = head.next;
			    //config("#############",key);
				increaseFreq(key);
	            //config("-------------",key);
				return valueMap.get(key);
			}else 
				return -1;
		}
		
		public void put(int key, int value) {
			if(nodeMap.containsKey(key)){//if existed key, update value;
				increaseFreq(key);
				valueMap.put(key,value);
			}else if(active){
				//remove old when reach capacity
				if(capacity==0){
					Node leastFreqNode = tail.pre;
					int preKey=0;
					for(int v:leastFreqNode.linkedSet){
						preKey = v;
						break;
					}
					valueMap.remove(preKey);
					nodeMap.remove(preKey);
					leastFreqNode.linkedSet.remove(preKey);
					//Drop node if only one value in least freq node
					if(leastFreqNode.linkedSet.size()==0){
						removeNode(leastFreqNode);
					}
					capacity++;
				}
				//add to the end of list
				if(tail.pre.freq == 1){
					tail.pre.linkedSet.add(key);
					nodeMap.put(key, tail.pre);
				}else{
					Node newNode = new Node(1);
					newNode.linkedSet.add(key);
					addToTail(newNode);
					nodeMap.put(key, newNode);
				}
				valueMap.put(key, value);
				capacity--;
			}
		}
		
		//update nodeMap
		private void increaseFreq(int key){
			//find the freq node
			Node node = nodeMap.get(key);
			int freq = node.freq;
			//add the value to new freq(existed/new)
			if(node.pre.freq != freq + 1){//new node
				Node newNode = new Node(freq + 1);
				newNode.next = node;
				newNode.pre = node.pre;
				node.pre.next = newNode;
				node.pre = newNode;
				newNode.linkedSet.add(key);
				nodeMap.put(key, newNode);
			}else{//add the value to next level freq
				node.pre.linkedSet.add(key);
				nodeMap.put(key, node.pre);
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
		
		private void addToTail(Node node){
			tail.pre.next = node;
			node.pre = tail.pre;
			node.next = tail;
			tail.pre = node;
		}
		
		private void config(String s, int key){
		    Node temp = head.next;
			while(temp!=tail){
				 System.out.println("Key:"+key+",list:freq:"+temp.freq+", set:"+Arrays.toString(temp.linkedSet.toArray()));
				 temp = temp.next;
			}
			System.out.println(s);
		}
	}

	/**
	 * Your LFUCache object will be instantiated and called as such:
	 * LFUCache obj = new LFUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}
