package leetCode.surroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public void solve(char[][] board) {
		int rows = board.length;
		if (rows < 1)
			return;
		int cols = board[0].length;
		if (cols < 1)
			return;
		for (int x = 0; x < rows; x++) {
			bfs(board, x, 0, rows - 1, cols - 1);
			bfs(board, x, cols - 1, rows - 1, cols - 1);
		}
		for (int y = 0; y < cols; y++) {
			bfs(board, 0, y, rows - 1, cols - 1);
			bfs(board, rows - 1, y, rows - 1, cols - 1);
		}
		setBoard(board);
	}

	public void bfs(char[][] board, int x, int y, int rows, int cols) {
		Queue<Point> queue = new LinkedList<Point>();
		visit(board, x, y, rows, cols, queue);
		while (queue.size() > 0) {
			Point point = queue.poll();
			x = point.x;
			y = point.y;
			visit(board, x - 1, y, rows, cols, queue);
			visit(board, x, y - 1, rows, cols, queue);
			visit(board, x, y + 1, rows, cols, queue);
			visit(board, x + 1, y, rows, cols, queue);
		}
	}

	public void visit(char[][] board, int x, int y, int rows, int cols,
			Queue<Point> queue) {
		if (x < 0 || x > rows || y < 0 || y > cols || board[x][y] != 'O')
			return;
		board[x][y] = 'v';
		queue.offer(new Point(x, y));
	}

	public void setBoard(char[][] board) {
		for (int x = 0; x < board.length; x++)
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] == 'v')
					board[x][y] = 'O';
				else if (board[x][y] == 'O')
					board[x][y] = 'X';
			}
	}

	class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
