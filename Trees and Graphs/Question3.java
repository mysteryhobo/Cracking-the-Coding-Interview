public class Question3 {
	public static void main(String[] args) {
		node root = generateTree(array, 0, array.length());
	}

	public Node generateTree(int[] array, int start, int end) {
		int middle = (start + end) / 2;
		if (end < start) return null;
		Node m = new Node(array[middle]);
		m.left = generateTree(array, start, middle - 1);
		m.right = generateTree(array, middle, end);
		return m;
	}
}