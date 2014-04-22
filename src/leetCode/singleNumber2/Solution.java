package leetCode.singleNumber2;


public class Solution {

	public static void main(String[] args) {
		int A[] = {2,7,4,5,4,7,2,5,3,2,7,5,4};
		System.out.println(new Solution().singleNumber(A));
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
}
