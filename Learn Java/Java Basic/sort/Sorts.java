package ttttttttttttt;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sorts{

	
	static void sortFull() {
		System.out.println("\n------------ custom sorted decrease--------------"); // giam dan (max ở đầu)
		Stream<Integer> streamSortedDecreaseFromList = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamSortedDecreaseFromList.sorted((o1, o2) -> {
			if(o1 > o2) { // không sort 
				return -1;
			}
			else if (o1 < o2) { // sort 
				return 1;
			}
			else {
				return 0;
			}
		}).forEach(s -> System.out.print(s + " "));
		 
		
		System.out.println("\n------------ custom sorted acsen--------------"); //tăng dan (max ở cuối)
		System.out.println();
		Stream<Integer> streamSortedDecreaseFromList2 = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamSortedDecreaseFromList2.sorted((o1, o2) -> {
			if (o1 > o2)  { // trước lớn sau thì sort 
				return 1;
			}else if(o1 < o2) { // trước bé hơn sau thì ko sort
				return -1;
			}else {
				return 0; // bằng nhau
			}
		}).forEach(s -> System.out.print(s + " "));
	}
	
	static void sortPart() {
		System.out.println("\n------------ custom sorted decrease--------------"); // giam dan (max ở đầu)
		Stream<Integer> streamSortedDecreaseFromList = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamSortedDecreaseFromList.sorted((o1, o2) -> {
			 if(o2 > o1) {
				 return 1;
			 }
			 return -1;
		}).forEach(s -> System.out.print(s + " "));
		 
		
		System.out.println("\n------------ custom sorted acsen--------------"); //tăng dan (max ở cuối)
		System.out.println();
		Stream<Integer> streamSortedDecreaseFromList2 = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamSortedDecreaseFromList2.sorted((o1, o2) -> {
			 if(o1 > o2) {
				 return 1;
			 }
			 return -1;
		}).forEach(s -> System.out.print(s + " "));
	}
	
	public static void main(String[] args) {
		sortFull();
		sortPart();
	}
}
