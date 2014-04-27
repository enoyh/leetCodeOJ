package leetCode.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list1.add(-10);
		triangle.add(list1);
//		list2.addAll(Arrays.asList(3,4));
//		triangle.add(list2);
//		list3.addAll(Arrays.asList(6,5,7));
//		triangle.add(list3);
//		list4.addAll(Arrays.asList(4,1,8,3));
//		triangle.add(list4);
		System.out.println(new Solution().minimumTotal(triangle));
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

		int size = triangle.size();
		ListIterator<ArrayList<Integer>>  it = triangle.listIterator(size);
		
		int minmum[] = new int[size+1];
		
		
		while(it.hasPrevious()){
			int j = 0;
			ArrayList<Integer> list = it.previous();
			for(Integer i : list){
				minmum[j] = Math.min(minmum[j], minmum[j+1])+i;
				j++;
			}
		}
		return minmum[0];
	}
}
