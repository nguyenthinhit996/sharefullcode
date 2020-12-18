package featuresameple.streamapi;

import java.util.Arrays;
import java.util.stream.Stream;

public class SteamImatermediateOperations {

	public static void main(String[] args) {

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

		System.out.println("\n------------sorted ascending default--------------");
		// sorted ascending default
		Stream<Integer> streamSortedFromList = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamSortedFromList.sorted().forEach(s -> System.out.print(s + " "));

		System.out.println("\n------------sorted decrease--------------");
		// sorted decrease
		Stream<Integer> streamSortedDecreaseFromList = Arrays.asList(111, 1, 2, 3, 4, 5, 6, 7, 8, 89).stream();
		streamSortedDecreaseFromList.sorted((o1, o2) -> {
			if (o1 < o2) {
				return 1;
			}
			return -1;
		}).forEach(s -> System.out.print(s + " "));
	}
}
