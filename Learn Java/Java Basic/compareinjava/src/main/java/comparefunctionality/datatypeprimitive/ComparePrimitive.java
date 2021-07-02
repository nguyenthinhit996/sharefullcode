package comparefunctionality.datatypeprimitive;


public class ComparePrimitive {

	static void comparePrimitvevsPrimitive() {
		int a=10;
		int b=10;
		
		// only use == that compare
		if(a==b) {
			System.out.println("use == ");
		}
	}
	
	static void comparePrimitvevsReference() {
		int a=10;
		Integer b= new Integer(10);
		
		// only use == that compare
		if(a==b) {
			System.out.println("Integer == int");
		}
		
		if(b.equals(a)) {
			System.out.println("b.equals(a)");
		}
		
		if(b.compareTo(a) == 0) {
			System.out.println("b.compareTo(a) == 0");
		}
		 
	}
	
	public static void main(String[] args) {
		//comparePrimitvevsPrimitive();
		comparePrimitvevsReference();
	}
	
}
