package featuresameple.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamImatermediateOperations {
	
	static List<Personz> personsList =
		    Arrays.asList(
		        new Personz("Max" ),
		        new Personz("rrMax" ),
		        new Personz("Peter", 23),
		        new Personz("Pamela", 23),
		        new Personz("David", 12));
	
	public static void main(String[] args) {
		SteamImatermediateOperations newObjectExample= new SteamImatermediateOperations();
		newObjectExample.sortedWithListAndStream();
	}
	
	void mapAndFilter() {
		System.out.println("\n-----------use Map---------------");
		// use Map, change value of element
		Stream<Integer> streamMapFromList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamMapFromList.map(num -> num * 2).forEach(s -> System.out.print(s + " "));

		System.out.println("\n-----------filter method---------------");

		// filter method, filter value
		Stream<Integer> streamFilterFromList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamFilterFromList.filter(s -> {
			if (s % 2 == 0) {
				return true;
			}
			return false;
		}).forEach(s -> System.out.print(s + " "));
	}
	
	 void sortedWithListAndStream() {
		 System.out.println("\n------------sorted ascending default--------------");
			// sorted ascending default
			Stream<Integer> streamSortedFromList = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
			streamSortedFromList.sorted().forEach(s -> System.out.print(s + " "));
			
			System.out.println("\n------------ No custom sorted decrease--------------");
			Stream<Integer> streamSortedFromList2 = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
			streamSortedFromList2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));

			System.out.println("\n------------ custom sorted decrease--------------");
			Stream<Integer> streamSortedDecreaseFromList = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
			streamSortedDecreaseFromList.sorted((o1, o2) -> {
				if (o1 < o2) {
					return 1;
				}
				return -1;
			}).forEach(s -> System.out.print(s + " "));
			
			System.out.println("\n------------customize sorted decrease--------------");
			System.out.println("------------ List NOT Sorted--------------");
			personsList.stream().forEach(foreachCustom);
			//personsList.sort(compareDecreaseByAgeIngoreBull);
			List<Personz> newListSorted=  personsList.stream().sorted(compareDecreaseByAgeIngoreBull).collect(Collectors.toList());
		 System.out.println("------------ Non List Sorted nullsLast--------------");
		 personsList.forEach(foreachCustom);
			System.out.println("------------ List Sorted nullsLast--------------");
			newListSorted.forEach(foreachCustom);
	 }
	
	// ------------------- Function additions ---------------------
	static Consumer<Personz> foreachCustom = (in) -> {
		System.out.println(in.getName() +" age: "+ in.getAge());
	};
 
	// error with age is null
	static Comparator<Personz> compareDecreaseByAge = (o1,o2) ->{
		return Integer.compare(o1.getAge(), o2.getAge());
	};
	
	// by error with age is null
	static Comparator<Personz> compareDecreaseByAgeIngoreBull = 
			Comparator.comparing(Personz::getAge,Comparator.nullsLast(Integer::compareTo));
	 
}


 