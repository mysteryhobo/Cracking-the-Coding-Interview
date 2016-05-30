public class BitTests {
	public static void main(String[] args) {

		BitTests tester = new BitTests();

		System.out.println("1:" + Boolean.valueOf(tester.getBit(2, 2)).toString());
		System.out.println("1:" + Boolean.valueOf(tester.getBit(2, 1)).toString());

		System.out.println("2:" + tester.setBit(0, 1));
		System.out.println("2:" + tester.setBit(1, 2));

		System.out.println("3:" + tester.clearBit(1, 0));
		System.out.println("3:" + tester.clearBit(3, 1));

		System.out.println("4:" + tester.clearAfter(255, 5));
		System.out.println("4:" + tester.clearAfter(255, 7));

		System.out.println("5:" + tester.clearBefore(255, 6));
		System.out.println("5:" + tester.clearBefore(255, 5));

		System.out.println("6:" + tester.updateBit(255, 6, 0));
		System.out.println("6:" + tester.updateBit(0, 6, 1));
	}

	boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}

	int setBit(int num, int i) {
		return num | (1 << i);
	}

	int clearBit(int num, int i) {
		return num & ~(1 << i);
	}

	int clearAfter(int num, int i) {
		return num & (( 1 << i) - 1);
	}

	int clearBefore(int num, int i) {
		return num & ~((1 << (i + 1)) - 1);
	}

	int updateBit (int num, int i, int v) {
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
	}
}