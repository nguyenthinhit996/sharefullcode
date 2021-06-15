package sorts_default_asc;

public class TestSortData {

	public static Integer[] ARRAY = {
	 12, 2, 8,5,1,6,4,15
	};
	
	
	public static void printArray() {
		for(int i=0;i<ARRAY.length;i++) {
			System.out.println(ARRAY[i]);
		}
	}
	
	public static void swap(Integer a, Integer b) {
		 int temp = a;
		 a=b;
		 b=temp;
	}
}
