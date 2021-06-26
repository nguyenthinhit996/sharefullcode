package collectionsinJava.listinterface.sorts;

import java.util.*;

/**
 * When sort use Comparable we implement Comparable in class element
 */
public class SortListsByComparable {

    static void sortCustomizeClass() {
        List<Vehicle2> listOriginal = new ArrayList<>();
        listOriginal.add(new Vehicle2(1, "hs1", new Address2("tp1")));
        listOriginal.add(new Vehicle2(2, "hs2", new Address2("tp2")));
        listOriginal.add(new Vehicle2(388, "hs3", new Address2("tp3")));
        listOriginal.add(new Vehicle2(33, "hs3", new Address2("tp3")));
        listOriginal.add(new Vehicle2(32, "hs3", new Address2("tp3")));
        listOriginal.add(new Vehicle2(36, "hs3", new Address2("tp3")));

        System.out.println("List original : " + listOriginal);
        Collections.sort(listOriginal);
        System.out.println("List sorted ascending : " + listOriginal);
        Collections.sort(listOriginal, Comparator.reverseOrder());
        System.out.println("List sorted descending : " + listOriginal);

        Collections.sort(listOriginal);
        Collections.sort(listOriginal, Comparator.reverseOrder());
    }

    public static void main(String[] args) {
        sortCustomizeClass();
    }
}


class Vehicle2  implements  Comparable<Vehicle2>{
    private Integer id;
    private String name;
    private Address2 address;

    public Vehicle2(Integer id, String name, Address2 address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    public Address2 getAddress() {
        return address;
    }

    public Vehicle2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vehicle2() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Vehicle2 o) {
        if (this.getId() > o.getId()) { // max last
            return 1;
        }
        return -1;
    }
}

class Address2 {
    private String tp;

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public Address2(String tp) {
        this.tp = tp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address2 address = (Address2) o;
        return Objects.equals(tp, address.tp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tp);
    }
}
