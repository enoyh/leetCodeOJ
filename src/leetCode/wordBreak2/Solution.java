package leetCode.wordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaab";
		String s1= new String("Code");
		String s2= new String("leetC");
		String s3= new String("ode");
		String s4= new String("leet");
		String s5= new String("aaa");
		String s6= new String("aa");
		String s7= new String("ab");
		Set<String> set = new HashSet<String>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		set.add(s5);
		set.add(s6);
		set.add(s7);
//		System.out.println(s1.equals(s2));
//		System.out.println(s1 == s2);
//		System.out.println(s.length());
//		System.out.println(s.substring(0, 0).equals(""));
		ArrayList<String> list =  new Solution().wordBreak(s, set);
//		if(list != null)
//			for(String str:list)
//				System.out.println(str);
//		else 
			System.out.println("null");
	}
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> nullResult = new ArrayList<String>();
		if(s == null || dict == null)
			return nullResult;
		Map<Integer, Boolean> mapFlag = new HashMap<Integer, Boolean>();
		Map<Integer, ArrayList<String>> mapResult = new HashMap<Integer, ArrayList<String>>();
		
		wordBreak(s,dict,0,mapFlag,mapResult);
		if(null != mapResult.get(0) )
			return mapResult.get(0);
		return nullResult;
	}

	private boolean wordBreak(String s, Set<String> dict, int index,
			Map<Integer, Boolean> mapFlag,
			Map<Integer, ArrayList<String>> mapResult) {
		if (index >= s.length()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			mapResult.put(index, list);
			return true;
		}
		int length = s.length();
		if (mapFlag.get(index) != null)
			return mapFlag.get(index);
		// not in map
		boolean flag = false;
		for (int j = index + 1; j <= length; j++) {
			String subString = s.substring(index, j);
			if (dict.contains(subString)) {
				if (wordBreak(s, dict, j, mapFlag,mapResult)) {
					// if subString (j,length) can breakable
					mapFlag.put(j, true);
					putResult(mapResult,subString,index,mapResult.get(j));
					// put the possible result of index to length
					// and up function will put it;
					// return true;
					flag = true;//can be breakable
				} else {
					mapFlag.put(j, false);
					// the subString(j,length) is unbreakable
					// map.put(index,false) ; //?? no, it may be breakable; but
					// not breakable(..,j-1),(j,lenght)
				}
			}
		}
		
		printResultMap(mapResult);
		if(flag)
			return flag;
		mapFlag.put(index, false);// the subString(index,length) is unbreakable
		return false;
	}


	private void putResult(Map<Integer, ArrayList<String>> mapResult,
			String subString, int index, ArrayList<String> arrayList) {
		ArrayList<String> list = mapResult.get(index);
		if(list == null)
			list = new ArrayList<String>();
		
		for(String s:arrayList){
			if(!s.equals(""))
				list.add(subString+" "+s);
			else
				list.add(subString);
		}
		mapResult.put(index, list);
	}
	
	private void printResultMap(Map<Integer, ArrayList<String>> mapResult) {
		for(Entry<Integer, ArrayList<String>> entry :mapResult.entrySet()){
			System.out.println(entry.getKey()+"==========");
			for(String str : entry.getValue())
				System.out.println(str);
		}
		
	}
}
