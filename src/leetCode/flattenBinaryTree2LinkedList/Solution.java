package leetCode.flattenBinaryTree2LinkedList;

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
		new Solution().flatten(root);
		TreeNode p = root;
		while(p.right != null){
			System.out.print(p.val +" -> ");
			p = p.right;
		}
		System.out.println(p.val);
		while(p.left != null){
			System.out.print(p.val +" -> ");
			p = p.left;
		}
		System.out.println(p.val);
	}
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		TreeNode prev = null;
		
		prev = preOrder(root,prev);
		prev.right = null;
	}

	private TreeNode preOrder(TreeNode root, TreeNode prev) {
		if(root == null)
			return prev;
		if(prev != null){
			prev.right = root;
			prev.left= null;
		}
		
		TreeNode right = root.right;
		prev = preOrder(root.left,root);
		prev = preOrder(right,prev);
		
		return prev;
	}
}
