package leetCode.PascalsTriangle2;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> triangleList = new Solution().getRow(1);
		System.out.println(triangleList);

	}

	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> triangleList = new ArrayList<Integer>();
		if(rowIndex < 0)
			return triangleList;
		else if(rowIndex  == 0){
			triangleList.add(1);
			return triangleList;
		}
		
		int arr[]  = new int[rowIndex + 1];
		arr[0] = arr[1] = 1;
		for(int i = 2;i < rowIndex+1;i++){
			arr[i] = 1;
			for(int j = i-1;j>0;j--){
				arr[j] = arr[j]+arr[j-1];
			}
		}
		for(int i = 0;i < rowIndex+1;i++)
			triangleList.add(arr[i]);
		
		return triangleList;
		
	}
}
