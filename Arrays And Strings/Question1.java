import java.util.*;

public class Question1 {
	public static void main(String[] args) {
		Question1 tester = new Question1();
		String text;
		if (args.length == 0) {
			System.out.print("Please enter the String you wish to check:");
			Scanner input = new Scanner(System.in);
			text = input.nextLine();
		} else text = args[0];

		System.out.println("Solution 1: " + Boolean.valueOf(tester.solution1(text)).toString());
		System.out.println("Solution 2: " + Boolean.valueOf(tester.solution2(text)).toString());
		System.out.println("Solution 3: " + Boolean.valueOf(tester.solution3(text)).toString());
	}

	/**
	 * solution to question 1.1 (with data structures)
	 * boolean array could also be used
	 * @param  orginal the original string
	 * @return         true if the string contains all unique characters
	 */
	public boolean solution1(String orginal){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < orginal.length(); i ++) {
			int index = orginal.charAt(i) - 96;
			if (map.get(index) != null) {
				map.put(index, map.get(index) + 1);
				if (map.get(index) > 1) return false;
			} else map.put(index, 1);
		}
		return true;
	}

	/**
	 * Solution to question 1.1 (without data structures)
	 * @param  orginal the original string
	 * @return         true if the string contains all unique characters
	 */
	public boolean solution2(String orginal) {
		if (orginal.length() == 1) return true;
		for (int i = 0; i < orginal.length(); i ++) {
			for (int j = i + 1; j < orginal.length(); j ++) {
				if (orginal.charAt(i) == orginal.charAt(j)) return false;
			}
		}
		return true;
	}

	public boolean solution3(String orginal) {
		orginal = orginal.toLowerCase();
		System.out.println("String: " + orginal);
		int checker = 0;
		for (int i = 0; i < orginal.length(); i ++) {
			int val = orginal.charAt(i) - 'a';
			System.out.println("Value: " + Integer.toBinaryString(val));
			System.out.println("Value: " + Integer.toBinaryString(1));
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		 return true;
	}
}