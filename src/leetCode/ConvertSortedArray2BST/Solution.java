package leetCode.ConvertSortedArray2BST;

import leetCode.Util.TreeNode;

public class Solution {
	public static void main(String[] args) {
		int A[] ={1};
		TreeNode root = new Solution().sortedArrayToBST(A);
		System.out.println(root);
	}
	public TreeNode sortedArrayToBST(int[] num) {
		if(num == null)
			return null;
		return sortedArrayToBST(num,0,num.length-1);
	}

	private TreeNode sortedArrayToBST(int[] num, int i, int j) {
		if(i > j)
			return null;
		int mid = (i+j)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num,i,mid-1);
		root.right = sortedArrayToBST(num,mid+1,j);
		return root;
	}
}
