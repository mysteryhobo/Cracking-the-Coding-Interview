import java.util.ArrayList;

public class Question3 {
	public static void main(String[] args) {
		Question3 tester = new Question3();
		StackofStacks stacks = tester.new StackofStacks(5);
		stacks.printStacks();
		stacks.push(7);
		stacks.printStacks();
		stacks.push(4);
		stacks.printStacks();
		stacks.push(1);
		stacks.printStacks();
		stacks.push(9);
		stacks.printStacks();
		stacks.popAt(0);
		stacks.printStacks();
		stacks.push(8);
		stacks.printStacks();
		stacks.pop();
		stacks.printStacks();
		stacks.pop();
		stacks.printStacks();
		stacks.pop();
		stacks.printStacks();
	}

	class StackofStacks {
		int lowestUnfilledStack = 0;
		ArrayList<Stack> stacks = new ArrayList<Stack>();

		public StackofStacks(int value) {
			Stack newStack = new Stack();
			newStack.push(value);
			stacks.add(newStack);
		}

		public void push(int value) {
			if (!stacks.get(lowestUnfilledStack).push(value)) {
				while (lowestUnfilledStack < stacks.size() - 1) {
					lowestUnfilledStack ++;
					if (!stacks.get(lowestUnfilledStack).atLimit()) {
						stacks.get(lowestUnfilledStack).push(value);
						return;
					}
				}
				Stack newStack = new Stack();
				newStack.push(value);
				stacks.add(newStack);
				lowestUnfilledStack ++;
			}
		}

		public Stack.Node pop() {
			if (stacks.size() == 0) return null;
			Stack currStack = stacks.get(stacks.size() - 1);
			Stack.Node poped = currStack.pop();
			if (currStack.count == 0) stacks.remove(currStack);
			return poped;
		}

		public Stack.Node popAt(int index) {
			if (index >= stacks.size()) return null;
			if (index < lowestUnfilledStack) lowestUnfilledStack = index;
			return stacks.get(index).pop();
		}

		public void printStacks() {
			System.out.println("******************");
			int counter = 0;
			for (Stack stack : stacks) {
				System.out.printf("Stack %d:", counter);
				stack.printStack();
				counter++;
			}
			System.out.println("******************");
		}

		class Stack {
			Node top;
			int limit = 3;
			int count = 0;

			Stack(){}

			Stack(Node top) {
				this.top = top;
			}

			Node pop () {
				if (top != null) {
					Node n = top;
					top = top.next;
					count --;
					return n;
				}
				return null;
			}

			Node peek() {
				return top;
			}

			boolean push(int value) {
				if (count == limit) return false;
				Node n = new Node(value);
				n.next = top;
				top = n;
				count ++;
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

			public boolean atLimit() {
				System.out.println(limit + "," + count);
				return count == limit;
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