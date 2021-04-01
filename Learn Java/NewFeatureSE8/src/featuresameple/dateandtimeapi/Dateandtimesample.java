package featuresameple.dateandtimeapi;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//doccument refer: https://www.oracle.com/technical-resources/articles/java/jf14-date-time.html

//Java SE 8 Date and Time
public class Dateandtimesample {

	void createObject() {
		// Creating Objects
		LocalDateTime timePoint = LocalDateTime.now(); // The current date and time
		System.out.println("LocalDateTime.now " + timePoint.toString());
		LocalDate localDate = LocalDate.of(2012, Month.DECEMBER, 12); // from values
		System.out.println("LocalDate.of " + localDate.toString());

		LocalDate localDate2 = LocalDate.ofEpochDay(950); // where day 0 is 1970-01-01
		System.out.println("LocalDate.ofEpochDay " + localDate2.toString());

		LocalTime localTime = LocalTime.of(23, 18); // the train I took home today
		System.out.println("LocalTime.of " + localTime.toString());

		LocalTime localTime2 = LocalTime.parse("10:15:30"); // From a String
		System.out.println("LocalTime.parse " + localTime2.toString());
	}

	void listing1() {
		// Creating Objects
		LocalDateTime timePoint = LocalDateTime.now(); // The current date and time
		System.out.println("LocalDateTime.now " + timePoint.toString());
		// Listing 1
		// getter conversion are use in onder to obtan value in classes
		Month month = timePoint.getMonth();
		System.out.println("timePoint.getMonth " + month);
		int day = timePoint.getDayOfMonth();
		System.out.println("timePoint.getDayOfMonth " + day);
		int second = timePoint.getSecond();
		System.out.println("timePoint.getSecond " + second);
	}

	void listing2() {
		// you can also alter the object values in order to perform caculater
		// because all core classes are immutable in the new api, these method are
		// called [with] and return new object, rather than using setters.

		// Creating Objects
		LocalDateTime timePoint = LocalDateTime.now(); // The current date and time
		System.out.println("LocalDateTime.now " + timePoint.toString());

		LocalDateTime cloneOject = timePoint.withDayOfMonth(10).withYear(2010);
		System.out.println("timePoint.withDayOfMonth(10).withYear(2010): " + cloneOject.toString());

		/*
		 * You can use direct manipulation methods, or pass a value and field pair
		 */
		LocalDateTime yetAnother = cloneOject.plusWeeks(8).minus(4, ChronoUnit.WEEKS);

		System.out.println(" cloneOject.plusWeeks(8).minus(4, ChronoUnit.WEEKS): " + yetAnother.toString());
	}

	void listing3() {
		// the new api also has the concept of an adjuster
		// you can either write withAdjuster, which is used to set one or more fields,
		// or
		// a PlusAdjuster, that add or subtract some field.
		// Creating Objects
		LocalDateTime timePoint = LocalDateTime.now(); // The current date and time
		System.out.println("LocalDateTime.now " + timePoint.toString());

		LocalDateTime localLastDayOfMonth = timePoint.with(lastDayOfMonth());
		System.out.println("lastDayOfMonth " + localLastDayOfMonth.toString());

		LocalDateTime previousOrSame = timePoint.with(previousOrSame(DayOfWeek.WEDNESDAY));
		System.out.println("previousOrSame " + previousOrSame.toString());

	}

	void listing4() {
		// truncation a field
		// Creating Objects
		LocalDateTime timePoint = LocalDateTime.now(); // The current date and time
		System.out.println("LocalDateTime.now " + timePoint.toString());
		
		LocalDateTime truncation = timePoint.truncatedTo(ChronoUnit.SECONDS);
		System.out.println(" Truncation second " +truncation.toString());
		
		LocalDateTime truncationDAYS = timePoint.truncatedTo(ChronoUnit.DAYS);
		System.out.println(" Truncation DAYS " +truncationDAYS.toString());
		
		//Get String follow format 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String truncationDAYSEcond = timePoint.format(formatter);
		System.out.println(" Format: " +truncationDAYSEcond.toString());
		
	}
	
	void distanceTwoInstant()
	{
		Instant instant = Instant.now(Clock.system(ZoneId.of("GMT+9")));
		System.out.println(instant.toString());   
		LocalDateTime localDate =LocalDateTime.now();
		System.out.println(localDate.toString());
		
		
	}

	void distanceTwoLocalDateTime () {
		LocalDateTime localDate =LocalDateTime.now();
		System.out.println("localDate: " + localDate.toLocalDate().toString());
		LocalDateTime localDateTomorrow =LocalDateTime.now().plusDays(1);
		System.out.println("localDateTomorrow: " + localDateTomorrow.toLocalDate().toString());
		
		// get distance base on time-based
		Duration oneDay = Duration.between(localDate,localDateTomorrow);
		System.out.println("duration "+ oneDay.toHours());
		 
		// get distance base on date-based
		Period period=Period.between(localDate.toLocalDate(), localDateTomorrow.toLocalDate());
		System.out.println("period "+ period.getDays());
	}
	
	public static void main(String[] args) {
		Dateandtimesample dateandtimesample = new Dateandtimesample();
//		 dateandtimesample.createObject();
//		 dateandtimesample.listing1();
//		 dateandtimesample.listing2();
//		dateandtimesample.listing3();
//		dateandtimesample.listing4();
		dateandtimesample.distanceTwoLocalDateTime();
	}
}
