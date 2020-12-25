//package com.blogspot.sharefullcode.mapchecker;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.checkerframework.checker.nullness.qual.EnsuresKeyForIf;
//import org.checkerframework.checker.nullness.qual.KeyFor;
//
//public class MapKeyChecker {
//	
//
//	Map<String,String> keymap = new HashMap<String,String>();
//	@KeyFor("this.keymap") String coll;
//
//	void anc() {
//		String x="hostname";
//		// you must add one value then keyfor value it
//		keymap.put(x, "sdfs");
//		coll=x;
//	}
//	
//	 
//	@EnsuresKeyForIf(result=true, expression="coll", map="this.keymap")
//	Boolean isExistKeyHostname(String input) {
//		if(keymap.isEmpty()) {
//			return false;
//		}
//		if(coll.equals(input)) {
//			return true;
//		}
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		
//		
//		
//	}
//}
