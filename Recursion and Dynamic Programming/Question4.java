import java.util.*;
public class Question4 {
	public static void main(String[] args) {
		Question4 tester = new Question4();
		ArrayList<Integer> currentSet = new ArrayList<>();
		ArrayList<Integer> remainingElements = new ArrayList<>();
		remainingElements.add(1);
		remainingElements.add(2);
		remainingElements.add(3);
		// remainingElements.add(4);
		// remainingElements.add(5);
		System.out.println(tester.findSets(currentSet, remainingElements).toString());

	}

	public ArrayList<ArrayList<Integer>> findSets(ArrayList<Integer> currentSet, ArrayList<Integer> remainingElements) {
		ArrayList<ArrayList<Integer>> returnSetOfSets = new ArrayList<>();
		returnSetOfSets.add(currentSet);
		for (Integer currInt : remainingElements) {
			ArrayList<Integer> nextSet = new ArrayList<Integer>();
			nextSet.addAll(currentSet);
			nextSet.add(currInt);
			ArrayList<Integer> newRemaining = new ArrayList<Integer>();
			newRemaining.addAll(remainingElements);
			newRemaining.remove(currInt);
			returnSetOfSets.addAll(findSets(nextSet, newRemaining));
		}
		return returnSetOfSets;
	}
}