public class Question1 {
	public static void main(String[] args) {
		Question1 tester = new Question1();
		System.out.println("results: " + Boolean.valueOf(tester.isBalenced(tester.generateTree())).toString());
	}

	public boolean isBalenced(Node root) {
		return (checkHeight(root) != -1) ? true : false;
	}

	public int checkHeight(Node n) {
		if (n == null) return 0;
		else {
			int heightLeft = checkHeight(n.left);
			int heightRight = checkHeight(n.right);
			if (heightRight == -1 || heightLeft == -1) return -1;
			else {
				if (Math.abs(heightLeft - heightRight) > 1) return - 1;
				return Math.max(heightLeft, heightRight) + 1;
			}
		}
	}

	public Node generateTree() {
		Node root = new Node(5, new Node(3, new Node (4), new Node(8, new Node(2, null, new Node(11)), null)), new Node(7, new Node(3), new Node(6)));
		return root;
	}


	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.right = right;
			this.left = left;
		}
	}
}