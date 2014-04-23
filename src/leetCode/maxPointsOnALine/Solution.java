package leetCode.maxPointsOnALine;

import java.util.Random;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point points[] = new Point[100];
		Random random = new Random();
		for(int i = 0; i < 100;i++ ){
			points[i] = new Point(random.nextInt(40)-5,random.nextInt(40)-5);
		}
		System.out.println(new Solution().maxPoints(points));
	}

	public int maxPoints(Point[] points) {
		int max = 2;
		int length = points.length;
		if(length <= 2)
			return length;
		int A[][] = new int [length][length];
		
		int i,j,k,m;
		for(i = 0; i < length;i++){
			for(j = i+1;j < length;j++)
				A[i][j] = 0;//初始化
		}
		for(i = 0; i < length;i++){
			for(j = i+1;j < length;j++){
				if(A[i][j] != 0 && !(i == j-1 && (points[i].x == points[j].x && points[i].y == points[j].y)))//已经查找过
					continue;
				int count[] = new int [length];//用来记录在一条线上的点。
				count[0] = i;
				
				m = 1;
				for(int n = 0;n < i;n++){
					if(points[i].x == points[n].x && points[i].y == points[n].y){
//						countD++;//把重复点的全找出来，所有重复的点只做一次判断就好了,但做一个点来判断，他们都在一条线上。
//						count[m++]  = n;
						continue;
					}
				}
				while(j < length && points[i].x == points[j].x && points[i].y == points[j].y){
					//如果ij重合？？，j往下走
					count[m++]  = j;
					j++;
				}
//				for(int n = j;n < length;n++){
//					if(points[i].x == points[n].x && points[i].y == points[n].y){
//						count[m++]  = n;
//					}
//				}
				if(j < length){
					count[m++]  = j;
					if(A[i][j] != 0)
						continue;
				}
				//取出point i,point j，判断其他的点是否在这直线上面
				for(k = j+1;k < length;k++){
					if((points[i].x == points[k].x && points[i].y == points[k].y)){
						count[m++] = k;
						continue;
					}
					if(A[i][k] != 0) //判断过了。在其他的线上，那么肯定不在这条线上
						continue;
					else if(onALine(points[i],points[j],points[k])){
						count[m++] = k;//记录这个线上的点，
					}
				}
				for(int x = 0;x < m;x++){
					for(int y = x+1;y< m;y++)
						A[count[x]][count[y]] = m;//标记两节点之间最大的个数
				}
				if(m > max)
					max = m;
			}
		}
		
		
		return max;
	}

	private boolean onALine(Point point1, Point point2, Point point3) {
		if(point1.x == point2.x && point2.x == point3.x)
			return true;//垂直
		if(point1.y == point2.y && point2.y == point3.y)
			return true;//水平
		
		if(point1.x == point2.x && point1.y == point2.y)
			return true;//重合
		if(point1.x == point3.x && point1.y == point3.y)
			return true;//重合
		if(point2.x == point3.x && point2.y == point3.y)
			return true;//重合
		//斜线
		//(y2-y1)/(x2-x1)==(y3-y1)/(x3-x1)
		float x1 = point1.x;
		float y1 = point1.y;
		float x2 = point2.x;
		float y2 = point2.y;
		float x3 = point3.x;
		float y3 = point3.y;
		if(x2 == x1 || x3 == x2 ||  x3 == x1|| y1 == y2 || y2 == y3 || y1 == y3){
			//有任意两点在一条线上那么第三条肯定不在、因为上面已经判断了。
			return false;
		}
		float xielv1  = (y2-y3)/(x2-x3);
		float xielv2  =  (y3-y1)/(x3-x1);
		if(Math.abs(xielv1) == Math.abs(xielv2))
			return true;
		
		return false;
	}

	
}
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public String toString() {
		return x+","+y;
	}
	
	
}