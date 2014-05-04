package leetCode.uniqueBST;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().numTrees(1));
		System.out.println(new Solution().numTrees(2));
		System.out.println(new Solution().numTrees(3));
		System.out.println(new Solution().numTrees(4));
	}
	public int numTrees(int n) {
		if(n == 0)
			return 0;
		int p[] = new int[n+1];
		p[0] = 1;
		p[1] = 1;
		for(int i = 2;i <= n ;i++){
			for(int j = 0;j<i/2;j++){
				p[i] += 2*p[j]*p[i-j-1];
			}
			if(i %2 != 0)
				p[i] += p[i/2]*p[i/2];
		}
		return p[n];
	}
}
