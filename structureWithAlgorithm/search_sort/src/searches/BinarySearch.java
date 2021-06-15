package searches;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Search by binary with list ordered asc or desc 
 * <br>
 * Best case: (1) <br>
 * Middle case: log2 (n/2) <br>
 * Worst case : log2(n) <br>
 * @author Peter
 *
 */
public class BinarySearch {

	static Integer SearchByBinary(List<Integer> ls, Integer x) {
		int left = 0;
		int right = ls.size() - 1; // index final of array start 0 , end (size -1)
		while (left <= right) {
			int middle = (left + right) / 2;
			if (x == ls.get(middle)) {
				return middle;
			} else if (x > ls.get(middle)) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Random ran = new Random();
		List<Integer> ls = Stream.iterate(0, i -> i + 1).limit(500).map(s -> {
			return ran.nextInt(100);
		}).sorted(Comparator.nullsFirst(Integer::compareTo)).collect(Collectors.toList());
//		ls.forEach(System.out::println);

		int result = SearchByBinary(ls, 10);
		if (result != -1) {
			System.out.println(result);
		} else {
			System.out.println("not Found");
		}
	}

}
