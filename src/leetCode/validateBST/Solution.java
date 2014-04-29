package leetCode.validateBST;

import java.util.ArrayList;

import leetCode.Util.TreeNode;

public class Solution {
	private ArrayList<TreeNode> list  = new ArrayList<TreeNode>();
	public boolean isValidBST(TreeNode root) {
		preorderTree(root);
		for(int i = 0;i < list.size()-1;i++){
			if(list.get(i).val >= list.get(i+1).val)
				return false;
		}
		return true;
	}
	private void preorderTree(TreeNode root) {
		if(root == null)
			return;
		preorderTree(root.left);
		list.add(root);
		preorderTree(root.right);
	}
}
