package sorts_default_asc.Interchange;

import sorts_default_asc.TestSortData;

/**
 * Change directly the way use sort normal
 * Best case = Worst = n(n-1)/2
 * @author Peter
 *
 */
public class InterchangeSort {

	static void sortByInterchangeSort(Integer[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
				     Integer temp = arr[i];
					 arr[i] = arr[j];
					 arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		sortByInterchangeSort(TestSortData.ARRAY);
		TestSortData.printArray();
	}
}
