package leetCode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

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
		//       1
		//   2      5
		//3   4       6
		ArrayList<Integer> r= new Solution().inorderTraversal(root);
		System.out.println(r);
	}
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> inorderList = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
			return inorderList;
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.peek();
			while(node != null){
				stack.push(node.left);
				node = node.left;
			}
			stack.pop();
			if(!stack.isEmpty()){
				node = stack.pop();
				inorderList.add(node.val);
				stack.push(node.right);
			}
		}
		return inorderList;
	}
}
