package sorts_default_asc.Bubble_Shaker;

import sorts_default_asc.TestSortData;

/**
 * Shaker Sort improve algorithm Bubble bring element max to tail array quickly than Bubble, Bubble only bring value smaller to head
 * Go: (tail to head) bring value small to head 
 * Return: (head to tail) bring value bigger to tail
 * @author Peter
 *
 */
public class ShakerSort {
	
	static void sortShakerSort(Integer[] arr) {
 
		int left = 0;
		int right = arr.length -1;
		int indexKeep = 0;
		
		while(left < right) { // Go tail to head give element small to head
			for(int j = right; j > left ; j --) { // start in right, after right it has order
				if(arr[j] < arr[j-1]) { // compare the couples give value small bring small to head
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					indexKeep = j; // update left index
				}
			}
			left = indexKeep;
			for(int j = left; j < right ; j ++) { // start in index left because before left has order.
				if(arr[j] > arr[j+1]) { // compare the couples give value bigger bring bigger to tail
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					indexKeep = j;
				}
			}
			right = indexKeep; // update right index
		}
	}

	public static void main(String[] args) {
		sortShakerSort(TestSortData.ARRAY);
		TestSortData.printArray();
	}
}
