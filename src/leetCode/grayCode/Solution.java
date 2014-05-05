package leetCode.grayCode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		ArrayList<Integer> r = new Solution().grayCode(15);
//		System.out.println(r);
		long et = System.currentTimeMillis();
		System.out.println("times:"+(et-st));
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> grayCode = new ArrayList<Integer>();
		ArrayList<String> grayStrings = new ArrayList<String>();
		if (n == 0)
			return grayCode;
		grayStrings.add("0");
		grayStrings.add("1");
		for(int i = 1;i < n;i++){
			ArrayList<String> newGrayStrings = new ArrayList<String>();
			for(String s:grayStrings){
				newGrayStrings.add("0"+s);
			}
			Collections.reverse(grayStrings);
			for(String s:grayStrings){
				newGrayStrings.add("1"+s);
			}
			grayStrings = newGrayStrings;
		}
		return trans2IntList(grayStrings);
	}

	private ArrayList<Integer> trans2IntList(ArrayList<String> grayStrings) {
		ArrayList<Integer> grayCode = 	new ArrayList<Integer> ();
		for(String s:grayStrings){
			grayCode.add(Integer.parseInt(s, 2));
		}
		return grayCode;
	}
}
