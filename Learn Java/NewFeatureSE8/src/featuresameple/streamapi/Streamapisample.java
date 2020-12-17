package featuresameple.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streamapisample {

	void recipe() {
		// reuse stream
		Supplier<Stream<String>> stream2 = () -> {
			return Arrays.stream(new String[] { "1", "1", "5", "1", "1" });
		};

		System.out.println("--------------average-----------------");
		// average
		stream2.get().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);

		System.out.println("--------------max-----------------");
		int max = stream2.get().mapToInt(Integer::parseInt).max().getAsInt();
		System.out.println(max);

		System.out.println("--------------mapToObj-----------------");
		stream2.get().mapToInt(Integer::parseInt).mapToObj(s -> "str" + s).forEach(System.out::println);
	}

	static void imtermediateOnlyExcuteNotPresent() throws IOException {
		// create stream
		Path path=Paths.get("readobject");
		Supplier<Stream<String>> streamDemo = () -> {
			try {
				return Files.lines(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		};
		
		//demo imtermediate, not appearance thing
		System.out.println("------------ only imtermediate------------------");
		streamDemo.get().filter(s -> {
			 if(s.contains("a1")) {
				 System.out.println("filter 1: "+s);
				 return true;
			 }
			 return false;
		});
		
		// demo imtermediate with terminal, it appearance imtermediate and terminal
		System.out.println("-------------imtermediate with terminal-----------------");
		streamDemo.get().filter(s -> {
			 if(s.contains("a1")) {
				 System.out.println("filter 2: "+ s);
				 return true;
			 }
			 return false;
		}).forEach(System.out::println);
	
	}
	
	static void imtermediateOnlyExcuteNotPresent2() {
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });

	}
	
	static void notOptimized() {
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	}
	
	static void optimized() {
		Stream.of("d2", "a2", "b1", "b3", "c")
	    
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	}
	
	public static void main(String[] args) throws IOException {
		optimized();
	}
}
