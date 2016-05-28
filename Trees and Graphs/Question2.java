public class Question2 {
	public static void main(String[] args) {

	}

	public enum State {
		Unvisited, Visited, Visiting;
	}

	public boolean areConnected(Node start, Node end) {
		LinkedList<Node> queue = new LinkedList<Node>();
		start.state = State.Visiting;
		queue.add(start);
		Node node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			for (Node curr : node.getNeighbors()) {
				if (node.state == State.Unvisited) {
					if (curr == end) return true;
					else {
						curr.state = State.Visiting;
						queue.add(curr);
					}
				}
			}
			node.state = State.Visiting;
		}
		return false;
	}

	public class Node {
		int data;
		ArrayList<Node> neighbors = new ArrayList<Node>();
		State state = Unvisited;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node... neighbors) {
			this.data = data;
			for (Node node : neighbors) {
				this.neighbors.add(node);
			}
		}

		public ArrayList<Node> getNeighbors() {
			return neighbors;
		}
	}
}