package leetCode.Util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
		left = right = null;
	}

	@Override
	public String toString() {
		return val+"";
	}
	
	
}
