package leetCode.recoverBST;

import java.util.ArrayList;

import leetCode.Util.TreeNode;

public class Solution {
	private ArrayList<TreeNode> list  = new ArrayList<TreeNode>();
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(8);
		root.left = node1;
		root.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.left = node5;
		node4.right = node6;
		//       5
		//   3      7
		//2   4  6    8
		Solution so = new Solution();
		so.recoverTree(root);
//		System.out.println(so.list);
		System.out.println(root);
	}
	public void recoverTree(TreeNode root) {
		preorderTree(root);
		TreeNode node1 = null;
		TreeNode node2 = null;
		for(int i = 0; i < list.size()-1;i++){
			if(list.get(i).val > list.get(i+1).val){
				node1 = list.get(i);
				break;
			}
		}
		for(int i = list.size()-1; i >0 ;i--){
			if(list.get(i).val < list.get(i-1).val){
				node2 = list.get(i);
				break;
			}
		}
		System.out.println(list);
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
	}
	private void preorderTree(TreeNode root) {
		if(root == null)
			return;
		preorderTree(root.left);
		list.add(root);
		preorderTree(root.right);
	}
}
