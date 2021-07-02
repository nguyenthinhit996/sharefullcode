package comparefunctionality.referencebuiltbefore;

public class ReferenceBuiltBeforeJava {

	static Integer a = new Integer(10);
	static Integer b = 10;
	static Integer c = b;

	static void IntegerdataTypeReferenceBuilt_in() {
		// false
		if (a == b) {
			System.out.println("Integer == int");
		}

		// true
		if (c == b) {
			System.out.println("c==b");
		}

		// true
		if (b.equals(a)) {
			System.out.println("b.equals(a)");
		}

		// true
		if (b.compareTo(a) == 0) {
			System.out.println("b.compareTo(a) == 0");
		}
	}

	static String astr = new String("10");
	static String bstr = "10";
	static String cstr = bstr;

	static void StringdataTypeReferenceBuilt_in() {
		// false
		if (astr == bstr) {
			System.out.println("Integer == int");
		}

		// true
		if (bstr == cstr) {
			System.out.println("c==b");
		}

		// true
		if (bstr.equals(astr)) {
			System.out.println("b.equals(a)");
		}

		// true
		if (bstr.compareTo(astr) == 0) {
			System.out.println("b.compareTo(a) == 0");
		}
	}
	
	public static void main(String[] args) {
//		IntegerdataTypeReferenceBuilt_in();
		StringdataTypeReferenceBuilt_in();
	}
}
