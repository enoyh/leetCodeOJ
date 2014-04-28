package leetCode.populatingNextRightPointersEachNode2;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return ;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		while(!queue.isEmpty())
			connect(queue);
		
	}

	private void connect(Queue<TreeLinkNode> queue) {
		int size = queue.size();
		TreeLinkNode node= null;
		for(int i =0 ;i < size;i++){
			node = queue.poll();
			node.next = queue.peek();
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
		}
		node.next = null;
	}
}


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}