package leetCode.sumRoot2LeafNumbers;

public class Solution {
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		sum = getSum(root,0);
		return sum;
	}

	private int getSum(TreeNode root, int i) {
		if(root == null)
			return i;
		int currentSum = i*10 + root.val;
		if(root.left == null)
			return getSum(root.right, currentSum);
		else if(root.right == null)
			return getSum(root.left, currentSum );
		else 
			return getSum(root.right, currentSum)+getSum(root.left, currentSum );
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
