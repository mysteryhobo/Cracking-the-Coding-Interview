public class Question5 {
	public static void main(String[] args) {
		Question5 tester = new Question5();
		MyQueue myqueue = tester.new MyQueue(3);
	}

	public class MyQueue {
		Stack in = null;
		Stack out = null;

		public MyQueue(int value) {
			Stack in = new Stack(value);
			Stack out = new Stack();
		}

		public void queue(int value) {
			in.push(value);
		}

		public int dequeue() {
			Stack.Node n = out.pop();
			if (n == null) {
				while (in.peek()!= null) {
					out.push(in.pop().data);
				}
				n = out.pop();
			}
			return n.data;
		}

		public void printStacks() {
			System.out.print("in: ");
			in.printStack();
			System.out.print("out ");
			out.printStack();
		}




		public class Stack {
			Node top;

			public Stack(int value) {
				top = new Node(value);
			}

			public Stack(){}

			public Node pop() {
				if (top == null) return null;
				Node item = top;
				top = top.next;
				return item;
			}

			public void push(int item) {
				Node newTop = new Node(item);
				if (top != null) {
				newTop.next = top;
				top = newTop;
				} else {
					top = newTop;
				}
			}

			public Node peek() {
				return top;
			}

			public void printStack() {
				Node n = top;
				while(n != null) {
					System.out.println(n.data);
					n = n.next;
				}
				System.out.print("\n");
			}

			class Node {
				int data;
				Node next;

				public Node(int data){
					this.data = data;
				}
			}
		}
	}
}