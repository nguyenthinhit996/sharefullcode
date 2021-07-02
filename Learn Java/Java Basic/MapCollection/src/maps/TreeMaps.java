package maps;

import java.util.TreeMap;

/**
 * Element class must implement Comparable, if not throw exception ClassCastException
 * Java TreeMap cannot have a null key but can have multiple null values.
 * TreeMap is the implementation of Map and SortedMap. It maintains ascending order.
 * The operate same TreeSet include method poll,higher, lower ...
 */
public class TreeMaps {

    public static void main(String[] args) {
        TreeMap<A, String>  treeMap = new TreeMap<>();
        treeMap.put(new A("jjj"), "1");
        System.out.println(treeMap);
    }

}

class A {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public A(String name) {
        this.name = name;
    }
}
