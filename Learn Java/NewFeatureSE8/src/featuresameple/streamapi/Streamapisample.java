package featuresameple.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Streamapisample {
	
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		for (String in : myList) {
			System.out.println(" " + in);
		}

		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		for (String in : myList) {
			System.out.println(" - " + in);
		}
		
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    }).forEach(s-> System.out.println("for: " + s));
		
		System.out.println("--------------------------------");
		
		Stream.of("aa2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
		System.out.println("--------------------------------");
		
		List<AAA> persons =
			    Arrays.asList(
			        new AAA("Max", 18),
			        new AAA("Peter", 23),
			        new AAA("Pamela", 23),
			        new AAA("David", 12));
		
		Collector<AAA, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> {
			        	 System.out.println("j: " + j);
			        	 System.out.println("p: " + p);
			        	 j.add(p.name.toUpperCase());
			        },  // accumulator
			        (j1, j2) ->   
			        	 
			        	j1.merge(j2) 
					 ,               // combiner
			        StringJoiner::toString);                // finisher

			String names = persons
			    .stream()
			    .collect(personNameCollector);

			System.out.println(names); 
	}
}

class AAA {
    String name;
    int age;

    AAA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
