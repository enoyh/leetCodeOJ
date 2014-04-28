package leetCode.BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import leetCode.Util.TreeNode;

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
//		root.right = node4;
		node1.left = node2;
//		node1.right = node3;
//		node4.right = node5;
		ArrayList<ArrayList<Integer>> r = new Solution().levelOrderBottom(root);
		System.out.println(r);
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> levelOrderList = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return levelOrderList;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			getNextLevel(queue, levelOrderList);
		}

		Collections.reverse(levelOrderList);
		return levelOrderList;
	}

	private void getNextLevel(Queue<TreeNode> queue,
			ArrayList<ArrayList<Integer>> levelOrderList) {
		int size = queue.size();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		levelOrderList.add(list);
	}
}
