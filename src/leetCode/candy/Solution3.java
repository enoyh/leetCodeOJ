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
		 * ��ǰ��������������������߳�ƽ�׶Σ�����ǰ�����ȷ��candy
		 * �����½��׶Σ���ü�¼��ǰ���������У������1��ʼ���䣬֪������ǰ���������У�������+1��
		 * ʵ�������Ǻ���һ�ν�����������У�
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
