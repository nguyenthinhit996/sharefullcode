package com.blogspot.sharefullcode;

import java.util.Optional;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.optional.qual.Present;

public class OptionalChecker {
	
	
	public static void main(String[] args) {
		

        

		
		String ddd="dddd";
		String a= Optional.ofNullable(ddd).orElseGet(() ->"eee");
		System.out.println(a);
		
		Integer ssa= 2018;
		Integer aa= Optional.ofNullable(ssa).filter((s)->s>2000).orElse(0);
		System.out.println(aa);
		
		Integer aass=null;
		Integer aas= Optional.ofNullable(aass).map(s->s).orElse(0);
		System.out.println(aas);
		
		
		 Integer x = new Integer(22);
		  Integer y = new Integer(22);
		  Integer c=y;
		  System.out.println(x == y);
		  System.out.println(c == y);
		  
		  System.out.println("equals "+x.equals(y));
		  
		  String aaaa="dsfsf";
 
		
		  String as="222";
		 if("222"  == as) {
			 System.out.println("string");
		 }
		 
		 String hello = "Hello", lo = "lo";
	        System.out.println(hello == "Hello");
	        System.out.println(Other.hello == hello);
	      
	        System.out.println(hello == ("Hel"+"lo"));
	        System.out.println(hello == ("Hel"+lo));
	        System.out.println(hello == ("Hel"+lo).intern());
	        
 
 
	}
}

class Other { static String hello = "Hello"; }
