package leetCode.ConstructBinaryTreeFromInorderAndPreorderTraversal;

import leetCode.Util.TreeNode;

public class Solution {
	public static void main(String[] args) {
		int inorder[] = { 5, 4, 6, 2, 1, 7, 3 };
		int preorder[] = { 1, 2, 4, 5, 6, 3, 7 };
		TreeNode root = new Solution().buildTree(preorder, inorder);
		System.out.println(root);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length <= 0)
			return null;
		int length = inorder.length;
		return buildTree(inorder, 0, length - 1, preorder, 0, length - 1);
	}

	private TreeNode buildTree(int[] inorder, int is, int ie, int[] preorder,
			int ps, int pe) {
		if (ie < is)
			return null;
		TreeNode root = new TreeNode(preorder[ps]);
		int len = 0;
		for (int i = is; i < ie; i++) {
			if (inorder[i] == preorder[ps])
				break;
			len++;
		}
		root.left = buildTree(inorder, is, is + len - 1, preorder, ps + 1, ps+ len);
		root.right = buildTree(inorder, is + len + 1, ie, preorder,ps + len + 1, pe);

		return root;

	}
}
