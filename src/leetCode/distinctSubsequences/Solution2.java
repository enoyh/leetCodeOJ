package leetCode.distinctSubsequences;

//TLE
public class Solution2 {
	
	public static void main(String[] args) {
		Solution2  so = new Solution2();
		String S ="daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac" ;
		String T = "ceadbaa";
		long st = System.currentTimeMillis();
		System.out.println(so.numDistinct(S, T));
		long et = System.currentTimeMillis();
		System.out.println("times:"+(et-st));
	}
	public int numDistinct(String S, String T) {
		if (S.length() <= 0 || T.length() <= 0 || S.length() < T.length())
			return 0;
		
		char sc[] = S.toCharArray();
		char tc[] = T.toCharArray();
		int dp[][] = new int[S.length()+1][T.length()+1];//dp[i][j] ÊÇ 0~i in S¡£0~j in T¡£
		for(int i = 0;i <= S.length();i++)
			dp[i][0] = 1;
		return numDistinct(sc, tc, dp);

	}

	private int numDistinct(char[] sc, char[] tc,int[][] dp) {
		
		int lens = sc.length, lent = tc.length;
		
		for(int i = 1;i <= lens;i++)
			for(int j = 1;j <= lent;j++){
				dp[i][j] = dp[i-1][j]+ (sc[i-1] == tc[j-1] ? dp[i-1][j-1] :0);
			}

		return dp[lens][lent];
	}
}
