package leetCode.candy;

public class Solution {

	
	public static void main(String[] args) {
		int ratings []= {5,5,5,3,2,4,4,5,3,1,8,8,8,8};
		System.out.println(new Solution().candy(ratings));
		
	}
	public int candy(int[] ratings) {
		if(ratings.length <= 1)
			return ratings.length;
		int count  = 0 ;
		int length = ratings.length;
		int candys[] = new int[length+2];
		int i;
		for(i = 0 ;i < length;i++){
			if(i == 0  )
				if(ratings[i] <= ratings[i+1])
					candys[i+1] = 1;
				else 
					continue;
			else if(i == length-1 )
				if(ratings[i] <= ratings[i-1])
					candys[i+1] = 1;
				else 
					continue;
			else if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1])
				candys[i+1] = 1;
		}
		candys[0] = 1;
		candys[length+1] = 1;
		int start = 0;
		int end = 0;
		for(i = 0;i < length;i++){
			if(candys[i+1] == 1)
				end = i+1;
				fill(candys,start,end,ratings);
				start = end;
		}
		fill(candys,start,length+1,ratings);
		for(i = 0;i <= length+1;i++){
			System.out.print(candys[i]+" ");
			count += candys[i];
		}
		System.out.println();
		return count ;
	}
	private void fill(int[] candys, int start,  int end, int[] ratings) {
		if(start == end -1 || start == end )
			return ;
		int countPrev = 1,countBack = 1,i ,j ;
		i = start+1;
		j = end-1;
//		while(i < mid){
//			if(i >= 2 && ratings[i-2] < ratings[i-1])
//				candys[i] = countPrev++;
//		}
//		while(j >  mid){
//			candys[j] = countBack++;
//		}
		
		while(i<=j && i>=2 && ratings[i-2]<=ratings[i-1]){
			if(ratings[i-2] < ratings[i-1])
				candys[i] = ++countPrev;
			else
				candys[i] = countPrev;
			i++;
		}
		while(i<=j && j>=2&&ratings[j-2]>=ratings[j-1]){
			if(ratings[j-2] > ratings[j-1])
				candys[j] = ++countBack;
			else
				candys[j] = countBack;
			j--;
		}
		candys[j] = 1+(candys[j-1]>candys[j+1]?candys[j-1]:candys[j+1]);
		
	}

}
