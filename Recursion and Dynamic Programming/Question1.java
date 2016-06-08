public class Question1 {
	public static void main(String[] args) {
		Question1 tester = new Question1();
		int remainingStairs = 50;
		System.out.println(tester.countWays(remainingStairs));
		int[] cache = new int[remainingStairs];
		System.out.println(tester.countWaysDP(remainingStairs, cache));
	}

	public int countWays(int remainingStairs) {
		int total = 0;
		if (remainingStairs > 0) {
			if (remainingStairs > 2) total += countWays(remainingStairs - 3) + 1;
			if (remainingStairs > 1) total += countWays(remainingStairs - 2) + 1;
			if (remainingStairs > 0) total += countWays(remainingStairs - 1) + 1;
		}
		return total;
	}

	public int countWaysDP(int remainingStairs, int[] cache) {
		int total = 0;
		if (remainingStairs > 0 && cache[remainingStairs - 1] > 0) {
			return cache[remainingStairs - 1];
		} else {
			if (remainingStairs > 2) total += countWays(remainingStairs - 3) + 1;
			if (remainingStairs > 1) total += countWays(remainingStairs - 2) + 1;
			if (remainingStairs > 0) total += countWays(remainingStairs - 1) + 1;
			cache[remainingStairs - 1] = total;
		}
		return total;
	}
}