package collectionsinJava.setInterface;

import java.util.*;

/**
 * It represents the unordered set of elements which doesn't allow us to store the duplicate items.
 * It represents the collection that uses a hash table for storage
 * Hashing is used to store the elements in the HashSet. It contains unique items.
 * @author Peter
 *
 */
public class HashSetDemo {

    static void demoHashCodeItemOfClass(){
        //mapFullHashcode for use all field in class to override equal and hashcode
        Set<Student> mapFullHashcode = new HashSet<>();
        //mapIdentityHashcode for use only field identity in class to override equal and hashcode
        Set<StudentIdentity> mapIdentityHashcode = new HashSet<>();

        for (var i = 0;i<10;i++){
            Student student = new Student(i,"name"+i,new Address(""+i));
            StudentIdentity studentIdentity = new StudentIdentity(i,"name"+i,new Address(""+i));
            mapFullHashcode.add(student); // it add success
            mapIdentityHashcode.add(studentIdentity); // it add success
        }
        for (var i = 0;i<10;i++){
            int j = i + 10;
            Student student = new Student(i,"name"+j,new Address(""+i));
            StudentIdentity studentIdentity = new StudentIdentity(i,"name"+j,new Address(""+i));
            mapFullHashcode.add(student); // it add success
            mapIdentityHashcode.add(studentIdentity); // it not add success because it key exist hashcode
        }
        System.out.println(mapFullHashcode.size()); // 20 not expect for this result
        System.out.println(mapFullHashcode); // 0-0 ; 1-1; 2-2; 3-3; .... fault case
        // case hashcode identity
        System.out.println("case hashcode identity");
        System.out.println(mapIdentityHashcode.size()); // 10 result expect
        System.out.println(mapIdentityHashcode); // 0 1 2 3 4 ... true case
    }

    public static void main(String[] args) {
        demoHashCodeItemOfClass();
    }
}

class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private Address address;

    @Override
    public int compareTo(Student o) {
        if(this.id > o.getId()){
            return  1;
        }
        return -1;
    }

    //case full item of class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
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


class StudentIdentity {
    private Integer id;
    private String name;
    private Address address;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentIdentity that = (StudentIdentity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StudentIdentity(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}

class AddressIdentity {
    private String tp;

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public AddressIdentity(String tp) {
        this.tp = tp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressIdentity that = (AddressIdentity) o;
        return Objects.equals(tp, that.tp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tp);
    }
}