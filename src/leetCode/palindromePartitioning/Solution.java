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
//		ArrayList<ArrayList<String>> result = s.partition("a ab");
		ArrayList<ArrayList<String>> result2 = s.partition("");
//		System.out.println(result);
		System.out.println(result2);
//		System.out.println(s.isPalindrome(""));
//		System.out.println(s.isPalindrome("a"));
//		System.out.println(s.isPalindrome("ab"));
//		System.out.println(s.isPalindrome("aa"));
	}

	public ArrayList<ArrayList<String>> partition(String s) {

		HashMap<Integer, ArrayList<ArrayList<String>>> map = new HashMap<Integer, ArrayList<ArrayList<String>>>();//用来记录第i个位置的切分方法
		HashMap<Integer, Boolean> flagMap = new HashMap<Integer, Boolean>();//用来标记是否被访问
		if(s.equals("")){
			ArrayList<ArrayList<String>> list  = new ArrayList<ArrayList<String>>();
			ArrayList<String> empList = new ArrayList<String>();
			empList.add("");
			list.add(empList);
			return list;
		}
		String rs = new StringBuffer(s).reverse().toString();
		partition(rs, 0, flagMap, map);

		return map.get(0);
	}

	private boolean partition(String s, int index,
			HashMap<Integer, Boolean> flagMap,
			HashMap<Integer, ArrayList<ArrayList<String>>> map) {
		if (flagMap.get(index) != null)
			return flagMap.get(index);

		if (s.length() <= index) {
			ArrayList<ArrayList<String>> lastList  = new ArrayList<ArrayList<String>>();
			ArrayList<String> list = new ArrayList<String>();
//			list.add(s.substring(index, index+1));
			lastList.add(list);
			map.put(index, lastList);
			flagMap.put(index,true);
			return true;
		}

		int len = s.length();
		for (int i = index + 1; i <= len; i++) {
			String subString = s.substring(index, i);
			if (isPalindrome(subString)) {
				partition(s, i, flagMap, map);
				putResult(subString, index,i, map );
			}
		}
		flagMap.put(index, true);
		return true;
	}

	private void putResult(String subString, int index,int i,
			HashMap<Integer, ArrayList<ArrayList<String>>> map) {

		ArrayList<ArrayList<String >> iList = map.get(i);
		ArrayList<ArrayList<String >> indexList = map.get(index);
		if(indexList == null)
			indexList = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> list : iList) {
			ArrayList<String> newList = new ArrayList<String>();
			newList.addAll(list);
			newList.add(subString);
			indexList.add(newList);
		}
		map.put(index, indexList);
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
