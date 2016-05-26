public class Question6 {
	public static void main(String[] args) {
		Question6 tester = new Question6();
		AscendingStack stack = tester.new AscendingStack(7);
		stack.printStack();
		stack.push(5);
		stack.printStack();
		stack.push(6);
		stack.printStack();
		stack.pop();
		stack.printStack();
	}

	class AscendingStack {
		Stack main;
		Stack secondary;

		public AscendingStack(int value) {
			main = new Stack();
			secondary = new Stack();
			main.push(value);
		}

		public void push(int value) {
			if (value < main.peek()) {
				while (value < main.peek()) {
					secondary.push(main.pop().data);
				}
				main.push(value);
				Stack.Node n;
				while ((n = secondary.pop()) != null) {
					main.push(n.data);
				}
			}
		}

		public Stack.Node pop() {
			return main.pop();
		}

		public int peek() {
			return main.peek();
		}

		public void printStack() {
			main.printStack();
			secondary.printStack();
		}

		

		class Stack {
			Node top;

			Stack(){}

			Stack(Node top) {
				this.top = top;
			}

			Node pop () {
				if (top != null) {
					Node n = top;
					top = top.next;
					return n;
				}
				return null;
			}

			int peek() {
				if (top == null) return Integer.MIN_VALUE;
				return top.data;
			}

			boolean push(int value) {
				Node n = new Node(value);
				n.next = top;
				top = n;
				return true;
			}

			public void printStack() {
				Node n = top;
				while (n != null) {
					System.out.print(n.data);
					n = n.next;
				}
				System.out.print("\n");
			}

			class Node {
				int data;
				Node next;

				public Node(int data) {
					this.data = data;
				}
			}
		}
	}
}