package commonfeaturesse9.collectionfactory;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class DemoImmutableCollection {
	
	static void DemoListImmutable() {
		System.out.println("------List immutable-------");
		List<String> ls = List.of("1","2","55","9");
		System.out.println(ls);
	}
	
	static void DemoSetImmutable() {
		System.out.println("-------Set immutable------");
		Set<String> setString = Set.of("1","2","55","9");
		System.out.println(setString);
	}
	
	static void DemoMapImmutable() {
		System.out.println("-------Map immutable-------");
		Map<String, String> map = Map.of("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
		System.out.println(map);
		
	}
	
	public static void main(String[] args) {
		DemoListImmutable();
		DemoSetImmutable();
		DemoMapImmutable();
	}
}
