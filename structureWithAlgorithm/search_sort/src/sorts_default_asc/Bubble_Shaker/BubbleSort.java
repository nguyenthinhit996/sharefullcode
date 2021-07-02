package sorts_default_asc.Bubble_Shaker;

import sorts_default_asc.TestSortData;

/**
 * Bubble sort check from tail to head , compare couple element give element smaller to header of array
 * 
 * Best Case = Worst Case = n(n-1)/2
 * @author Peter
 *
 */
public class BubbleSort {

	static void sortBubbleSort(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) { // int i = 0
			for (int j = arr.length - 1; j > i; j--) { // browse tail to head array 
				if (arr[j] < arr[j - 1]) { // compare couple get small value bring it to head array 
					Integer temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		sortBubbleSort(TestSortData.ARRAY);
		TestSortData.printArray();
	}
}
