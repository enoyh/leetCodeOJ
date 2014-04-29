package leetCode.SymmetricTree;

import leetCode.Util.TreeNode;

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(4);
		root.left = node1;
		root.right = node4;
//		node1.left = node2;
		node1.right = node3;
		node4.left = node6;
//		node4.right = node5;
		//       1
		//   2      2
		//3   4  3    4
		boolean r= new Solution().isSymmetric(root);
		System.out.println(r);
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return false;
		return isSymmetric(root.left, root.right);
	}
	public boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		if(left.val != right.val)
			return false;
		return isSymmetric(left.left,right.right) && isSymmetric(right.left, left.right);
	}
}
