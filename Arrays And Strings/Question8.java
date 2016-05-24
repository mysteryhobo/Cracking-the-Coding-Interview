public class Question8 {
	public static void main(String[] args) {
		System.out.println("result: " + Boolean.valueOf(solution("waterbottle", "erbottlewat")).toString());
	}

	public static boolean solution(String text1, String text2) {
		StringBuilder newString = new StringBuilder(text1);
		text1 = newString.append(text1).toString();
		return text1.isSubstring(text2);
	}
}