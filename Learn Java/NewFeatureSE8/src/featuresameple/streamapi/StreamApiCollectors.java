package featuresameple.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiCollectors {

	List<Personz> persons =
		    Arrays.asList(
		        new Personz("Max", 18),
		        new Personz("Peter", 23),
		        new Personz("Pamela", 23),
		        new Personz("David", 12));
	
	
	 

	void customCollectorAdvanced() {

		CollectersCustom aa=new CollectersCustom();
		List<String> personList= persons.stream().collect(aa);		
		System.out.println(personList);
		
	}
	
	void customCollectorsSimple() {
		
		//StringJoiner  StringJoiner is used to construct a sequence of characters separatedby 
		//a delimiter and optionally starting with a supplied prefixand ending with a supplied suffix. 
		Collector<Personz, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" ? "), // supplier
			        (j, p) -> {
			        	System.out.println("--------------------");
			        	System.out.println("j " + j);
			        	System.out.println("p " + p.getName());
			        	j.add(p.getName());
			        },  // accumulator
			        (j1, j2) -> j1.merge(j2) ,   // combiner
			        StringJoiner::toString);    // finisher
		
		String chainStringAge = persons.stream().collect(personNameCollector);
		System.out.println(chainStringAge);
	}
	
	public static void main(String[] args) {
		StreamApiCollectors newob= new StreamApiCollectors();
		newob.customCollectorAdvanced();
	}
	
	
	void streamToSingleValue() {
		// ReUse Stream by Supplier
		Supplier<Stream<Personz>> supplierStream = () -> persons.stream();

		// couting
		Long countStream = supplierStream.get().collect(Collectors.counting());
		System.out.println("Counting of Stream: " + countStream);

		// Summarizing Double/Long/Int
		System.out.println("\nIntSummaryStatistics Age of Person");
		IntSummaryStatistics sumAge = supplierStream.get().collect(Collectors.summarizingInt(s -> s.getAge()));
		System.out.println("IntSummaryStatistics getCount: " + sumAge.getCount());
		System.out.println("IntSummaryStatistics sum: " + sumAge.getSum());
		System.out.println("IntSummaryStatistics getMax: " + sumAge.getMax());
		System.out.println("IntSummaryStatistics getMin: " + sumAge.getMin());
		System.out.println("IntSummaryStatistics getAverage: " + sumAge.getAverage());

		// Averaging Double/Long/Int
		System.out.println("\naveragingInt Age of Person");
		Double averageAge = supplierStream.get().collect(Collectors.averagingInt(s -> s.getAge()));
		System.out.println("Collectors.averagingInt Age: " + averageAge);

		// minBy, MaxBy
		System.out.println("\n minBy, MaxBy Age of Person");
		Optional<Integer> max = supplierStream.get().map(s -> s.getAge())
				.collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println("Collectors.MaxBy Age: " + max.get());

		// join return String value, chain string age separated by selemicon
		System.out.println("\n join return String value Age of Person");
		String strAge = supplierStream.get().map(s -> String.valueOf(s.getAge())).collect(Collectors.joining(";"));
		System.out.println("Chain of age: " + strAge);
	}

	
	public void streamToMapUserToMapFullOption() {
		
		List<String> duplicateStringLs=Arrays.asList("A","A","A","r","y","d");
		
		Map<String,String> streamToMap = 
				duplicateStringLs.stream()
				.collect(Collectors.toMap(
						Function.identity()
						,s->s.concat("_val")
						,(value_old,value_new) -> value_old.concat(" "+value_new)));

		streamToMap.forEach((k, v) -> {
			System.out.println("key: " + k + "; value: " + v);
		});
	}
	
	
	// list object person
	void streamToMapUseToMapPerson() {
		Map<Personz, String> streamToMap = 
				persons.stream()
				.collect(Collectors.toMap(Function.identity(), s->s.getName()));

		streamToMap.forEach((k, v) -> {
			System.out.println("key: " + k + " value: " + v.toString());
		});
	}

	
	void streamToMapWithPartitiningAge() {
		Map<Boolean, List<Personz>> streamToMap = 
				persons.stream()
				.collect(Collectors.partitioningBy(s -> s.getAge() > 20 ));

		System.out.println("Partitioning with age > 20 ");
		streamToMap.forEach((k, v) -> {
			System.out.println("key: " + k + " " + v.toString());
		});
	}
	
	void streamtoListSimple() {
		List<String> streamToList = persons
				.stream()
				.map(s -> s.getName().toUpperCase())
				.collect(Collectors.toList());
		streamToList.forEach(System.out::println);
	}
	
	void streamToListAdvanced(){  	
		
		CollectersCustom aa=new CollectersCustom();
		List<String> personList= persons.stream().collect(aa);		
		System.out.println(personList);
		
	}
	
	void streamToSet() {
		
		Set<String> streamToSet = persons
				.stream()
				.map(s -> s.getName().toUpperCase())
				.collect(Collectors.toSet());
		
		streamToSet.forEach(System.out::println);
	}

	void streamToMapWithGroupByAge() {
		Map<Integer, List<Personz>> streamToMap = 
				persons.stream()
				.collect(Collectors.groupingBy(s -> s.getAge()));

		streamToMap.forEach((k, v) -> {
			System.out.println("key: " + k + " " + v.toString());
		});
	}
}


class Personz {
    String name;
    Integer age;

    Personz(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    Personz(String name) {
        this.name = name;
        this.age = null;
    }

    @Override
    public String toString() {
        return name +" "+age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
	
	void abc() {
		System.out.println(this.age+111);
	}
    
	
	 
}

class CollectersCustom implements Collector<Personz, List<String>, List<String>>{

	@Override
	public BiConsumer<List<String>, Personz> accumulator() {
		System.out.println("accumulator");
		 return (list,value) -> {
			 String a = value.getAge() + " " + value.getName();
			 list.add(a);
		 };
	}

	@Override
	public Set<Characteristics> characteristics() {
		System.out.println("characteristics");
		return EnumSet.of(Characteristics.IDENTITY_FINISH);
	}

	@Override
	public BinaryOperator<List<String>> combiner() {
		System.out.println("combiner");
		return (List1, List2) -> {
			 List1.addAll(List2);
			 return List1;
		};
	}

	@Override
	public Function<List<String>, List<String>> finisher() {
		System.out.println("finisher");
		return Function.identity();
	}

	@Override
	public Supplier<List<String>> supplier() {		
		System.out.println("Supplier");
		return ArrayList::new;
	}
}
