package leetCode.pathSum;

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
		root.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.right = node5;
		boolean r = new Solution().hasPathSum(root,12);
		System.out.println(r);
	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.right != null && hasPathSum(root.right, sum-root.val))
			return true;
		if(root.left != null && hasPathSum(root.left, sum-root.val))
			return true;
		if(root.right == null && root.left == null && sum == root.val)	
			return true;
		return false;
	}
	
}
