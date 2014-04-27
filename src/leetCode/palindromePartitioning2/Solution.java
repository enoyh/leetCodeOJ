package leetCode.palindromePartitioning2;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	private static long times = 0;
	private static long count = 0;
	private char[] c;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		// ArrayList<ArrayList<String>> result = s.partition("a ab");
		long s = System.currentTimeMillis();
		int result2 = so
				.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		long e = System.currentTimeMillis();
		System.out.println();
		System.out.println("times:" + (e - s));
		System.out.println("times:" + times);
		System.out.println("count:" + count);
		// System.out.println(result);
		 System.out.println(result2);
		// System.out.println(s.isPalindrome(""));
		// System.out.println(s.isPalindrome("a"));
		// System.out.println(s.isPalindrome("ab"));
		// System.out.println(s.isPalindrome("aa"));
	}

	public int minCut(String s) {
		if(s.length() < 1)
			return 0;
		c = s.toCharArray();
		int cut[] = new int[s.length()];
		cut(cut, s);
		// for (int i = 0; i < s.length(); i++)
		// System.out.print(cut[i] + " ");
		return cut[s.length() - 1];
	}

	private void cut(int[] cut, String s) {
		int len = s.length();
		for (int j = 0; j < len; j++) {
			int min = j;

			for (int i = 0; i <= j; i++) {
				if (i > 0) {
					if (cut[i - 1] + 1 < min && isPalindrome(i, j)) {
						min = cut[i - 1] + 1;
					}
				} else if (isPalindrome(i, j )) {
					min = 0;
					break;
				}
			}
			cut[j] = min;
		}
	}

	private boolean isPalindrome(int start,int end) {
//		long st = System.currentTimeMillis();
//		count++;
		for (int i = start, j = end; i < j; i++, j--) {
			if (c[i] != c[j]) {
//				long et = System.currentTimeMillis();
//				times += et - st;
				return false;
			}
		}
//		long et = System.currentTimeMillis();
//		times += et - st;
		return true;
	}

}
