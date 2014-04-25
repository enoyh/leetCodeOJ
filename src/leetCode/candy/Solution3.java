package leetCode.candy;

public class Solution3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ratings[] = { 1, 1, 1, 1, 3, 4, 4, 5, 3, 1, 8, 16 };
		System.out.println(new Solution3().candy(ratings));
	}
	public int candy(int[] ratings) {
		/**
		 * 从前往后遍历，遇到上升或者持平阶段，根据前面的来确定candy
		 * 遇到下降阶段，获得纪录的前面的最大序列，后面从1开始分配，知道超出前面的最大序列，则跳过+1；
		 * 实际上这是后面一段降序的逆序排列，
		 */
		if (ratings.length <= 1)
			return ratings.length;
		int prev = 1;
		int countCandy = 1;
		int maxSequence = 1;
		int len = 0;;
		
		for(int i = 1 ;i < ratings.length;i++){
			if(ratings[i] < ratings[i-1]){
				len++;
				if(maxSequence == len){
					len++;
				}
				countCandy += len;
				prev = 1;
			}
			else{
				if(ratings[i] > ratings[i-1]){
					prev++;
				}else{
					prev = 1;
				}
				countCandy += prev;
				len = 0;
				maxSequence = prev;
			}
		}
		return countCandy;
	}

}
