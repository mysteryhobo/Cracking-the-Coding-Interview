public class Question5 {
	public static void main(String[] args) {
		System.out.println("Result: " + compressString("aabcccccaaa"));
	}

	public static String compressString(String orginal) {
		char currChar = orginal.charAt(0);
		int currCount = 1;
		StringBuilder newString = new StringBuilder();
		for (int i = 1; i < orginal.length(); i ++) {
			if (currChar != orginal.charAt(i)) {
				newString.append(currChar);
				if (currCount != 1) newString.append(currCount);
				currCount = 1;
				currChar = orginal.charAt(i);
			} else {
				currCount ++;
			}
		}
		return newString.append(currChar).append(currCount).toString();
	}
}