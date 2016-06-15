import java.util.*;

public class Question2 { //Anagram sort
	public static void main(String[] args) {
		Question2 tester = new Question2();
		String[] list = {"arm", "bat", "peter", "ram", "john", "tab", "mouse"};
		String[] list2 = new String[list.length];
		System.arraycopy(list, 0 , list2, 0, list.length);
		tester.anagramSort(list);
		tester.solution2(list2);
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(list2));
	}

	public void anagramSort(String[] list) {
		String[] temp = new String[list.length];
		anagramSort(list, temp, 0, list.length - 1);
	}

	public void anagramSort(String[] list, String[] temp, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2; 
			anagramSort(list, temp, start, middle);
			anagramSort(list, temp, middle + 1, end);
			merge(list, temp, start, middle, end);
		}
	}

	public void merge(String[] list, String[] temp, int start, int middle, int end) {
		for (int i = start; i <= end; i ++) {
			temp[i] = list[i];
		}

		int totalCounter = start;
		int leftCounter = start;
		int rightCounter = middle + 1;

		while (leftCounter <= middle && rightCounter <= end) {
			if (sort(temp[leftCounter]).compareTo(sort(temp[rightCounter])) <= 0) list[totalCounter] = temp[leftCounter ++];
			else list[totalCounter] = temp[rightCounter ++];
			totalCounter ++;
		}

		while (leftCounter <= middle) list[totalCounter ++] = temp[leftCounter ++];

		//todo addd rest of left side
	}

	public String sort(String unSortedterm) {
		char[] term = unSortedterm.toCharArray();
		Arrays.sort(term);
		return new String(term);
	}

	// public class AnagramComparator implements Comparator<String> {
		

	// 	public int compare(String string1, String string2) {
	// 		return sortChars(string1).compareTo(sortChars(string2));
	// 	}
	// }

	public String sortChars(String unSortedterm) {
			char[] term = unSortedterm.toCharArray();
			Arrays.sort(term);
			return new String(term);
		}

	public void solution2(String[] list) {
		Hashtable<String, LinkedList<String>> hashtable = new Hashtable<String, LinkedList<String>>();
		for (String currTerm : list) {
			String key = sortChars(currTerm);
			if (!hashtable.containsKey(key)) hashtable.put(key, new LinkedList<String>());
			LinkedList<String> anaGrams = hashtable.get(key);
			anaGrams.push(currTerm); 
		}

		int index = 0;
		for (String currKey : hashtable.keySet()) {
			LinkedList<String> currlist = hashtable.get(currKey);
			for (String currTerm : currlist) list[index ++] = currTerm;
		}	
	}
}