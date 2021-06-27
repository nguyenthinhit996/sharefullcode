package collectionsinJava.listinterface;

import java.util.*;

/**
 * It uses a doubly linked list internally to store the elements. (sử dụng danh sách liên kết).
 * It can store the duplicate elements.
 * It maintains the insertion order and is not synchronized. In LinkedList, the manipulation is fast because no shifting is required.
 *
 * @author Peter
 */
public class LinkedListDemo {
    static LinkedList<Student> listOriginal = new LinkedList<>(Arrays.asList(
            new Student[]{
                    new Student(1, "hs1", new Address("tp1")),
                    new Student(2, "hs2", new Address("tp2")),
                    new Student(3, "hs3", new Address("tp3")),
                    new Student(4, "hs3", new Address("tp3")),
                    new Student(5, "hs3", new Address("tp3")),
                    new Student(6, "hs3", new Address("tp3"))
            }
    ));


    /**
     * reverse ordered insertion
     */
    static void demoDescendingIterator() {
        //listOriginal 1 2 3 4 5 6
        Iterator<Student> linkList = listOriginal.descendingIterator();
        while (linkList.hasNext()) {
            System.out.println(linkList.next()); // 6 5 4 3 2 1
        }
    }

    /**
     * get list from index (inclusive index) to end list
     */
    static void demoListIterator(){
        //listOriginal 1 2 3 4 5 6
        Iterator<Student> linkList = listOriginal.listIterator(3);
        while (linkList.hasNext()) {
            System.out.println(linkList.next()); // 4 5 6
        }
    }

    static void demoOffer(){
        LinkedList lscopyNew = new LinkedList(listOriginal);
        //boolean offer(E e)
        Student studentOffer = new Student(100, "studentOffers", new Address("tp1"));
        lscopyNew.push(studentOffer);
        System.out.println(lscopyNew);
        lscopyNew.pop();
        System.out.println(lscopyNew);

    }

    public static void main(String[] args) {
//        demoDescendingIterator();
//        demoListIterator();
        demoOffer();
    }
}
