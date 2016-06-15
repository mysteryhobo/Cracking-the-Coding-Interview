public class Question6 {
	public static void main(String[] args) {

	}

	public static Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = generateParens(remaining - 1);
			for (String str : prev) {
				for (int i = 0; i < str.lengthQ; i++) {
					if (str.charAt(i) == '(') {
						String s = insertlnside(strj i);
						set.add(s);
					}
				}
				if (!set.contains("()" + str)) {
					set.add("()" + str);
				}
			}
		}
		return set;
	}

	public String insert!nside(String str, int leftlndex) {
		String left = str.substring^, leftlndex + 1);
		String right = str.substring(leftlndex + 1, str.lengthQ);
		return left + "()" + right;
	}
}