package leetCode.balancedBinaryTree;

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
//		node4.right = node5;
		boolean r = new Solution().isBalanced(root);
		System.out.println(r);
	}
	public boolean isBalanced(TreeNode root) {
		return isBalanced(root,new Height(0));
	}

	public boolean isBalanced(TreeNode root,Height height) {
		if(root == null){
			height.height = 0;
			return true;
		}
		Height lHeight = new Height(0);
		Height rHeight = new Height(0);
		if(!isBalanced(root.left, lHeight))
			return false;
		if(!isBalanced(root.right, rHeight))
			return false;
		if( Math.abs(lHeight.height - rHeight.height) > 1)
			return false;
		height.height = Math.max(lHeight.height , rHeight.height)+1;
		return true;
	}
	
	class Height{
		int height;
		public Height(int height) {
			this.height = height;
		}
	}
}
