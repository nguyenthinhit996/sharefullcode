package collectionsinJava.listinterface.comparelist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <h2> Various ways compare List</h2>
 * <h3>Java equals() method</h3>
 * <ul>
 *     <li>  Immutable class compare list to list use list.equal ok </li>
 *      <li> Customize class compare must Class element has Override Equal method and hashcodeClass</li>
 * </ul>
 * <h3>Java removeAll method , use equals() method to delete element equal</h3>
 * <h3>Java retainAll method similar removeAll method</h3>
 * <h3>Java Stream method use contain method and contain method use Equal method</h3>
 * <h2> Conclusion : Class Element of list must Override equal and hashCode after Check equal list</h2>
 *
 * @author peter
 */
public class CompareToArrayLists {

    /**
     * immutable class compare list to list use list.equal ok
     */
    static void equalMethodCompareTwoArrayListWrapperClass() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 6, 3, 66, 3, 33));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 4, 6, 3, 66, 3, 33));
        System.out.println("WrapperClass listOne.equals(listTwo): " + listOne.equals(listTwo));
    }

    /**
     * Customize class compare list to list use list.equal Ok must
     * Class element has Override Equal method and hashcodeClass
     */
    static void equalMethodCompareTwoArrayListCustomizeClass() {
        List<Student> listOne = new ArrayList<>();
        listOne.add(new Student(1, "hs1", new Address("tp1")));
        listOne.add(new Student(2, "hs2", new Address("tp2")));
        listOne.add(new Student(3, "hs3", new Address("tp3")));

        List<Student> listTwo = new ArrayList<>();
        listTwo.add(new Student(1, "hs1", new Address("tp1")));
        listTwo.add(new Student(2, "hs2", new Address("tp2")));
        listTwo.add(new Student(3, "hs3", new Address("tp3")));

        System.out.println("listOne.equals(listTwo): " + listOne.equals(listTwo));
    }

    /**
     * RemoveAll Check must Class element has Override Equal method and hashcodeClass
     */
    static void removeAllMethodCompareTwoArrayListCustomizeClass() {

        List<Student> listOne = new ArrayList<>();
        listOne.add(new Student(1, "hs1", new Address("tp1")));
        listOne.add(new Student(2, "hs2", new Address("tp2")));
        listOne.add(new Student(3, "hs3", new Address("tp3")));

        List<Student> listTwo = new ArrayList<>();
        listTwo.add(new Student(1, "hs1", new Address("tp1")));
        listTwo.add(new Student(2, "hs2", new Address("tp2")));
        listTwo.add(new Student(3, "hs3", new Address("tp3")));

        List<Student> listCopyToCheck = new ArrayList<>(listOne);

        System.out.println("listOne.removeAll(listTwo) " + listCopyToCheck.removeAll(listTwo));
        System.out.println("listOne.isEmpty(): " + listCopyToCheck.isEmpty());

        System.out.println("listOne.isEmpty(): " + listOne.size());
    }

    /**
     * retainAll Check must Class element has Override Equal method and hashcodeClass
     */
    static void retainAllMethodCompareTwoArrayListCustomizeClass() {

        List<Student> listOne = new ArrayList<>();
        listOne.add(new Student(1, "hs1", new Address("tp1")));
        listOne.add(new Student(2, "hs2", new Address("tp2")));
        listOne.add(new Student(3, "hs3", new Address("tp3")));

        List<Student> listTwo = new ArrayList<>();
        listTwo.add(new Student(1, "hs1", new Address("tp1")));
        listTwo.add(new Student(2, "hs2", new Address("tp2")));
//        listTwo.add(new Student(3, "hs3", new Address("tp3")));

        List<Student> listCopyToCheck = new ArrayList<>(listOne);

        System.out.println("listOne.retainAll(listTwo) " + listCopyToCheck.retainAll(listTwo));
        System.out.println("listOne size = listTwo size " + (listCopyToCheck.size()));
        System.out.println("List original size" + listOne.size());
    }

    /**
     * Stream Check must Class element has Override Equal method and hashcodeClass
     */
    static void streamMethodCompareTwoArrayListCustomizeClass() {

        List<Student> listOne = new ArrayList<>();
        listOne.add(new Student(1, "hs1", new Address("tp1")));
        listOne.add(new Student(2, "hs2", new Address("tp2")));
        listOne.add(new Student(3, "hs3", new Address("tp3")));

        List<Student> listTwo = new ArrayList<>();
        listTwo.add(new Student(1, "hs1", new Address("tp1")));
        listTwo.add(new Student(2, "hs2", new Address("tp2")));
//        listTwo.add(new Student(3, "hs3", new Address("tp3")));

        Predicate<Student> isDifference = (s) -> {
            if(!listTwo.contains(s)){
                return true;
            }
            return false;
        };
        List<Student> listResultDefference = listOne.stream().filter(isDifference).collect(Collectors.toList());
        System.out.println("size listResultDefference : " + listResultDefference.size());
    }

    public static void main(String[] args) {
        equalMethodCompareTwoArrayListWrapperClass();
        equalMethodCompareTwoArrayListCustomizeClass();
        removeAllMethodCompareTwoArrayListCustomizeClass();
        retainAllMethodCompareTwoArrayListCustomizeClass();
        streamMethodCompareTwoArrayListCustomizeClass();
    }

}

class Student {
    private Integer id;
    private String name;
    private Address address;


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
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