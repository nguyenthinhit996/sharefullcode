package comparefunctionality.objectcustomize;

public class CompareObjectCustomize {

	public static void methodCompareObjectCustomize() {
		
		Student a = new Student("a", 10, 10.0f);
		Student b = new Student("a", 10, 10.0f);
		Student c = b;
		
		// false
		if(a==b) {
			System.out.println("a==b");
		}	

		// true
		if(c==b) {
			System.out.println("c==b");
		}
		
		// true
		if(c.equals(b)) {
			System.out.println("c.equals(b)");
		}

		// false
		if(a.equals(b)) {
			System.out.println("a.equals(b)");
		}
		
		//not availiable must implements Comparable
		//if(a.compareTo(b)) {
		//	System.out.println("a.compareTo(b)");
		//}
	}
	
	public static void main(String[] args) {
		methodCompareObjectCustomize();
	}
	
}