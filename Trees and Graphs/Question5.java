public class Question5 {
	public static void main(string[] args) {
		Question5 tester = new Question5();
		tester.checkTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean checkTree(Node node, int min, int max) {	
		if (node == null) return true;
		if (node.data >= min && node.data < max) {
			return checkTree(node.left, min, node.data) && checkTree(node.right, node.data + 1, max);
		} else return false;
	}
}