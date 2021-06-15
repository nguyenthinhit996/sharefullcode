package sorts_default_asc.QuickSort;

import sorts_default_asc.TestSortData;

/**
 * Quick Sort dependent on value middle and check couple violate to swap 
 * Best Case: nlog2(n)
 * Middle Case: nlog2(n)
 * Worst Case: n^2
 * @author Peter
 *
 */
public class QuickSort {

	static void sortByQuickSort(Integer[] arr, int left, int right) {

		int i=left; // sort start with left
		int j=right; // sort bound is right
		int mid = (left+right) / 2; // get value middle array
		do {
			while(arr[mid] > arr[i]) { i++; } // check condition before mid is always smaller middle
			while(arr[mid] < arr[j]) { j--; } // check condition after mid is always bigger middle
			if(i <= j) { // appearance couple incorrect condition swap it
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++; // skip in current index next index
				j--; // skip in current index next index
			}		
		} while(i < j); 
		if(left < j) {
			sortByQuickSort(arr,0,j); // slipt array smaller paragraph from before value middle
		}
		if(i<right) {
			sortByQuickSort(arr,i,right); // slipt array smaller paragraph from after value middle
		}
	}

	public static void main(String[] args) {

		sortByQuickSort(TestSortData.ARRAY,0,TestSortData.ARRAY.length -1);
		TestSortData.printArray();
	}

}
