package featuresameple.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <li>statefull : inmediate operation</li>
 * <li>stateless is operation remain</li>
 * <li>side-effect only for terminal operation in class
 * {@link StreamTerminalOperation}</li>
 * <li> order is maintain with list whereas map is not maintain ordere</li>
 * <li> Non-interference : not change structure of source list, but still can change structure of element of source</li>
 * @author Peter
 *
 */
public class StreamAPIAdvance {

	// reuse stream
	static Supplier<Stream<String>> fruitList = () -> {
		return Arrays.stream(
				new String[] { "Apple1", "Orange2", "Strawberry3", "As4", "stated5", " above6", "Java stream7" });
	};

	// reuse stream
	static Supplier<Stream<Map.Entry<String, String>>> fruitListMap = () -> {
		
		Map<String, String> someMap = new HashMap<>();
		someMap.put("Apple1", "1");
		someMap.put("Orange2", "2");
		someMap.put("Strawberry3", "3");
		someMap.put("As4", "4");
		someMap.put("stated5", "5");
		someMap.put("above6", "6");
		someMap.put("Java stream7", "7");

		return someMap.entrySet().stream();
	};

	/**
	 * <li>Statefull the current element depends on the others remain.</li>
	 * <li>inmediate operation : distinct(), sorted(), limit(), skip().</li>
	 *  https://www.logicbig.com/tutorials/core-java-tutorial/java-util-stream/stateful-vs-stateless.html
	 */
	static void stateFullExaple() {
		for (int i = 0; i < 5; i++) {

            List<Integer> seen = new ArrayList<>();
            IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 50);
            int sum = stream.parallel().map(
                //stateful behavioral parameter.
                e -> {
                      if (seen.add(e)) {
                          return e;}
                      else
                          return 0;
                  }).sum();
            System.out.println("seen " + seen);
            System.out.println(seen.stream().collect(Collectors.summarizingInt(s-> s != null ? s : 0 )).getSum());

        }
	}

	/**
	 * State less non share infor of element with remain element map, fillter,
	 * unsorted, peek
	 */
	static void stateLessExample() {
		
	}

	/**
	 * <li>short_circle Intermediate short-circuiting methods: limit(long maxSize)
	 * </li>
	 * <li>Terminal short-circuiting methods: Optional<T> findFirst() Optional<T>
	 * </li>
	 * <li>findAny() boolean anyMatch(Predicate<? super T> predicate) boolean</li>
	 * <li>noneMatch(Predicate<? super T> predicate)</li>
	 */
	static void short_circle() {

		Supplier<Stream<Integer>> supplerStream = () -> {
			return Stream.iterate(0, i -> i + 1);
		};

		Predicate<? super Integer> pre = i -> i != 0 && i % 50 == 0;

		Optional<Integer> op = null;

		Boolean isMatch = false;

		// Intermediate short-circuiting methods: limit(long maxSize)
		supplerStream.get().limit(10).forEach(System.out::println);

		// Terminal short-circuiting methods:
		// findFirst()
		op = supplerStream.get().filter(pre).findFirst();
		System.out.println(op.isPresent() ? "findFirst " + op.get() : "none");

		// findAny()
		op = supplerStream.get().parallel().filter(pre).findAny();
		System.out.println(op.isPresent() ? "findAny " + op.get() : "none"); // may be is number 50 or value any
																				// condition is satisfied

		// anyMatch()
		isMatch = supplerStream.get().anyMatch(pre);
		System.out.println("anyMatch " + (isMatch ? Boolean.TRUE : isMatch));

		// allMatch()
		isMatch = supplerStream.get().allMatch(pre);
		System.out.println("allMatch " + (isMatch ? Boolean.TRUE : isMatch));

		// noneMatch()
		isMatch = supplerStream.get().noneMatch(pre);
		System.out.println("noneMatch " + (isMatch ? Boolean.TRUE : isMatch));
	}

	/**
	 * List or arrays java.util.List the order will be maintained
	 * Map it need not be maintained.
	 */
	static void order() {
		// use 
		fruitList.get().forEach(System.out::println); // maintain ordered
		fruitListMap.get().forEach(System.out::println); // not maintain ordered
	}

	public static void main(String[] args) {
//		short_circle();
//		order();
		stateFullExaple();
	}

}
