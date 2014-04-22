package leetCode.evaluateReversePolishNotation;

import java.util.Stack;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+" };
		System.out.println(new Solution().evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> numbers = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			if (isNumber(tokens[i]))
				numbers.push(Integer.parseInt(tokens[i]));
			else {
				int num1 = numbers.pop();
				int num2 = numbers.pop();
				int num3 = 0;
				if (tokens[i].equals("+")) {
					num3 = num2 + num1;
				} else if (tokens[i].equals("-")) {
					num3 = num2 - num1;
				} else if (tokens[i].equals("*")) {
					num3 = num2 * num1;
				} else if (tokens[i].equals("/")) {
					num3 = num2 / num1;
				}
				numbers.push(num3);
			}
		}

		return numbers.pop();
	}

	private boolean isNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
