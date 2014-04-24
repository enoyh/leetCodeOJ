package leetCode.surroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = { { 'O', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'O' },
				{ 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } , { 'X', 'O', 'X', 'X' }};
		// char board[][] = {{'O'}};
		new Solution2().solve(board);
	}

	public void solve(char[][] board) {
		
		int M =board.length;
		if(M <= 0)
			return ;
		int N =board[0].length;
		int i = 0,j;
		for(j = 0;j < N;j++){
			if(board[0][j] == 'O')
				dail(0,j,board,N,M);
			if(board[M-1][j] == 'O')
				dail(M-1,j,board,N,M);
		}
		for(i=1;i<M-1;i++){
			if(board[i][0] == 'O')
				dail(i,0,board,N,M);
			if(board[i][N-1] == 'O')
				dail(i,N-1,board,N,M);
		}
//		for(i = 0;i < M;i++){
//			for(j = 0;j < N;j++)
//				System.out.print(board[i][j]);
//			System.out.println();
//		}
		for(i = 0;i < M;i++)
			for(j = 0;j < N;j++)
				if(board[i][j] == 'D')
					board[i][j] = 'O'; 
				else if(board[i][j] == 'O')
					board[i][j] = 'X';
		
		for(i = 0;i < M;i++){
			for(j = 0;j < N;j++)
				System.out.print(board[i][j]);
			System.out.println();
			}
	}
	
	private void dail(int i, int j, char[][] board,int width,int height) {
		//广度便利这个节点
		Queue<Position> queue = new LinkedList<Position>();
		queue.offer(new Position(i, j));
		board[i][j] = 'D';
		while(!queue.isEmpty()){
			Position p = queue.poll();
			int x = p.x,y = p.y;
			board[x][y] = 'D';
			if(x-1 >= 0 && board[x-1][y] == 'O'){
				board[x-1][y] = 'D';
				queue.offer(new Position(x-1, y));
			}
			if(y-1 >= 0 && board[x][y-1] == 'O'){
				board[x][y-1] = 'D';
				queue.offer(new Position(x, y-1));
			}
			if(x+1 < height && board[x+1][y] == 'O'){
				board[x+1][y] = 'D';
				queue.offer(new Position(x+1, y));
			}
			if(y+1 < width && board[x][y+1] == 'O'){
				board[x][y+1] = 'D';
				queue.offer(new Position(x, y+1));
			}
			
		}
	}

	class Position{
		int x,y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
