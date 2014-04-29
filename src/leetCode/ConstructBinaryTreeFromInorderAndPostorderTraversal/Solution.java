package leetCode.ConstructBinaryTreeFromInorderAndPostorderTraversal;

import leetCode.Util.TreeNode;

public class Solution {
	
	public static void main(String[] args) {
		int inorder[] = {5,4,6,2,1,7,3};
		int postorder[] = {5,6,4,2,7,3,1};
		TreeNode root = new Solution().buildTree(inorder, postorder);
		System.out.println(root);
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length <=0)
			return null;
		int length = inorder.length;
		return buildTree(inorder,0,length-1,postorder,0,length-1);
	}
	
	private TreeNode buildTree(int []inorder,int is,int ie,int [] postorder,int ps,int pe){
		if(ie<is)
			return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int leftTreeLen = 0;
		for(int i = ie;i>=is;i--){
			if(inorder[i] == postorder[pe])
				break;
			leftTreeLen ++;
		}
		root.left = buildTree(inorder,is,ie-leftTreeLen-1,postorder,ps,pe-leftTreeLen-1);
		root.right = buildTree(inorder,ie-leftTreeLen+1,ie,postorder,pe-leftTreeLen,pe-1);
		
		return root;
	}
}
