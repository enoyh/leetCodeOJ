package leetCode.longestConsecutiveSequence;

import java.util.HashMap;


public class Solution {

	public static void main(String[] args) {
		int []num = { 100, 9, 5, 7, 3, 1};
		System.out.println(new Solution().longestConsecutive(num));
	}
	
	public int longestConsecutive(int[] num) {
		if(num == null || num.length <= 0)
			return 0;
		HashMap<Integer,Boolean> visitedMap = new HashMap<Integer,Boolean>();
		
		for(int i = 0;i< num.length;i++)
			visitedMap.put(num[i], false);
		int max = 0;
		
		for(int i = 0;i< num.length;i++){
			if(visitedMap.get(num[i]) == false){
				int len = getSequenceLength(num[i],visitedMap);
				max = Math.max(max, len);
			}
		}
		return max;
	}

	private int getSequenceLength(int i, HashMap<Integer, Boolean> visitedMap) {
		visitedMap.put(i, true);
		int bigest = i+1;
		int smallest = i-1;
		while(visitedMap.get(bigest) != null){
			visitedMap.put(bigest, true);
			bigest++;
		}
		while(visitedMap.get(smallest) != null){
			visitedMap.put(smallest, true);
			smallest--;
		}
		return bigest - smallest-1;
	}
}
