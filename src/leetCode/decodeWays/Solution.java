package leetCode.decodeWays;

public class Solution {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		String s = "1110";
		System.out.println(new Solution().numDecodings(s));
	}

	public int numDecodings(String s) {
		int len = s.length();
		if (len <= 0)
			return 0;
		char c[] = s.toCharArray();
		int dp[] = new int[len + 1];
		dp[len] = 1;
		dp[len - 1] = c[len - 1] == '0' ? 0 : 1;
		for (int i = len - 2; i >= 0; i--) {
			if (c[i] == '0')
				dp[i] = 0;
			else {
				int x = (c[i] - '0') * 10 + (c[i + 1] - '0');
				if (x <= 26) {
					dp[i] = dp[i + 1] + dp[i + 2];
				} else
					dp[i] = dp[i + 1];
			}
		}
		return dp[0];

	}
}
