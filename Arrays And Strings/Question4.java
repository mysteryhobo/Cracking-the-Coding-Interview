public class Question4 {
	public static void main(String[] args) {
		System.out.println("answer: " + solution("omg you like food?"));
	}

	public static String solution(String text) {
		int numOfSpaces = 0;
		for (int i = 0; i < text.length(); i ++) {
			if (text.charAt(i) == ' ') numOfSpaces ++; 
		}

		int newStringLength = text.length() + (numOfSpaces * 2); 
		char[] newString = new char[newStringLength];
		for (int i = text.length() - 1; i >= 0; i --) {
			if (text.charAt(i) == ' '){
				newString[-- newStringLength] = '0';
				newString[-- newStringLength] = '2';
				newString[-- newStringLength] = '%';
			} else {
				newString[-- newStringLength] = text.charAt(i);
			}
		}
		return String.valueOf(newString);
	}
}