package leetCode.surroundedRegions;

public class Solution {

	
	public static void main(String[] args) {
		char board[][] = { { 'O', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'O' },
				{ 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
//		char board[][] = {{'O'}};
		
		new Solution().solve(board);
	}
	public void solve(char[][] board) {
		
		int len =board.length;
		byte [][] visited = new byte[len][];
		boolean [][] result = new boolean[len][];
		for(int i = 0;i < len;i++){
			int leni = board[i].length;
			visited[i] = new byte[leni];
			result[i] = new boolean[leni];
			for(int j =0 ;j < leni;j++){
				visited[i][j] = 0;
				result[i][j] = true;
			}
		}
		for(int i =0;i < board.length;i++)
			for(int j = 0;j < board[i].length;j++)
				solve(i,j,board,visited,result);
		for(int i =0;i < board.length;i++)
			for(int j = 0;j < board[i].length;j++)
				if(result[i][j]  == true)
					board[i][j] = 'X';
		
		for(int i =0;i < result.length;i++){
			for(int j = 0;j < result[i].length;j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
//		printVisited(visited);
	}
	
	
	private boolean solve(int i, int j, char[][] board, byte[][] visited, boolean[][] result) {
		//答案是错的，而且会栈溢出
		if(i >= board.length || i < 0 || j >= board[i].length || j < 0){
			return false;
		}
		if(board[i][j] == 'X'){
			result[i][j] = true;
			return true;
		}
		//is 'O' and unvisited
		if(visited[i][j] == (byte)1)
			return result[i][j];
		if(i == board.length-1 || i == 0 || j == board[i].length-1 || j == 0){
			visited[i][j] = 1;
			result[i][j] = false;
			return false;
		}
		visited[i][j] = 1;
		
		boolean right  = solve(i, j+1, board, visited,result);
		boolean dwon = solve(i+1, j, board, visited,result);
		boolean top = solve(i-1, j, board, visited,result);
		boolean left = solve(i, j-1, board, visited,result);
		result[i][j] = left && dwon && right && top;
		return result[i][j];
		
	}
	
	
	private void printVisited(byte[][] visited) {
		for(int i =0;i < visited.length;i++){
			for(int j = 0;j < visited[i].length;j++)
				System.out.print(visited[i][j] +" ");
			System.out.println();
		}
	}
	
	
	
}
