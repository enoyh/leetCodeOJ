package leetCode.validPalindrome;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		String s1 = "A ";
		String s2 = "  A";
		String s3 = "  A,s        a  ";
		String s4 = "  A    1 a 0 a ";
		String s5 = "1a2";
		String s6 = "race a car";
		System.out.println(new Solution().isPalindrome(s));
		System.out.println(new Solution().isPalindrome(s1));
		System.out.println(new Solution().isPalindrome(s2));
		System.out.println(new Solution().isPalindrome(s3));
		System.out.println(new Solution().isPalindrome(s4));
		System.out.println(new Solution().isPalindrome(s5));
		System.out.println(new Solution().isPalindrome(s6));
	}

	public boolean isPalindrome(String s) {
		if(s == null)
			return false;
		if(s.equals(""))
			return true;
		char c[]= s.toLowerCase().toCharArray();
		int i = 0,j = s.length()-1;
		
		while(i < j){
			while(i < j && !Character.isDigit(c[i]) && !Character.isLetter(c[i]))
				i++;
			while(i < j && !Character.isDigit(c[j]) && !Character.isLetter(c[j]))
				j--;
			if(c[i] != c[j]){
				return false;
			}
			i++;j--;
		}
		return true;
	}
}
