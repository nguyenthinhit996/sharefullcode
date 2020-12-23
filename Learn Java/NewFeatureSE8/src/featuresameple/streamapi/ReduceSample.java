package featuresameple.streamapi;

import java.util.Arrays;
import java.util.List;

public class ReduceSample {
	List<Personz> persons =
		    Arrays.asList(
		        new Personz("Max", 18),
		        new Personz("Peter", 23),
		        new Personz("Pamela", 29),
		        new Personz("David", 12));
	
	void reduceTypeOne() {
		// Optional<T> reduce(BinaryOperator<T> accumulator) 
		persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println);
	}
	
	void reduceTypeTwo() {
		//T reduce(T identity, BinaryOperator<T> accumulator)
		Personz maxAgeOfPerson = persons.stream().reduce(
				new Personz("",0)
				, (p1, p2) -> {
					p1.setAge(p1.getAge() + p2.getAge());
					p1.setName(p1.getName() + "|" + p2.getName());
					return p1;
				});
		
		System.out.println(maxAgeOfPerson);
	}
	
	void reduceTypeThrid() {
		//<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
		int maxAge= persons.stream().reduce(
				0 // identity
				, (per1 ,per2) -> {  //  accumulator
					return per1+=per2.getAge();
				}
				, (accu1, accu2) -> accu1 + accu2); // combiner
		
		System.out.println("Max age :" +maxAge);
	}
	
	
	public static void main(String[] args) {
		ReduceSample newobject= new ReduceSample();
		newobject.reduceTypeThrid();
		
	 
	}
}
