package hackarank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HackarankJavaBasic {

	// check balance string
	// {}() true
	// ({()}) true
	// {}) false

	final static Map<String, String> MAP_UNICODE = Map.of(
			"(", ")"
			, "{", "}"
			, ")", "("
			, "}", "{");

	static Boolean checkCharacter(char charKey, char charValue) {
		if (MAP_UNICODE.get(String.valueOf(charKey)).equals(String.valueOf(charValue))) {
			return true;
		}
		return false;
	}

	static String balanceBinary(int l, int r, String s) {
		if (s.length() == 0) {
			return "false";
		}
		while (l <= r) {
			if (!checkCharacter(s.charAt(l), s.charAt(r))) {
				int mid = s.length() / 2;
				if (s.length() % 2 == 0 && mid > 1) {
					String resultLeft = balanceBinary(0, mid - 1, s.substring(0, mid));
					String resultRight = balanceBinary(0, mid - 1, s.substring(mid, s.length()));
					if (resultLeft.equals("false") || resultRight.equals("false")) {
						return "false";
					} else {
						return "true";
					}
				} else {
					return "false";
				}
			}
			l++;
			r--;
		}
		return "true";
	}

	static String balanceString(String str) {
//		System.out.println(str);
		return balanceBinary(0, str.length() - 1, str);
	}

	public static void main(String[] args) {
		
		// create test full 100 input
		String input[] = { "{", "}", "(", ")", "{", "}", "(", ")" }; // {} () {} ()
		Random ran = new Random();
		List<String> strJoiner = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			Integer numberCharacter = ran.nextInt(20); // 0 - 20 chacter;
			StringBuilder builder = new StringBuilder();
			for (int i1 = 0; i1 < numberCharacter; i1++) {
				int index = ran.nextInt(7); // 0- 7
				builder.append(input[index]);
			}
			strJoiner.add(builder.toString());
		}

		strJoiner.stream().forEach(s -> {
			if("true".equals(balanceString(s))) {
				System.out.println(s);
			}
		});

	}

}
