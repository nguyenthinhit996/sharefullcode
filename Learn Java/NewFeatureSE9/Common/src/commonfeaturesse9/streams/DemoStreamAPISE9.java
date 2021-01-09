package commonfeaturesse9.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreamAPISE9 {

	static List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	static List<Integer> listDemoTakeWhile2 = List.of(2, 4, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	/**
	 * [] because to stop when it get unmatch number 1 unmatch predicate
	 */
	static void demoTakeWhile() {
		List<Integer> list2 = list.stream().takeWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
		System.out.println(list2);
	}

	/**
	 * // [2, 4, 2] stop index third element
	 */
	static void demoTakeWhile2() {
		List<Integer> list2 = listDemoTakeWhile2.stream().takeWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
		System.out.println(list2);
	}

	/**
	 * // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	 */
	static void demoDropWhile() {
		List<Integer> list2 = list.stream().dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
		System.out.println(list2);
	}

	/**
	 * // [3, 4, 5, 6, 7, 8, 9, 10] return remain element of stream
	 */
	static void demoDropWhile2() {
		List<Integer> list2 = listDemoTakeWhile2.stream().dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());
		System.out.println(list2);
	}

	/**
	 * //java.lang.NullPointerException
	 */
	static void demoStreamOfNullable() {
		List<Integer> list222 = Stream.of(2, 2, 3, null, 5, 6, 7, 8, 9, 10).filter(i -> (i % 2 == 0))
				.collect(Collectors.toList());
		System.out.println(list222);
	}

	/**
	 * 0
	 */
	static void demoStreamOfNullable2() {
		String aaa = null;
		long resultCount = Stream.ofNullable(aaa).filter(s -> s.contains("z")).count();
		System.out.println(resultCount);
	}

	static void demoIterator() {
		// java se 8 static Stream iterate(final T seed, final UnaryOperator f)
		// java 9 static Stream iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)

		// java 8
		List<Integer> numbers = Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList());
		System.out.println(numbers);

		// java 9
		List<Integer> numbers2 = Stream.iterate(0, i -> i < 10, i -> i + 1).collect(Collectors.toList());
		System.out.println(numbers2);
	}
	

	public static void main(String[] args) {
		demoTakeWhile(); // [] because to stop when it get unmatch number 1 unmatch predicate
		demoTakeWhile2(); // [2, 4, 2] stop index third element
		demoDropWhile(); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		demoDropWhile2(); // [3, 4, 5, 6, 7, 8, 9, 10] return remain element of stream
		// demoStreamOfNullable(); //java.lang.NullPointerException
		demoStreamOfNullable2(); // 0
		demoIterator();
	}
}
