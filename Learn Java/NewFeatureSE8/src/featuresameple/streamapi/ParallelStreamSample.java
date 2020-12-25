package featuresameple.streamapi;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamSample {

	
	public static void main(String[] args) {
		// get pool on my computer
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());
		
		Arrays.asList("a1","b1","c1","d1","e1","r1").
		parallelStream().filter(s ->{
			System.out.format("filter: %s [%s] \n", s, Thread.currentThread().getName());
			return true;
		}).map(s ->{
			System.out.format("map   : %s [%s] \n", s, Thread.currentThread().getName());
			 return s.toUpperCase();
		}).sorted((s1,s2) ->{
			System.out.format("sorted: %s <> %s [%s] \n", s1, s2, Thread.currentThread().getName());
			return s1.compareTo(s2);
		}).forEach(s ->{
			System.out.format("foreach: %s [%s] \n", s, Thread.currentThread().getName());
		});
	}
}
