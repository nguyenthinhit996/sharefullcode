package featuresameple.streamapi;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Terminal operations, to produce a result or aside-effect
 * 
 * @author Peter
 *
 */
public class StreamTerminalOperation {

	static int mount = 0;

	// reuse stream
	static Supplier<Stream<String>> fruitList = () -> {
		return Arrays.stream(new String[] { "Apple", "Orange", "Strawberry", "As", "stated", " above", "Java stream" });
	};
	
	
	static void terminal_operations_ReturnResult() {
		Stream<String> ss = fruitList.get().filter(element -> {
			System.out.println("mount : " + mount);
			mount++;
			return element.length() > 5 ? true : false;
		});
		
		// that is result
		System.out.println("ss.count(): " + ss.count()); // only call one
	}
	
	static void terminal_operations_Return_Side_effect() {
		
		Stream<String> ss = fruitList.get().filter(element -> {
			System.out.println("mount : " + mount);
			mount++;
			return element.length() > 5 ? true : false;
		});

		// that is side-effect
		ss.forEach(element -> {
			System.out.println(element); // sẽ được gọi ngay nếu filter dc 1 giá trị
		});
	}

	public static void main(String[] args) {
		terminal_operations_ReturnResult();
		System.out.println("--------------------------------------");
		terminal_operations_Return_Side_effect();
		
//		mount : 0
//		mount : 1
//		mount : 2
//		mount : 3
//		mount : 4
//		mount : 5
//		mount : 6
//		ss.count(): 5
//		--------------------------------------
//		mount : 7
//		mount : 8
//		Orange
//		mount : 9
//		Strawberry
//		mount : 10
//		mount : 11
//		stated
//		mount : 12
//		 above
//		mount : 13
//		Java stream
	}
}
