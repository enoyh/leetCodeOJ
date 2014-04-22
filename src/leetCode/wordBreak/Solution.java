package leetCode.wordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String s1= new String("Code");
		String s2= new String("leetC");
		String s3= new String("ode");
		String s4= new String("a");
		Set<String> set = new HashSet<String>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
//		System.out.println(s1.equals(s2));
//		System.out.println(s1 == s2);
//		System.out.println(s.length());
//		System.out.println(s.substring(0, 0).equals(""));
		
		System.out.println(new Solution().wordBreak(s, set));
	}
	public boolean wordBreak(String s, Set<String> dict) {
		if(s == null || dict == null)
			return false;
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		return wordBreak(s,dict,0,map);
	}
	
	private boolean wordBreak(String s,Set<String >dict,int index,Map<Integer,Boolean> map){
		if(index>=s.length())
			return true;
		int length =s.length();
		if(map.get(index) != null)
			return map.get(index) ;
		//not in map
		for(int j = index+1;j <= length;j++){
			String subString = s.substring(index, j);
			if(dict.contains(subString)){
				if(wordBreak(s,dict,j,map)){//if subString (j,length) can brekable
					map.put(j,true) ;
//					map.put(index,true) ;//is needn't, because return true. and up function will put it;
					return true;
				}else{
					map.put(j,false) ;//the subString(j,length) is unbreakable
//					map.put(index,false) ; //?? no, it may be breakable; but not breakable(..,j-1),(j,lenght)
				}
			}
			
		}
		map.put(index,false) ;//the subString(index,length) is unbreakable
		return false;
	}
}
