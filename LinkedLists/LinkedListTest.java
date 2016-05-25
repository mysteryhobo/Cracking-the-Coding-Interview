import java.util.*;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedListTest tester = new LinkedListTest();
		LinkedList list = tester.new LinkedList(7);
		list.append(5);
		list.append(3);
		list.append(4);
		list.append(1);
		list.append(3);
		list.append(5);
		list.deleteNode(list.head.next.next);
		list.printList();
		System.out.println(list.findXfromlast(3).data);
		System.out.println(list.findXfromlast(5).data);
		list.printList();
		list.removeDuplicates2();
		list.printList();
	}

	class LinkedList {
		Node head;
		public LinkedList(Node head) {
			this.head = head;
		}

		public LinkedList(int data) {
			head = new Node(data);
		}

		Node append(int data) {
			Node newEnd = new Node(data);
			Node currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newEnd;
			return head;
		}

		Node deleteNode(int data) {
			if (head.data == data) head = head.next;
			Node n = head;
			while (n.next != null) {
				if (n.next.data == data) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			return head;
		}

		void printList() {
			Node n = head;
			System.out.print(n.data);
			while (n.next != null) {
				System.out.print(n.next.data);
				n = n.next;
			}
			System.out.print("\n");
		}

		void removeDuplicates1() {
			Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
			Node n = head;
			table.put(n.data, true);

			while (n.next != null) {
				if (table.containsKey(n.next.data)) {
					n.next = n.next.next;
					System.out.println("1");
				} else {
					table.put(n.next.data, true);
					n = n.next;
					System.out.println("2");
				}
			}
			System.out.println(table.toString());
		}

		void removeDuplicates2() {
			if (head == null) return;
			Node n = head;
			while (n != null) {
				Node j = n;
				while(j.next != null) {
					if (j.next.data == n.data) {
						j.next = j.next.next;
					} else {
						j = j.next;
					}
				}
				n = n.next;
			}
		}

		Node findXfromlast(int fromlast) {
			Node n = head;
			for (int i = 1; i < fromlast; i ++){ 
				if (n.next == null) return null;
				n = n.next;
			}
			Node j = head;
			while (n.next != null) {
				n = n.next;
				j = j.next;
			}
			return j;
		}

		void partition(int i) {
			Node lessThan = null;
			Node moreThan = null;
			Node node = head;
			while (node != null) {
				Node currNext = node.next;

				if (node.data < i) {
					node.next = lessThan;
					lessThan = node;
				} else {
					node.next = moreThan;
					moreThan = node;
				}
				node = next;
			}

			if (lessThan != null)  return moreThan;
			newHead = lessThan;
			while (lessThan.next != null) lessThan = lessThan.next;
			lessThan.next = moreThan;
			return newHead;
		}

		void deleteNode(Node node) {
			node.data = node.next.data;
			node.next = node.next.next;
		}

		class Node {
			Node next;
			int data;

			public Node(int data) {
				this.data = data;
			}
		}
	}
}