import java.util.Arrays;

public class Question3 {
	public static void main(String[] args) {
		Question3 tester = new Question3();
		System.out.println("Result: " + Boolean.valueOf(tester.isPermutation("racar", "racecra")).toString());
	}

	public boolean isPermutation(String text1, String text2) {
		if (text1.length() > text2.length()) return false;
		char[] array1 = text1.toCharArray();
		char[] array2 = text2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		return text1.equals(text2);
	}
}