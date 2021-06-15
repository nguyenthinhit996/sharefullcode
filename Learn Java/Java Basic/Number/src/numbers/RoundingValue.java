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
		System.out.println(down);
		mid = mid.setScale(5, RoundingMode.FLOOR);
		System.out.println(mid);
		up = up.setScale(5, RoundingMode.FLOOR);
		System.out.println(up);
		
		BigDecimal down2 = new BigDecimal(5.123452);
		BigDecimal mid2 = new BigDecimal(5.123455);
		BigDecimal up2 = new BigDecimal(5.123457);

		System.out.println("+++++++++++++++ rounding up including numer positive and nagative +++++++++++++++");
		down2 = down2.setScale(5, RoundingMode.CEILING);
		System.out.println(down2);
		mid2 = mid2.setScale(5, RoundingMode.CEILING);
		System.out.println(mid2);
		up2 = up2.setScale(5, RoundingMode.CEILING);
		System.out.println(up2);
		
	}
	
	/**
	 * Double use DecimalFormat set setRoundingMode
	 */
	static void roudingNnumberInDouble() {
		
		Double down = Double.valueOf(5.123452);
		Double mid = Double.valueOf(5.123455);
		Double up = Double.valueOf(5.123457);
		
		// default RoundingMode.HALF_EVEN; 
		System.out.println("---------------- default RoundingMode.HALF_EVEN ------------------");
		DecimalFormat format = new DecimalFormat("000.00000");
		System.out.println(format.format(down));
		System.out.println(format.format(mid));
		System.out.println(format.format(up));
		
		System.out.println("---------------- default RoundingMode.FLOOR is down------------------");
		format.setRoundingMode(RoundingMode.FLOOR);
		System.out.println(format.format(down));
		System.out.println(format.format(mid));
		System.out.println(format.format(up));
		
		System.out.println("---------------- default RoundingMode.CEILING is up------------------");
		format.setRoundingMode(RoundingMode.CEILING);
		System.out.println(format.format(down));
		System.out.println(format.format(mid));
		System.out.println(format.format(up));
	}
	
	public static void main(String[] args) {
		roudingNumber();
		roudingNumberBigdecimal();
		roudingNnumberInDouble();
	}

}
