import java.util.*;

public class QuickSortImplementation {
	public static void main(String[] args) {
		QuickSortImplementation tester = new QuickSortImplementation();
		int[] array = {3,5,2,4,1,6};
		tester.quickSort(array, 0, 5);
		System.out.println(Arrays.toString(array));
	}

	public void quickSort(int[] array, int start, int end) {
		int pivotPoint = partition(array, start, end);
		if (start < pivotPoint - 1) quickSort(array, start, pivotPoint - 1);
		if (end > pivotPoint) quickSort(array, pivotPoint, end);		
	}

	public int partition(int[] array, int leftCounter, int rightCounter) {
		int pivot = array[(leftCounter + rightCounter) / 2];
		while (leftCounter <= rightCounter) {
			while (array[leftCounter] < pivot) leftCounter ++;
			while (array[rightCounter] > pivot) rightCounter --;
			
			if (leftCounter <= rightCounter) {
				int temp = array[leftCounter];
				array[leftCounter ++] = array[rightCounter];
				array[rightCounter --] = temp;
			}
		}
		return leftCounter;
	}
}