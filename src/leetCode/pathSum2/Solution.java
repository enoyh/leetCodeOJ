package leetCode.pathSum2;

import java.util.ArrayList;
import java.util.Stack;

import leetCode.Util.TreeNode;

public class Solution {
	private ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
	private Stack<Integer> stack = new Stack<Integer>();
	
	
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
		ArrayList<ArrayList<Integer>> r = new Solution().pathSum(root,6);
		System.out.println(r);
	}
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null )
			return pathList;
		getPath(root,sum);
		
		return pathList;
	}
	private void getPath(TreeNode root, int sum) {
		if(root == null)
			return;
		stack.push(root.val);
		if(root.left == null && root.right == null && sum == root.val){
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.addAll(stack);
			pathList.add(path);
			stack.pop();
			return;
		}
		if(root.left != null)
			getPath(root.left, sum-root.val);
		if(root.right != null)
			getPath(root.right, sum-root.val);
		stack.pop();
	}
	
	
}
