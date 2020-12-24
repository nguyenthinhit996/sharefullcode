package com.blogspot.sharefullcode;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NullCheck {
	public static void main(String[] args) {
		// case 1 complier error
		@NonNull
		Object ref = new Object();
		System.out.println(ref);
		ref = null; //incompatible types in assignment.

		// case 2 error 
		@Nullable Object   obj = null;  // might be null
		@NonNull  Object nnobj;  // never null
		Object a= null;
		
		obj.toString(); //  dereference of possibly-null reference obj
		nnobj=a; //  incompatible types in assignment.
		
		System.out.println(nnobj);
	}
}
