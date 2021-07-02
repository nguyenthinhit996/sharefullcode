package collectionsinJava.listinterface.sorts;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Use comparator not change content of class
 *
 */
public class SortListsByComparator {

    /**
     * Sort with class immutable (wrapper class)
     */
    static void sortClassImmutable() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 6, 3, 66, 3, 33));
        System.out.println("List original : " + listOne);
        Collections.sort(listOne);
        System.out.println("List sorted ascending : " + listOne);
        Collections.sort(listOne, Comparator.reverseOrder());
        System.out.println("List sorted descending : " + listOne);
    }

    // create Comparator for class Vehicle
    static Comparator<Vehicle> ascendingVehicle = (o1, o2) -> {
        if (o1.getId() > o2.getId()) { // max last
            return 1;
        }
        return -1;
    };

    // comparator for class descending vehicle
    static Comparator<Vehicle> descendingVehicle = Collections.reverseOrder(ascendingVehicle);

    /**
     * sortCustomizeClass
     */
    static void sortCustomizeClass() {
        List<Vehicle> listOriginal = new ArrayList<>();
        listOriginal.add(new Vehicle(1, "hs1", new Address("tp1")));
        listOriginal.add(new Vehicle(2, "hs2", new Address("tp2")));
        listOriginal.add(new Vehicle(388, "hs3", new Address("tp3")));
        listOriginal.add(new Vehicle(33, "hs3", new Address("tp3")));
        listOriginal.add(new Vehicle(32, "hs3", new Address("tp3")));
        listOriginal.add(new Vehicle(36, "hs3", new Address("tp3")));

        System.out.println("List original : " + listOriginal);
        Collections.sort(listOriginal, ascendingVehicle);
        System.out.println("List sorted ascending : " + listOriginal);
        Collections.sort(listOriginal, descendingVehicle);
        System.out.println("List sorted descending : " + listOriginal);
    }

    public static void main(String[] args) {
        sortClassImmutable();
        sortCustomizeClass();
    }
}


class Vehicle {
    private Integer id;
    private String name;
    private Address address;

    public Vehicle(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Vehicle(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vehicle() {

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
}

class Address {
    private String tp;

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public Address(String tp) {
        this.tp = tp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(tp, address.tp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tp);
    }
}