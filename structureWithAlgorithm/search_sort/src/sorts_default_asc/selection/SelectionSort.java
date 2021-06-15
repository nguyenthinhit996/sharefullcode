package sorts_default_asc.selection;

import sorts_default_asc.TestSortData;

/**
 * SelectionSort choose min and give it into head array Best case n(n-1) / 2
 * Worst case n(n-1) / 2
 * 
 * @author Peter
 *
 */
public class SelectionSort {

	static void sortBySelectionSort(Integer[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int min = i;
			// find min in current arr from i to lẹngth
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			// swap min with i
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

	public static void main(String[] args) {

		sortBySelectionSort(TestSortData.ARRAY);
		TestSortData.printArray();
	}

}
