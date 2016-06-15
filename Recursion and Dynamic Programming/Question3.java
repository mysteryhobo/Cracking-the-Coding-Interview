public class Question3 {
	public int[] array = {0, 0, 2, 4, 9, 10, 11};
	public static void main (String[] args) {
		Question3 tester = new Question3();
		System.out.println(tester.findMagicindex(0, tester.array.length - 1));
	}

	public int findMagicindex(int min, int max) {
		if (min > max) return -1;
		int middle = (max + min)/2;
		System.out.println(middle);
		if (array[middle] > middle) return findMagicindex(min, middle - 1);
		else if (array[middle] < middle) return findMagicindex(middle + 1, max);
		else return middle;
	}	
}