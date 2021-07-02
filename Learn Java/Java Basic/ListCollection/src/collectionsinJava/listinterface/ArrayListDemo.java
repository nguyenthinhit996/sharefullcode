package collectionsinJava.listinterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * <h2>Internal Of ArrayList</h2>
 * <li> It uses a dynamic array to store the duplicate element of different data types. </li>
 * <li> ArrayList class maintains the insertion order and is non-synchronized. </li>
 * <li> Random access because it array works at the index basis</li>
 * <li> Maintains insertion ordered </li>
 * <li> LinkedList: manipulation is little bit Slower LinkedList because shifting ex removed element </li>
 * <li> LinkedList: access quickly than LinkedList </li>
 *
 * @author Peter
 *
 */
public class ArrayListDemo {


    /**
     * Arbatraty Element bất kì el
     */
    static void initalArrayListArbatrary(){
        List<Object> arbatraryList = new ArrayList<>();
        arbatraryList.add(121);
        arbatraryList.add("hihi");
        arbatraryList.add(Double.valueOf(323));
        arbatraryList.add(Float.valueOf(232));
        arbatraryList.add(Boolean.FALSE);
        System.out.println(arbatraryList);
    }

    /**
     * subList return reference of list current
     * Remove element reference from subList of List Current
     */
    static void subListDemo(){
        List<Student> listOriginal = new ArrayList<>();
        listOriginal.add(new Student(1, "hs1", new Address("tp1")));
        listOriginal.add(new Student(2, "hs2", new Address("tp2")));
        listOriginal.add(new Student(3, "hs3", new Address("tp3")));
        listOriginal.add(new Student(4, "hs3", new Address("tp3")));
        listOriginal.add(new Student(5, "hs3", new Address("tp3")));
        listOriginal.add(new Student(6, "hs3", new Address("tp3")));

        List listSub = listOriginal.subList(2,5); // 3 4 5

        System.out.println(listSub);
        listSub.clear();
        System.out.println(listSub); //[]
        System.out.println(listOriginal); // 1 2 6
    }

    /**
     * retainAll element exist join list current and list argument
     * list current 1 2 3
     * list argument 2 4
     * result list current is: 2
     */
    static void retainAll(){
        ArrayList<String> al=new ArrayList<String>();
        al.add("1");
        al.add("2");
        al.add("3");
        ArrayList<String> al2=new ArrayList<String>();
        al2.add("2");
        al2.add("444");
        al.retainAll(al2);
        System.out.println("iterating the elements after retaining the elements of al2");
        Iterator itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
//        initalArrayListArbatrary();
//        subListDemo();
        retainAll();
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