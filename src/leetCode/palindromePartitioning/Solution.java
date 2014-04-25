package leetCode.palindromePartitioning;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isPalindrome(""));
		System.out.println(s.isPalindrome("a"));
		System.out.println(s.isPalindrome("ab"));
		System.out.println(s.isPalindrome("aa"));
	}

	public ArrayList<ArrayList<String>> partition(String s) {

		HashMap<Integer, ArrayList<ArrayList<String>>> map = new HashMap<Integer, ArrayList<ArrayList<String>>>();
		HashMap<Integer, Boolean> flagMap = new HashMap<Integer, Boolean>();
		partition(s, 0, flagMap, map);

		return map.get(0);
	}

	private boolean partition(String s, int index,
			HashMap<Integer, Boolean> flagMap,
			HashMap<Integer, ArrayList<ArrayList<String>>> map) {
		if (s.length() <= index) {
			return true;
		}

		int len = s.length();
		if (flagMap.get(index) != null)
			return flagMap.get(index);

		boolean flag = false;
		for (int i = index + 1; i < len; i++) {
			String subString = s.substring(index, i);
			if (isPalindrome(subString)) {
				if (partition(s, i, flagMap, map)) {
					flag = true;
					flagMap.put(i, true);
					putResult(subString, index,i, map );
				} else
					flagMap.put(i, false);

			}
		}
		if (flag)
			return flag;
		flagMap.put(index, false);
		return false;

	}

	private void putResult(String subString, int index,int i,
			HashMap<Integer, ArrayList<ArrayList<String>>> map) {

		ArrayList<ArrayList<String >> indexList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String >> iList = map.get(i);
		
		
		if(iList == null){
			ArrayList<String> list = new ArrayList<String>();
			list.add(subString);
			indexList.add(list);
			return;
		}else{
			for(ArrayList<String> list:iList){
				list.add(subString);
			}
		}
	}

	private boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		int len = s.length();

		for (int i = 0, j = len - 1; i < j; i++, j--) {
			if (c[i] != c[j])
				return false;
		}
		return true;
	}

}
