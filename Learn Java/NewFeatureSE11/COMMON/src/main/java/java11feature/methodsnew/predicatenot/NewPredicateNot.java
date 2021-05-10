package java11feature.methodsnew.predicatenot;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class NewPredicateNot {

	@Test
	public static void main(String[] args) {
		List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
		List withoutBlanks = sampleList.stream()
		  .filter(Predicate.not(String::isBlank))
		  .collect(Collectors.toList());
		 
		 assertLinesMatch(withoutBlanks, List.of("Java", "Kotlin"));
	}
}
