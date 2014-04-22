package leetCode.wordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s1= new String("code");
		String s2= new String("leetc");
		String s3= new String("leet");
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
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		if(dict.contains(s))
			return true;
		int index = 0;
		int length =s.length();
		for(int i = index+1;i < length;i--){
			String subString = s.substring(index, i);
			if(dict.contains(subString))
				if(wordBreak(s.substring(i), dict))
					return true;
		}
		return false;
	}
}
