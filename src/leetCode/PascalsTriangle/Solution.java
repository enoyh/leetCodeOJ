package leetCode.PascalsTriangle;

import java.util.ArrayList;

class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> triangelList = new Solution().generate(4);
		System.out.println(triangelList);
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> triangelList = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> oldList = new ArrayList<Integer>();
		oldList.add(1);
		if(numRows < 1){
			return triangelList;
		}
		else if(numRows == 1){
			triangelList.add(oldList);
			return triangelList;
		}
		triangelList.add(oldList);
		oldList = new ArrayList<Integer>();
		oldList.add(1);
		oldList.add(1);
		triangelList.add(oldList);
		
		for(int i = 2;i < numRows;i++){
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(1);
			int before = -1;
			for(Integer num:oldList){
				if(before == -1)
					before = num;
				else{
					newList.add(num+before);
					before = num;
				}
			}
			newList.add(1);
			triangelList.add(newList);
			oldList = newList;
		}
		
		return triangelList;
		
	}

}
