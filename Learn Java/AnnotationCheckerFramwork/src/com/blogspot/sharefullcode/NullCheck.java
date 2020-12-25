package com.blogspot.sharefullcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class NullCheck {
	
	// Use for case 4 @RequiresNonNull 
	@Nullable
	Object field1;
	@Nullable
	Object field2;
	
	//case 5 
	@Nullable
	Map mapCheck= null;

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		NullCheck objectNew = new NullCheck();
		String a=new String();
		isEmpty(a);
		
		String sss=null;
		List< @Nullable String> aa= new ArrayList< @Nullable String>();
		aa.add("dfsfsss");
		aa.add(sss);
	}

//	void nullCheck1() {
//		
//		NullCheck objectNew = new NullCheck();
//
//		// case 1 complier error
//		@NonNull
//		Object ref = new Object();
//		System.out.println(ref);
//		ref = null; // incompatible types in assignment.
//
//		// case 2 error
//		@Nullable
//		Object obj = null; // might be null
//		@NonNull
//		Object nnobj; // never null
//		Object a = null;
//
//		obj.toString(); // dereference of possibly-null reference obj
//		nnobj = a; // incompatible types in assignment.
//		System.out.println(nnobj);
//
//		// case 3 @NonNull with method
//		objectNew.returnNonNull(); // incompatible types in return.
//
//		// case 4 @RequiresNonNull for parameter input in method
//		NullCheck aaa= new NullCheck();
//		aaa.field1 = new Object();
//		aaa.requiresNonNull(aaa);
//	}
	
	void nullCheck2() throws NoSuchMethodException, SecurityException {
		
		// case 5 @EnsuresNonNull
		//initalMap();
		
		//case 6 
		/*
		 * CharSequence inputPara = "sd   fdsfs"; Boolean ss=isEmpty(null);
		 * System.out.println("method return " + ss); Method
		 * m=this.getClass().getMethod("isEmpty",CharSequence.class); EnsuresNonNullIf
		 * anno = m.getAnnotation(EnsuresNonNullIf.class);
		 * System.out.println("@EnsuresNonNullIf value: "+anno.result());
		 */
		
	}
	
//	@EnsuresNonNull({"mapCheck"})
//	void initalMap() {
//		mapCheck= new HashMap<>();
//		System.out.println("@EnsuresNonNull");
//	}
	
//	@NonNull
//	String returnNonNull() {
//		String a = null;
//		return a;
//	}


	@RequiresNonNull({ "field1", "#1.field1" })
	/**
	 * field1 get from this class
	 * #1 is paramater 1
	 * @param other
	 */
	void requiresNonNull(@NonNull NullCheck other) {
		field1.toString(); // OK, this.field1 is known to be non-null
		//field2.toString(); // error, might throw NullPointerException
		other.field1.toString(); // OK, other.field1 is known to be non-null
		//other.field2.toString(); // error, might throw NullPointerException
	}

	
	// case 6 comment if value not null then function will return false
	@EnsuresNonNullIf(expression = "#1", result = false)
	public static boolean isEmpty(@Nullable CharSequence cs) {
		
		if ((cs == null) || (cs.length() == 0)) { return true; }
		 
	  for (int i = 0; i < cs.length(); i++) {
	    if (!Character.isWhitespace(cs.charAt(i))) {
	      return false;
	    }
	  }
	  return true;
	}
	
	
	 
}
