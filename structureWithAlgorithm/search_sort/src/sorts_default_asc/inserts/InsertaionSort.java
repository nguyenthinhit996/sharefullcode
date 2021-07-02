package sorts_default_asc.inserts;

import sorts_default_asc.TestSortData;

/**
 * Insertion sort insert the elements into correct index of it
 * Best case n-1 
 * Worst case: n(n-1)/2  - 1
 * @author Peter
 *
 */
public class InsertaionSort {

	static void sortByIntertionSort(Integer[] arr) {
		// suppose a[0] has ordered , we import the elements from a[1] to a[length -1] into array has ordered
		for (int i = 1; i < arr.length; i++) {
			 int valueCurrent = arr[i];
			 int l = i - 1; // check index from i-1 to head of array
			 while(l >= 0 && arr[l] > valueCurrent) {  // if index l >= 0 and value of index l > currentIndex, we move right it one
				 // move the element to right one step 
				 arr[l+1] = arr[l];
				 l--; // continue check the top array
			 }
			 arr[l+1] = valueCurrent; // index need insert
		}
	}

	public static void main(String[] args) {

		sortByIntertionSort(TestSortData.ARRAY);
		TestSortData.printArray();
	}
}
