package leetCode.grayCode;

import java.util.ArrayList;

public class Solution2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long st = System.currentTimeMillis();
		ArrayList<Integer> r = new Solution2().grayCode(15);
//		System.out.println(r);
		long et = System.currentTimeMillis();
		System.out.println("times:" + (et - st));
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> grayCode = new ArrayList<Integer>();
		grayCode.add(0);
		if (n == 0)
			return grayCode;
		grayCode.add(1);
		int y = 1;
		for (int i = 1; i < n; i++) {
			int size = grayCode.size();
			y = y << 1;
			for (int j = size - 1; j >= 0; j--) {
				grayCode.add(grayCode.get(j) | y);
			}

		}
		return grayCode;
	}

	public void testname() {
		int x = 6;
		int n = x;
		int y = 1;
		while (n != 0) {
			y = y << 1;
			n = n >> 1;
		}
		System.out.println(x | y);
	}
}
