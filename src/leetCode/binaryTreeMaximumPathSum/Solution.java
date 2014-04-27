package leetCode.binaryTreeMaximumPathSum;

public class Solution {
	private int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(-1);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
//		node1.right = node3;
		
		System.out.println(new Solution().maxPathSum(node1));
	}

	public int maxPathSum(TreeNode root) {
		
		maxPathSum2(root);
		return maxSum;
	}

	private int maxPathSum2(TreeNode root) {
		if(root == null)
			return 0;
		int left = maxPathSum2(root.left);
		int right = maxPathSum2(root.right);
		
		if(maxSum < left+right+root.val)
			maxSum = left+right+root.val;

		int result = Math.max(left, right)+root.val;
		return result > 0? result:0;
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