package leetCode.singleNumber2;

public class Solution {

	public static void main(String[] args) {
		int A[] = { 2, 7, 4, 5, 4, 7, 2, 5, 3, 2, 7, 5, 4 };
		System.out.println(new Solution().singleNumber2(A));
	}

	public int singleNumber(int[] A) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < A.length; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}

	public int singleNumber2(int A[]) {
	    int count[] = new int[32];
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        for (int j = 0; j < A.length; j++) {
	            if ( ((A[j] >> i) & 1) == 0x1) {
	                count[i]++;
	            }
	        }
	        result |= ((count[i] % 3) << i);
	    }
	    return result;
	}
}
