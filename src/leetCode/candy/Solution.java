package leetCode.candy;

public class Solution {

	
	public static void main(String[] args) {
		
	}
	public int candy(int[] ratings) {
		if(ratings.length <= 1)
			return ratings.length;
		int count  = 0 ;
		int length = ratings.length;
		int candys[] = new int[length+2];
		int i;
		for(i = 0 ;i < length;i++){
			if(i == 0 && ratings[i] < ratings[i+1])
				candys[i+1] = 1;
			else if(i == length && ratings[i] < ratings[i-1])
				candys[i+1] = 1;
			else if(ratings[i] < ratings[i-1] && ratings[i] < ratings[i+1])
				candys[i+1] = 1;
		}
		candys[0] = 1;
		candys[length+1] = 1;
		int start = 0;
		int end = 0;
		for(i = 0;i < length;i++){
			if(candys[i+1] == 1){
					end = i+1;
					fill(candys,start,end,ratings);
					start = end;
			}
		}
		
		return count ;
	}
	private void fill(int[] candys, int start, int end, int[] ratings) {
		if(start == end -1)
			return ;
		int count,i ,j ;
		i = start;
		j = end;
		
		while(i<j && ){
			
		}
	}

}
