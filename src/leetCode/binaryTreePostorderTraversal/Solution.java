package leetCode.binaryTreePostorderTraversal;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		postorderTraversal2(root,list);
		
		return list;
	}

	private void postorderTraversal2(TreeNode root, ArrayList<Integer> list) {
		if(root == null)
			return;
		list.add(root.val);
		postorderTraversal2(root.left,list);
		postorderTraversal2(root.right,list);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}