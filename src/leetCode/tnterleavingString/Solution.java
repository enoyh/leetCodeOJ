package leetCode.tnterleavingString;

public class Solution {
	private static int count = 0;
	char c1[];
	char c2[];
	char c3[];
	int dp[][];
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		Long st =System.currentTimeMillis();
		System.out.println(new Solution().isInterleave(s1, s2, s3));
		Long et =System.currentTimeMillis();
		System.out.println(s1.length()+"--"+s2.length()+"--"+count);
		System.out.println("times:"+(et-st));
	}
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length() != s3.length())
			return false;
		if(s3.length() == 0)
			return true;
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
		c3 = s3.toCharArray();
		dp = new int[s1.length()+1][s2.length()+1];

		return isInterleave(0, 0, 0);
	}
	private boolean isInterleave(int index1,  int index2,int index3) {
		
		if(index3>=c3.length) {
			dp[index1][index2] = 1;
			return true;
		}
		if(dp[index1][index2] != 0){
			return dp[index1][index2] == 1?true:false;
		}
		if(index1 < c1.length)
			if(c1[index1] == c3[index3])
				if(isInterleave( index1+1,index2, index3+1)){
					dp[index1+1][index2] = 1;
					return true;
				}else{
					dp[index1+1][index2] = 2;
				}
		if(index2 < c2.length)
			if(c2[index2] == c3[index3])
				if(isInterleave(index1, index2+1, index3+1)){
					dp[index1][index2+1] = 1;
					return true;
				}else{
					dp[index1][index2+1] = 2;
				}
		dp[index1][index2] = 2;
		return false;
	}
}
