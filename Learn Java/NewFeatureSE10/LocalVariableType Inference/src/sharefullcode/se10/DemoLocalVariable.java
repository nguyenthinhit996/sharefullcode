package sharefullcode.se10;

import java.util.List;

public class DemoLocalVariable {

	static void declareVariableLocal() {
		var str = "this is var variable";
		String str2 = "this is var variable";

		var nameVariable; // compile error Cannot use 'var' on variable without initializer

		var ints = 10;
		ints = 10;
		ints = "10"; // compile error Type mismatch: cannot convert from String to int

	}

	void usageVar() {

		var locals = "12345677";

		List<Integer> ls = List.of(1, 2, 3, 5, 67, 8, 84);
		for (var i : ls) {
			System.out.println(i);
		}

		for (var i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i));
		}
	}
}
