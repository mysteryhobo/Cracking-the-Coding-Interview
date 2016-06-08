public class Question2 {
	public int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
	public static void main (String[] args) {
		Question2 tester = new Question2();
		System.out.println(tester.findPaths(0,0, tester.board));
		System.out.println(tester.findPathsDP(0,0));

		for (int i = 0; i < tester.board.length; i ++) {
			for (int j = 0; j < tester.board[0].length; j ++) {
				System.out.printf("| %2d |", tester.board[i][j]);
			}
			System.out.println();
		}
	}

	public int findPaths(int x, int y, int[][] board) {
		if (x == board.length - 2 && y == board[0].length - 1) return 1;
		else if (x == board.length - 1 && y == board[0].length - 2) return 1;
		else {
			int total = 0;
			if (x < board.length - 1 && board[x + 1][y] != -1) total += findPaths(x + 1, y, board);
			if (y < board[0].length -1 && board[x][y + 1] != -1) total += findPaths(x, y + 1, board);
			return total;
		}
	}

	public int findPathsDP(int x, int y) {
		if (x == board.length - 2 && y == board[0].length - 1) {
			board[x][y] = 1;
			return 1;
		} else if (x == board.length - 1 && y == board[0].length - 2) {
			board[x][y] = 1;
			return 1;
		} else if (board[x][y] != -1 && board[x][y] != 0) {
			return board[x][y];
		} else {
			int total = 0;
			if (x < board.length - 1 && board[x + 1][y] != -1) total += findPathsDP(x + 1, y);
			if (y < board[0].length -1 && board[x][y + 1] != -1) total += findPathsDP(x, y + 1);
			board[x][y] = total;
			return total;
		}
	}
}