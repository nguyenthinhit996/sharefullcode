package numbers;

public class RoundingValue {

	static void roudingNumber() {
		
		float down = 5.3f;
		float mid = 5.5f;
		float up = 5.7f;
		
		// ceil rounding up return double
		System.out.println(Math.ceil(down)); //6.0
		System.out.println(Math.ceil(mid)); //6.0
		System.out.println(Math.ceil(up)); //6.0

		// floor rounding down return double
		System.out.println(Math.floor(down)); //5.0
		System.out.println(Math.floor(mid)); //5.0
		System.out.println(Math.floor(up)); //5.0

		// round
		System.out.println(Math.round(down)); //5
		System.out.println(Math.round(mid)); //6
		System.out.println(Math.round(up)); //6

	}
	
	public static void main(String[] args) {
		roudingNumber();
	}

}
