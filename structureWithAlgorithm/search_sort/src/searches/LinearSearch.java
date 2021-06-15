package searches;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * Search Linear Check x with every element in array if found return x else
 * return -1.
 * </p>
 * <br>
 * Best case: (1) <br>
 * Middle case: (n+1)/2 <br>
 * Worst case : (n+1) <br>
 * 
 * @author Peter
 *
 */

public class LinearSearch {

	
	/**
	 * learn normal
	 * @param ls
	 * @param x
	 * @return index of x in list
	 */
	static Integer learnSearchBasic(List<Integer> ls, Integer x) {
		for (int i = 0; i < ls.size(); i++) {
			if (x == ls.get(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * linear with guards (lính canh)
	 * @param ls
	 * @param x
	 * @return index of x in list
	 */
	static Integer learnSearchWithAdvanced(List<Integer> ls, Integer x) {
		int max = ls.size();
		int index =0;
		ls.add(x); // guards 
		while(true) {
			if(x == ls.get(index)) {
				break;
			}
			index ++;
		}
		if(index == max) {
			return -1;
		}else {
			return index;
		}
	}
	
	public static void main(String[] args) {

		Random ran = new Random();
		List<Integer> ls = Stream.iterate(0, i -> i + 1).limit(50).map(s -> {
			return ran.nextInt(100);
		}).collect(Collectors.toList());
		ls.forEach(System.out::println);

		System.out.println("------learnSearchBasic-----");
		System.out.println(learnSearchBasic(ls, 10)); // test find 10 in list
		
		System.out.println("-----learnSearchWithAdvanced------");
		System.out.println(learnSearchWithAdvanced(ls, 10)); // test find 10 in list
		
	}
}
