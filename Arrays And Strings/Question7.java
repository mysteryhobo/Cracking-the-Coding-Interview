import java.util.*;

public class Question7 {
	public static void main(String[] args) {
		int[][] table = {{1, 2, 3, 5, 0, 4, 3, 2, 1}, {1, 0, 2, 4, 4, 3, 2, 1, 6}, {3, 4, 5, 3, 4, 3, 2, 1, 9}};
		solution(table);
		for (int i = 0; i < table.length; i ++) {
			for (int j = 0; j < table[0].length; j ++){
				System.out.print(table[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void solution(int[][] array) {
		// Find the number of 0s
		ArrayList<Integer> xCoords = new ArrayList<Integer>();
		ArrayList<Integer> yCoords = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i ++) {
			for (int j = 0; j < array[0].length; j ++) {
				if (array[i][j] == 0) {
					 xCoords.add(i);
					 yCoords.add(j);
				}
			}
		}

		int pos = 0;
		for (Integer x : xCoords) {
			int y = yCoords.get(pos);
			fill(array, x, y);
			pos ++;
		}
	}

	public static void fill (int[][] array, int x, int y) {
		for (int i = 0; i < array.length; i ++) array[i][y] = 0;
		for (int i = 0; i < array[0].length; i ++) array[x][i] = 0;
	}
}