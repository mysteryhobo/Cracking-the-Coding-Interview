public class Question 4 {
	public static void main(String[] args) {

	}

	public ArrayList<LinkedList<Node>> createList (Node root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);

		while (current.size() > 0) {
			results.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<treeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null) current.add(parent.left);
				if (parent.right != null) current.add(parent.right);
			}
		}
		return results;
	}

	public class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.right = right;
			this.left = left;
		}
	}
}