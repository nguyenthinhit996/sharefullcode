package numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundingValue {

	/**
	 * number use  ceil , floor, round
	 */
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
	
	/**
	 * BigDecimal use setScale
	 */
	static void roudingNumberBigdecimal() {
		
		BigDecimal down = new BigDecimal(5.123452);
		BigDecimal mid = new BigDecimal(5.123455);
		BigDecimal up = new BigDecimal(5.123457);
		
		System.out.println("+++++++++++++++ rounding down including numer positive and nagative+++++++++++++++");
		down = down.setScale(5, RoundingMode.FLOOR);
		System.out.println(down); // 5.12345
		mid = mid.setScale(5, RoundingMode.FLOOR);
		System.out.println(mid); // 5.12345
		up = up.setScale(5, RoundingMode.FLOOR);
		System.out.println(up); // 5.12345
		
		BigDecimal down2 = new BigDecimal(5.123452);
		BigDecimal mid2 = new BigDecimal(5.123455);
		BigDecimal up2 = new BigDecimal(5.123457);

		System.out.println("+++++++++++++++ rounding up including numer positive and nagative +++++++++++++++");
		down2 = down2.setScale(5, RoundingMode.CEILING);
		System.out.println(down2); // 5.12346
		mid2 = mid2.setScale(5, RoundingMode.CEILING);
		System.out.println(mid2); // 5.12346
		up2 = up2.setScale(5, RoundingMode.CEILING);
		System.out.println(up2); // 5.12346
		
	}
	
	/**
	 * Double use DecimalFormat set setRoundingMode
	 */
	static void roudingNnumberInDouble() {
		
		DecimalFormat format = new DecimalFormat("#.00000");
		
		Double down = Double.valueOf(555.123452);
		Double mid = Double.valueOf(5.123455);
		Double up = Double.valueOf(5.123457);
		
		// default RoundingMode.HALF_EVEN; 
		System.out.println("---------------- default RoundingMode.HALF_EVEN ------------------");
		System.out.println(format.format(down)); // 555.12345
		System.out.println(format.format(mid)); //5.12345
		System.out.println(format.format(up)); //5.12346
		
		System.out.println("---------------- default RoundingMode.FLOOR is down------------------");
		format.setRoundingMode(RoundingMode.FLOOR);
		System.out.println(format.format(down)); // 555.12345
		System.out.println(format.format(mid)); //5.12345
		System.out.println(format.format(up)); //5.12345
		
		System.out.println("---------------- default RoundingMode.CEILING is up------------------");
		format.setRoundingMode(RoundingMode.CEILING);
		System.out.println(format.format(down)); //555.12346
		System.out.println(format.format(mid)); //5.12346
		System.out.println(format.format(up)); //5.12346
	} 
	
	public static void main(String[] args) {
		roudingNumber();
		roudingNumberBigdecimal();
		roudingNnumberInDouble();
	}

}
