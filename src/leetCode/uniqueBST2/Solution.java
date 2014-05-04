package leetCode.uniqueBST2;

import java.util.ArrayList;

import leetCode.Util.TreeNode;

public class Solution {
	
	
	public static void main(String[] args) {
		ArrayList<TreeNode>  trees = new Solution().generateTrees(0);
		System.out.println(trees);
	}
	public ArrayList<TreeNode> generateTrees(int n) {
		int A[] = new int[n+1];
		for(int i = 1;i<n+1;i++)
			A[i] = i;
		return buildTrees(A,1,n);
	}

	private ArrayList<TreeNode> buildTrees(int[] a, int start, int end) {
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if(start >end){
			trees.add(null);//at lest one
			return trees;
		}
		for(int i = start;i <= end;i++){
			ArrayList<TreeNode> leftTrees = buildTrees(a, start, i-1);
			ArrayList<TreeNode> rightTrees = buildTrees(a, i+1, end);
			for(int x = 0;x<leftTrees.size();x++){
				TreeNode leftTree = leftTrees.get(x);
				for(int y = 0;y < rightTrees.size();y++){
					TreeNode root = new TreeNode(a[i]);
					root.left = leftTree;
					root.right = rightTrees.get(y);
					trees.add(root);
				}
			}
		}
		
		return trees;
	}
}
