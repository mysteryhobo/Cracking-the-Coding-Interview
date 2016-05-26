public class StackQueueTest {
	public static void main(String[] args) {
		StackQueueTest tester = new StackQueueTest();
		Stack stack = tester.new Stack(5);
		stack.push(3);
		stack.push(1);
		stack.push(7);
		stack.push(9);
		stack.printStack();
		System.out.println(stack.min());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.min());
	}

	public class Stack {
		Node top;

		public Stack(int value) {
			top = new Node(value);
			top.min = value;
		}

		public Node pop() {
			if (top == null) return null;
			Node item = top;
			top = top.next;
			return item;
		}

		public void push(int item) {
			Node newTop = new Node(item);
			if (this.min() > item) newTop.min = item;
			else newTop.min = min();
			newTop.next = top;
			top = newTop;
		}

		public Node peek() {
			return top;
		}

		public int min() {
			if (top == null) return Integer.MAX_VALUE;
			else return peek().min;
		}

		public void printStack() {
			Node n = top;
			while(n != null) {
				System.out.println(n.data);
				n = n.next;
			}
		}

		class Node {
			int data;
			Node next;
			int min;

			public Node(int data){
				this.data = data;
			}
		}
	}

	// public class Queue {
	// 	Node front;
	// 	Node back;
	// 	public void queue(int item) {
	// 		if (front == null) {
	// 			front = new Node(item);
	// 			back = front;
	// 		} else {
	// 			back.next = new Node(item);
	// 			back = back.next;
	// 		}
	// 	}


	// 	public int dequeue() {
	// 		if (front == null) return null;
	// 		int data = front.data;
	// 		front = front.next;
	// 		return n;
	// 	}

	// 	class Node {
	// 		int data;
	// 		Node next;

	// 		public Node(int data){
	// 			this.data = data;
	// 		}
	// 	}
	// }
}