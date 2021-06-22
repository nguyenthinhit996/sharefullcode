package hackerank.advances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Liar {

	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		List<Integer> result = new ArrayList<>();
		if (grades.size() > 0) {
			int temp = 0;
			for (Integer element : grades) {
				if (element > 35) {
					temp = element % 5;
					if (temp >= 3) {
						element = element + (5 - temp);
						System.out.println(element);
					}
				}
				result.add(element);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(73,
67,
38,
33);
		System.out.println((gradingStudents(ls)));
		
		List<Student> list = Arrays.asList(
				new Student(1, "1"),
				new Student(2, "2"),
				new Student(3, "3"),
				new Student(4, "4"),
				new Student(5, "5"),
				new Student(6, "6")
				);
		
		List<Student> copy =  list.stream()
				  .skip(1)
				  .collect(Collectors.toList());
		
		
	}
	
	
}

class Student{
	
	private Integer in;
	private String str;
	Student(Integer i, String str){
		this.in = i;
		this.str=str;
	}
	
}