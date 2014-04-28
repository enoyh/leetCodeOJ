package leetCode.minimumDepthofBinaryTree;

import java.util.ArrayList;

import leetCode.Util.TreeNode;

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
//		root.left = node1;
//		root.right = node4;
//		node1.left = node2;
//		node1.right = node3;
//		node4.right = node5;
		int r = new Solution().minDepth(root);
		System.out.println(r);
	}
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		if(root.left != null && root.right != null)
			return 1+ Math.min(minDepth(root.left), minDepth(root.right));
		else if(root.left != null)
			return 1+minDepth(root.left);
		else
			return 1+minDepth(root.right);
	}
}
