package featuresameple.streamapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreams {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		List<Persons> personList= Arrays.asList(
			new Persons("a1", 11),
			new Persons("b1", 12),
			new Persons("c1", 13),
			new Persons("d1", 14),
			new Persons("a2", 11),
			new Persons("b2", 12),
			new Persons("c2", 13),
			new Persons("d2", 14)
		);
		
		Persons[] personArray= {
				new Persons("a1", 11),
				new Persons("b1", 12),
				new Persons("c1", 13),
				new Persons("d1", 14),
				new Persons("a2", 11),
				new Persons("b2", 12),
				new Persons("c2", 13),
				new Persons("d2", 14)
		};
		
		//1 From a Collection via the steam() and parallelStream() methods.
		Stream<Persons> streamFromCollect =personList.stream();
		printStreamPersons(streamFromCollect,"streamFromCollect");
		
		//2 From an array via Arrays.Stream(Object[]).
		Stream<Persons> streamFromArrayStreamObject= Arrays.stream(personArray);
		printStreamPersons(streamFromArrayStreamObject,"streamFromArrayStreamObject");
		
		//3 From static factory methods on the stream classes such as Stream.of(Object[])
		Stream<Persons> streamFromStreamOF= Stream.of(
				new Persons("a1", 11),
				new Persons("b1", 12),
				new Persons("c1", 13),
				new Persons("d1", 14),
				new Persons("a2", 11),
				new Persons("b2", 12),
				new Persons("c2", 13),
				new Persons("d2", 14)
				);
		printStreamPersons(streamFromStreamOF, "streamFromStreamOF");
		
		//,  IntStream.range(int min, int max)
		IntStream streamFromInStream= IntStream.range(1, 10);
		streamFromInStream.forEach(s -> System.out.print(s+" "));
		
		 System.out.println();
		//, Stream.iterate(Object, UnaryOperator).
		Stream.iterate(0, n -> n + 1).limit(10).
				forEach(s -> System.out.print(s+" "));
	
		System.out.println("\n--------------- BufferedReader -----------------");
		//4 The lines of the file can be obtained from BufferedReader.lines().
		@SuppressWarnings("resource")
		BufferedReader buffereader = new BufferedReader(new FileReader("readobject"));
		Stream<String> streamFromBufferedReader = buffereader.lines();
		streamFromBufferedReader.forEach(s -> System.out.println(s+" "));
		
		System.out.println("\n--------------- streamFromFiles -----------------");
		//5 Streams of file paths can be obtained from methods in Files.
		Path path = Paths.get("readobject");
		Stream<String> streamFromFiles = Files.lines(path);
		streamFromFiles.forEach(s -> System.out.println(s+" "));
		
		System.out.println("\n--------------- streamFromRandomNumbers -----------------");
		//6 Stream of random numbers can be obtained from random.ints() 
		Random ran= new Random();
		IntStream streamFromRandomNumbers = ran.ints(10,1,10) ; //size 10, min 1, max 10
		streamFromRandomNumbers.forEach(s -> System.out.print(s+" "));
		
		System.out.println("\n--------------- streamFromsplitAsStream -----------------");
		//Pattern.splitAsStream(CharSequence) 
		String str = "a1,a2,a3,a4,a,5,a5";
		Stream<String> streamFromsplitAsStream = 
				Pattern.compile(",").splitAsStream(str);
		streamFromsplitAsStream.forEach(s -> System.out.print(s+" "));

	}
	
	static void printStreamPersons(Stream<Persons> s, String title) {
		System.out.println("------------- "+title+" ----------------");
		s.forEach(el -> {
			System.out.println("name: "+ el.getName()+" age: " + el.getAge());
		});
	}
}

class Persons{
	
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	Persons(String name, int age){
		this.name=name;
		this.age=age;
	}
}