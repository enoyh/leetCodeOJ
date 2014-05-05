package leetCode.mergeSortedArray;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = {1,3,4,5,0, 0,  0,  0 };
		int B[] = {2,3,8,9};
		
		new Solution().merge(A,4,B,4);
		System.out.println(A);
		
	}

	public void merge(int A[], int m, int B[], int n) {
		int x = m+n -1;
		
		int i,j;
		for(i = m-1,j = n-1;j>=0 && i>=0;){
			if(A[i] >= B[j]){
				A[x--] = A[i--];
			}else
				A[x--] = B[j--];
		}
		if(i >= 0)
			while(x>= 0 && i >= 0 ){
				A[x--] = A[i--];
			}
		if(j >= 0)
			while(x>= 0 &&j >= 0 ){
				A[x--] = B[j--];
			}
	}
}
