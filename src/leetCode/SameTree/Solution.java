package leetCode.SameTree;

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
		node1.left = node2;
		node1.right = node3;
		node4.left = node5;
//		node4.right = node6;
		//       1
		//   2      2
		//3   4  3    4
		boolean r= new Solution().isSameTree(root.left,root.right);
		System.out.println(r);
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
