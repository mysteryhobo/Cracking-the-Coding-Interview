public class LinkedListTest {
	public static void main(String[] args) {

	}

	class Node {
		Node next = null;
		int data;

		public Node(int data) {
			this.data = data;
		}

		public void append(int data) {
			Node newEnd = new Node(data);
			Node currNode = this;

			while(currNode.next != null) {
				currNode = currNode.next
			}
			currNode.next = newEnd;
		}
	}

	public deleteNode(Node head, int data) {
		Node n = head;
		if (head.data == data) return head.next;

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			} 
			n = n.next;
		}
		return head;
	}
}