package leetCode.candy;

public class Solution2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ratings[] = { 1, 1, 1, 1, 3, 4, 4, 5, 3, 1, 8, 16 };
		System.out.println(new Solution2().candy(ratings));
	}

	
	public int candy(int[] ratings) {
		/**
		 * 1.from left to right scan the ratings ignore right neighbor and give child candy
		 * 2.from right to left scan the ratings ignore left neighbor and give child candy
		 * 3.scan the two array, get the max candy every child should be given.
		 * 
		 * notice: the step2 and step3 can do in one time
		 */
		if (ratings.length <= 1)
			return ratings.length;
		int sum = 0;
		int leftCandys[] = new int[ratings.length];
		int rightCandys[] = new int[ratings.length];
		leftCandys[0] = 1;
		rightCandys[ratings.length - 1] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				leftCandys[i] = leftCandys[i - 1] + 1;
			else
				leftCandys[i] = 1;
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				rightCandys[i] = rightCandys[i + 1] + 1;
			else
				rightCandys[i] = 1;
		}
		for (int i = 0; i < ratings.length; i++)
			sum += leftCandys[i] > rightCandys[i] ? leftCandys[i]: rightCandys[i];
		return sum;
	}
}
