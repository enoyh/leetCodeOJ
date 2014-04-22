package leetCode.reverseAString;

import org.junit.Test;

public class Solution {

	/**
	 * @param args
	 */
	@Test
	public  void main() {
		String s = "    hello my honey   good shaniu   ";
		String s2 = " 1   ";
		
		s = reverseWords(s2);
		System.out.println(s);
	}

	
	public String reverseWords(String s) {
		int i = 1;
		if(s == null)
			return null;
		String[] strArray = s.split("\\s+");
		if(strArray.length == 0)
			return "";
		StringBuffer sb = new StringBuffer(reverseString(strArray[0]));
		if(strArray[0].equals("")){
			if(i < strArray.length)
				sb.append(reverseString(strArray[i++]));
		}
			
		for(; i< strArray.length;i++){
			sb.append(" ");
			sb.append(reverseString(strArray[i]));
		}
        return sb.reverse().toString();
    }
	
	public String reverseString(String s){
		StringBuffer sb = new StringBuffer(s);
		return sb.reverse().toString();
	}
	private boolean isEmpty(String s) {
		if(s == null || "".equals(s))
			return true;
		return false;
	}
}
