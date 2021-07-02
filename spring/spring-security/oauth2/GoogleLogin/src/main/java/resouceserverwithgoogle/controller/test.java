package resouceserverwithgoogle.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class test {

	    public static void main(String[] args) {
	    	Instant d=  Instant.ofEpochSecond(1621751316, 343000000);
	    	Date myDate = Date.from(d);
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
	    	String formattedDate = formatter.format(myDate);
	    	System.out.println( formattedDate);
		}
}
