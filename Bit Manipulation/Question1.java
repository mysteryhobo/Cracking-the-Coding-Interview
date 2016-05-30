public class Question1 {
	public static void main(String[] args) {
		Question1 tester = new Question1();

	}

	public int insert(int num1, int num2, int i, int j) {
		int leftmask = ~0 << (j + 1);
		int rightMask = ((1 << i) - 1)
		int mask = mask1 | mask2;
		return (num1 & mask) | num2 << i;
	}
}