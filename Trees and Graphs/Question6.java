public class Question6 {
	public static void main(String[] args) {

	}

	public Node findNext(Node node) {
		if (node == null) return null;
		if (node.right != null) {
			Node right = node.right;
			while (right != null) {
				right = right.left;
			}
			return right.parent;
		} else {
			Node q = node;
			Node x = q.parent;
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
}