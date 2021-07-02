package java11feature.methodsnew.strings;

public class StringNewFeature {

	// repeat 5 times a : aaaaa
	static void repeatString() {
		String strRepeat = "a".repeat(5);
		System.out.println(strRepeat);
	}

	// removed whitespace leading and tailing , it is aware of Unicode whitespace
	// characters (\u2005)
	static void tripLeadAndTail() {
		String strRaw = "   a  \u2005";
		String strTrip = strRaw.strip();
		// output: "a"
		System.out.println("use trip: " + strTrip);

		// trim not consider ‘\u2005′ a whitespace character.
		// output: "a "
		String strTrim = strRaw.trim();
		System.out.println("use trim: " + strTrim);

	}

	// The isBlank() instance method returns true if the string is empty or contains
	// only whitespace. Otherwise, it returns false:
	static void isBlankCheck() {

		String strBlank = "";
		String strOnlyWhitespaces = "      ";
		String strOnlyNull = null;
		// true
		if (strBlank.isBlank()) {
			System.out.println("str Blank: True");
		}

		// true
		if (strOnlyWhitespaces.isBlank()) {
			System.out.println("strOnlyWhitespaces: True");
		}

		// nullpointerException
//		if(strOnlyNull.isBlank()) {
//			System.out.println("strOnlyNull: True");
//		}

	}

	// lines return a stream extracted from the string , separated by line
	// terminators (“\n”, “\r”, or “\r\n”.)
	static void getStreamFromlines() {
		String strRaw = "This is\n \n a multiline\n string. \r test slashr \r\n test slash r n";
		strRaw.lines().forEach((s) -> {
			System.out.println(s + ":" + s.length());
		});
	}

	public static void main(String[] args) {
		repeatString();
		tripLeadAndTail();
		isBlankCheck();
		getStreamFromlines();
	}
}
