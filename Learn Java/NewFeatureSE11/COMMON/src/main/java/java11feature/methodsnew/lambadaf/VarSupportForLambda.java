package java11feature.methodsnew.lambadaf;

import java.util.Arrays;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
 

public class VarSupportForLambda {

	
	public static void main(String[] args) {
	
		List<String> ls = Arrays.asList("1","4",null,"","r4");
		ls.stream().filter((@NonNull var s) -> {
			return !s.isEmpty();
		}).forEach(System.out::println);
	}
	
}
