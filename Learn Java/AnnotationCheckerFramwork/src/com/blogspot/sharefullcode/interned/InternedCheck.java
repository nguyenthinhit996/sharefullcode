package com.blogspot.sharefullcode.interned;

import org.checkerframework.checker.interning.qual.Interned;
import org.checkerframework.checker.interning.qual.InternedDistinct;
import org.checkerframework.checker.interning.qual.UsesObjectEquals;
import org.checkerframework.checker.regex.RegexUtil;

public class InternedCheck {
	public static void main(String[] args) {
        String s= "s";
        System.out.println("check s vs S: "+s == s.toUpperCase());
        
        System.out.println("check s vs S: "+s.equals(null));
        
        
          Integer x = new Integer(22);
        @InternedDistinct Integer y = new Integer(22);
        if(x == y) {
        	
        }
        System.out.println(x == y);  // prints false!
        
        Integer in1 = new Integer(20);
        Integer in2 = new Integer(20);
        if(in2 == 2342) {
        	System.out.println();
        }
        
        A a= new A();
        B b= new B();
        if(a.equals(b)) {
        	System.out.println();
        }
        
        // regex Utils
        String regex="dssdf";
        System.out.println("regex "+RegexUtil.isRegex(regex));
	}
}

@UsesObjectEquals
class A{
	
}


class B{
	
}