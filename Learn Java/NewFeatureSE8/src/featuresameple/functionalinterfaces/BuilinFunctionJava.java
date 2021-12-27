package featuresameple.functionalinterfaces;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuilinFunctionJava {
	
	 

	public static void main(String[] args) {
		Function<Integer, Integer> sum = (value) -> value + 1;
		Integer resultLambda = sum.apply(1);
		System.out.println("resultLambda = " + resultLambda);
		
		Predicate<Integer> isNotNull= (value) -> value != null;
		System.out.println(isNotNull.test(null));
		 
		UnaryOperator<Point> unaryOperator = (point) -> { point.x= 1; point.y= 1; return point; };
		unaryOperator.apply(null);
		
		BinaryOperator<Point> binaryOperator =
		        (point1, point2) -> { point1.add(point2); return point1; };
		        binaryOperator.apply(null, null);
		
		        
		Supplier<Integer> sss = new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		Supplier<Integer> sss2 = () -> {return Integer.valueOf(0);};
		sss2.get();
		
		Consumer<Integer> consumer = (Integer s) -> {
			System.out.println(s);
		};
		
		consumer.accept(6);
		
		A a = new A();
		System.out.println(a.apply(10));
	}
	 
}

class A implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer t) {
		// TODO Auto-generated method stub
		return t*10;
	}
	
}

class Point {
	int x;
	int y;
	Point add(Point a) {
		//a+this
		return null;
	}
}

 