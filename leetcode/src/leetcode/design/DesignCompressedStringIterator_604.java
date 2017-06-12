package leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignCompressedStringIterator_604 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class StringIterator {

	    class Node {
			int count;
			char c;
			public Node(){
				
			}
			
			public Node(char c, int count){
				this.count = count;
				this.c = c;
			}
		}

		Deque<Node> queue = new ArrayDeque<>();

	    public StringIterator(String compressed) {
			if(compressed.length()==0) return;
			char c = '\0';
			String num = "";
			int i=0;
	        while(i<compressed.length()){
				if(!Character.isDigit(compressed.charAt(i))){
					c = compressed.charAt(i++);
					continue;
				}
				while(i<compressed.length() && Character.isDigit(compressed.charAt(i))){
					num += compressed.charAt(i++);
				}
				queue.offer(new Node(c, Integer.valueOf(num)));
				num = "";
			}
	    }
	    
	    public char next() {
	        if(!hasNext()) return ' ';
			Node node = queue.poll();
			node.count--;
			if(node.count!=0)
				queue.addFirst(node);
			return node.c;
	    }
	    
	    public boolean hasNext() {
	        if(queue.size()==0) return false;
			else return true;
	    }
	}

	/**
	 * Your StringIterator object will be instantiated and called as such:
	 * StringIterator obj = new StringIterator(compressedString);
	 * char param_1 = obj.next();
	 * boolean param_2 = obj.hasNext();
	 */

}
