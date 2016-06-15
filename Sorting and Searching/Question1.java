import java.util.*;

public class Question1 {
	private static int[] array1 = {1,2,3,6,8,8,9,0,0,0,0,0};
	private static int[] array2 = {3,4,4,5,7};
	public static void main(String[] args) {
		Question1 tester = new Question1();
		tester.sort(6, array1, array2);
		System.out.println(Arrays.toString(array1));
	}

	public void sort(int array1Pos, int[] array1, int[] array2){
		int array2Position = array2.length - 1;
		for (int totalPosition = array1.length - 1; totalPosition >= 0; totalPosition --) {
			if (array2[array2Position] >= array1[array1Pos]) array1[totalPosition] = array2[array2Position --];
			else array1[totalPosition] = array1[array1Pos --];
			if (array2Position < 0) break;
		} 
	}
}