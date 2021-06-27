package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 *  see https://www.javatpoint.com/working-of-hashmap-in-java
 *
 */
public class HasingMechanism {


    /**
     * equals : check content key.
     * hashCode: calculator number , we use that number as address in Bucket of HashMap
     * Buckets: Array of the node is called buckets. Each node has a data structure like a LinkedList
     */

    /**
     * Put method scenario
     * b1 hashcode Key ex -> 222
     * b2 Calculator following formula Index = hashcode(Key) & (n-1) | hashcode(222) & (16 -1)
     * b3 check key vs first node in index of Bucket, if same update value current to value old, otherwise it connect
     * with it into node old
     *
     *        | index 0
     *        | index 2 -> (LinkedList) include node a -> node b -> node c
     *        | index 3
     *        ...
     *        | index 15
     *
     *
     */



    /**
     * Demo hashcode and equal full field in class or only identity
     */
    static void demoHashCodeItemOfClassInMap(){
        //mapFullHashcode for use all field in class to override equal and hashcode
        Map<Student,String> mapFullHashcode = new HashMap();
        //mapIdentityHashcode for use only field identity in class to override equal and hashcode
        Map<StudentIdentity,String> mapIdentityHashcode = new HashMap();

        for (var i = 0;i<10;i++){
            Student student = new Student(i,"name"+i,new Address(""+i));
            StudentIdentity studentIdentity = new StudentIdentity(i,"name"+i,new Address(""+i));
            mapFullHashcode.put(student,"mapFullHashcode 1"); // it add success
            mapIdentityHashcode.put(studentIdentity,"mapFullHashcode 1"); // it add success
        }
        for (var i = 0;i<10;i++){
            int j = i + 10;
            Student student = new Student(i,"name"+j,new Address(""+i));
            StudentIdentity studentIdentity = new StudentIdentity(i,"name"+j,new Address(""+i));
            mapFullHashcode.put(student,"mapFullHashcode 2"); // it add success
            mapIdentityHashcode.put(studentIdentity,"mapFullHashcode 2"); // it update value success because it key exist hashcode
        }
        System.out.println(mapFullHashcode.size()); // 20 not expect for this result
        System.out.println(mapFullHashcode); // 0-0 ; 1-1; 2-2; 3-3; .... fault case
        // case hashcode identity
        System.out.println("case hashcode identity");
        System.out.println(mapIdentityHashcode.size()); // 10 result expect
        System.out.println(mapIdentityHashcode); // 0 1 2 3 4 ... true case
    }

    public static void main(String[] args) {
        demoHashCodeItemOfClassInMap();
    }
}

class Student {
    private Integer id;
    private String name;
    private Address address;

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
        return "StudentIdentity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
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