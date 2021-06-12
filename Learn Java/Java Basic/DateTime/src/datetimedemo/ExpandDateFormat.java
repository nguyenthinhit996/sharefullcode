package datetimedemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExpandDateFormat {

	static void useDateTimeFormatter() {

		LocalDateTime time = LocalDateTime.now();
		System.out.println(time.toString());
		DateTimeFormatter dateTimeFormatter;
		String date;

		// years yyyy -> 2005
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");
		date = time.format(dateTimeFormatter);
		System.out.println("years [yyyy] Year: " + date); // 2021

		// month of year
		// MM -> 06
		dateTimeFormatter = DateTimeFormatter.ofPattern("MM");
		date = time.format(dateTimeFormatter);
		System.out.println("month of year [MM] Month: " + date); // 06

		// MMM -> oct
		dateTimeFormatter = DateTimeFormatter.ofPattern("MMM");
		date = time.format(dateTimeFormatter);
		System.out.println("month of year [MMM] Month: " + date); // Jun

		// MMMM -> october
		dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM");
		date = time.format(dateTimeFormatter);
		System.out.println("month of year [MMMM] Month: " + date); // June

		// day of week
		// E -> sat
		dateTimeFormatter = DateTimeFormatter.ofPattern("E");
		date = time.format(dateTimeFormatter);
		System.out.println("day of week [E] day: " + date); // Sat

		// day of week FULL
		// EEEE -> Saturday
		dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE");
		date = time.format(dateTimeFormatter);
		System.out.println("day of week [EEEE] day: " + date); // Saturday

		// day of month
		// dd -> 20
		dateTimeFormatter = DateTimeFormatter.ofPattern("dd");
		date = time.format(dateTimeFormatter);
		System.out.println("day of month [dd] day: " + date); // 12 day

		// day of year
		// DDD -> 204
		dateTimeFormatter = DateTimeFormatter.ofPattern("DDD");
		date = time.format(dateTimeFormatter);
		System.out.println("day of year [DDD] day: " + date); // 163 day

		// hour (AM/PM)
		// hh -> 09
		dateTimeFormatter = DateTimeFormatter.ofPattern("hh");
		date = time.format(dateTimeFormatter);
		System.out.println("hour (AM/PM) [hh] hour: " + date); // 09 hour

		// hour (0-23)
		// HH -> 21
		dateTimeFormatter = DateTimeFormatter.ofPattern("HH");
		date = time.format(dateTimeFormatter);
		System.out.println("hour (0-23) [HH] hour: " + date); // 21 day

		// get AM/PM
		// a -> AM or PM
		dateTimeFormatter = DateTimeFormatter.ofPattern("a");
		date = time.format(dateTimeFormatter);
		System.out.println(" get AM/PM [a] hour: " + date); // AM or PM

		// number minute
		// mm
		dateTimeFormatter = DateTimeFormatter.ofPattern("mm");
		date = time.format(dateTimeFormatter);
		System.out.println("minute / hour [mm] : " + date); // 54 minute

		// second
		// ss
		dateTimeFormatter = DateTimeFormatter.ofPattern("ss");
		date = time.format(dateTimeFormatter);
		System.out.println("seconds [ss] : " + date); // 54 seconds

		// miliseconds
		// S
		dateTimeFormatter = DateTimeFormatter.ofPattern("SSS");
		date = time.format(dateTimeFormatter);
		System.out.println("miliseconds [SSS] : " + date); // 664 miliseconds

		// nanoseconds
		// n
		dateTimeFormatter = DateTimeFormatter.ofPattern("n");
		date = time.format(dateTimeFormatter);
		System.out.println("miliseconds [n] : " + date); // 664256400 miliseconds
	}

	public static void main(String[] args) {

		useDateTimeFormatter();
	}
}
