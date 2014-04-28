package leetCode.distinctSubsequences;

//TLE
public class Solution {
	
	public static void main(String[] args) {
		Solution  so = new Solution();
		String S ="daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac" ;
		String T = "ceadbaa";
		long st = System.currentTimeMillis();
		System.out.println(so.numDistinct(S, T));
		long et = System.currentTimeMillis();
		System.out.println("times:"+(et-st));
	}
	public int numDistinct(String S, String T) {
		if (S.length() <= 0 || T.length() <= 0)
			return 0;
		char sc[] = S.toCharArray();
		char tc[] = T.toCharArray();
		return numDistinct(sc, 0, tc, 0);

	}

	private int numDistinct(char[] sc, int i, char[] tc, int j) {
		
		int indexi = i, indexj = j;
		int leni = sc.length, lenj = tc.length;
		if(indexj >= lenj)
			return 1;
		int count = 0;
		
		while (leni - indexi >= lenj - j) {
			if (sc[indexi] == tc[indexj])
				count += numDistinct(sc, indexi + 1, tc, indexj + 1);
			indexi++;
		}
		return count;
	}
}
