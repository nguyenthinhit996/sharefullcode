package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * HashMap is the implementation of Map, but it doesn't maintain any order.
 * Storage k-v
 * Java HashMap contains only unique keys.
 * if key exist it update value
 * allow null, non synchronized
 */
public class HashMaps {

    static HashMap<String, String> mapString = new HashMap<>();


    /**
     * when clone map Immutable edit or delete non effect other map
     * when clone user-defined object delete non effect, but edit effect all map reference to key-value.
     */
    static void demoMapClone() {
        mapString.put("1", "1");
        mapString.put("11", "1");
        mapString.put("12", "1");
        mapString.put("13", "1");
        mapString.put("10", "1");

        HashMap<String, String> mapClone = (HashMap<String, String>) mapString.clone();

        System.out.println(mapString);
        mapString.remove("11");
        mapString.remove("11");
        mapString.replace("13", "555");
        System.out.println(mapString);
        System.out.println("--------- mapClone -----------");
        System.out.println(mapClone);

        System.out.println("--------- Test user-defined object -----------");
        HashMap<StudentIdentity, String> mapIdentityHashcode = new HashMap();
        StudentIdentity studentIdentity = null;
        for (var i = 0; i < 10; i++) {
            Student student = new Student(i, "name" + i, new Address("" + i));
            studentIdentity = new StudentIdentity(i, "name" + i, new Address("" + i));
            mapIdentityHashcode.put(studentIdentity, "mapFullHashcode 1"); // it add success
        }
        System.out.println(mapIdentityHashcode);
        HashMap<StudentIdentity, String> mapClone2 = (HashMap<StudentIdentity, String>) mapIdentityHashcode.clone();
        //mapIdentityHashcode.remove(studentIdentity); non effect
        studentIdentity.setId(23456); // effect all
        System.out.println(mapIdentityHashcode);
        System.out.println("--------- mapClone2 -----------");
        System.out.println(mapClone2);

    }

    /**
     * User iterator or for edit element of map
     */
    static void testEditForElementMap() {

        Set<Map.Entry<String, String>> setEntry = mapString.entrySet();
        Iterator<Map.Entry<String, String>> a = setEntry.iterator();
        while (a.hasNext()) {
            Map.Entry<String, String> value = a.next();
            System.out.println("k: " + value.getKey() + " v: " + value.getValue());
        }

        HashMap<StudentIdentity, String> mapIdentityHashcode = new HashMap();
        StudentIdentity studentIdentity = null;
        for (var i = 0; i < 10; i++) {
            Student student = new Student(i, "name" + i, new Address("" + i));
            studentIdentity = new StudentIdentity(i, "name" + i, new Address("" + i));
            mapIdentityHashcode.put(studentIdentity, "mapFullHashcode 1"); // it add success
        }

        Set<Map.Entry<StudentIdentity, String>> mapEntrySet = mapIdentityHashcode.entrySet();
        Iterator<Map.Entry<StudentIdentity, String>> aa = mapEntrySet.iterator();
        while (aa.hasNext()) {
            Map.Entry<StudentIdentity, String> value = aa.next();
            value.getKey().setName("hihihi");
            System.out.println("k: " + value.getKey() + " v: " + value.getValue());
        }


        for (Map.Entry<StudentIdentity, String> value : mapEntrySet) {
            value.getKey().setName("xxxxxxxxxxxx");
            System.out.println("k: " + value.getKey() + " v: " + value.getValue());
        }


        // test computeIfPresent auto update value new of BiFunction into map
        BiFunction<StudentIdentity, String, String> concatValue = (studentIdentity1, s) -> {
            String aaa = "none action";
            if (null != studentIdentity1) {
                aaa = "auto map value" + s.hashCode();
            }
            return aaa;
        };

        mapIdentityHashcode.computeIfPresent(studentIdentity, concatValue);

        System.out.println(mapIdentityHashcode);


    }



    public static void main(String[] args) {
        demoMapClone();
        testEditForElementMap();
    }
}
