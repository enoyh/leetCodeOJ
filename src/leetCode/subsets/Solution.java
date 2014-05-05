package leetCode.subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] S = {1,2,2};
		ArrayList<ArrayList<Integer>> r = new Solution().subsets(S );
		System.out.println(r);
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		subsets.add(empty);

		int len = S.length;
		if (len <= 0)
			return subsets;
		Arrays.sort(S);
		for(int i = 0;i < len;i++){
			int a = S[i];
			int size = subsets.size();
			for(int j = 0;j< size;j++){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.addAll(subsets.get(j));
				list.add(a);
				
				subsets.add(list);
			}
		}
		return subsets;
		
	}

}
