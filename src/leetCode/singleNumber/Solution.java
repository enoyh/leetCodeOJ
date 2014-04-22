package leetCode.singleNumber;

public class Solution {

	public static void main(String[] args) {
		int A[] = {2,7,4,5,4,7,2,5,0};
		System.out.println(new Solution().singleNumber(A));
		
	}
	
	public int singleNumber(int[] A) {
		int result = 0;
		for(int i = 0;i < A.length;i++){
			result = result ^ A[i];
		}
		
		return result;
	}

}
