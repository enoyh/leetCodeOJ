package leetCode.populatingNextRightPointersEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		int count = 1;
		int nextlevel = 2;
		while (!queue.isEmpty()) {
			count--;
			TreeLinkNode node = queue.poll();
			TreeLinkNode rightNode;
			if (count == 0) {
				rightNode = null;
				count = nextlevel;
				nextlevel = 0;
			} else {
				rightNode = queue.peek();
			}
			node.next = rightNode;
			if (node.left != null) {
				queue.offer(node.left);
				queue.offer(node.right);
				nextlevel += 2;
			}
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}