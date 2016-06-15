public class MergeSortImplmentation {
	public static void main(String[] args) {
		MergeSortImplmentation tester = new MergeSortImplmentation();
		int[] array = {4,2,5,1,3,6};
		tester.mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	public void mergeSort (int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length -1);
	}

	public void mergeSort (int[] target, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(target, helper, low, middle);
			mergeSort(target, helper, middle + 1, high);
			merge(target, helper, low, middle, high); 
		}
	}

	public void merge(int[] target, int[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i ++) {
			helper[i] = target[i];
		}

		int helperleft = low;
		int helperRight = middle + 1;
		int current = low;

		while (helperleft <= middle && helperRight <= high) {
			if (helper[helperleft] <= helper[helperRight]) target[current] = helper[helperleft ++];
			else target[current] = helper[helperRight ++];
			current ++;
		}

		while (helperleft <= middle) target[current ++] = helper[helperleft ++];

		// int remaining = middle - helperleft;
		// 	for (int i = 0; i <= remaining; i++) {
		// 	target [current + i] = helper[helperleft + i];
		// }
	}
}