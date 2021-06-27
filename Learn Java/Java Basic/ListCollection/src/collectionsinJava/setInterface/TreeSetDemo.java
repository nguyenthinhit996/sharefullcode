package collectionsinJava.setInterface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * that uses a tree for storage.
 * TreeSet also contains unique elements.
 * the access and retrieval time of TreeSet is quite fast. The elements in TreeSet stored in ascending order.
 * @author Peter
 *
 */
public class TreeSetDemo {

    static TreeSet<String> treeSet = new TreeSet<>(Arrays.asList("a","q","e","t","u","i","o","n","b"));

    static void demoManipulation(){

        System.out.println(treeSet); // [a, b, e, i, n, o, q, t, u]
        //get descending order
        System.out.println(treeSet.descendingSet()); // [u, t, q, o, n, i, e, b, a]
        //ceiling bigger closet (lớn gần nhất) hoặc bằng nếu ko có return null;
        System.out.println(treeSet.ceiling("f")); // i

        //et smaller closet (nhỏ gần nhất) hoặc bằng nếu ko có return null;
        System.out.println(treeSet.floor("d")); // b

        //get head to element , if element not found get all smaller
        System.out.println(treeSet.headSet("d", true)); //[a, b]

        //get element to tail , if element not found get all bigger
        System.out.println(treeSet.tailSet("m", true)); //[n, o, q, t, u]

        //same ceilling
        System.out.println(treeSet.higher("f")); // i

        // get first (min) and remove
        System.out.println(treeSet.pollFirst()); // a

        // get first (max) and remove
        System.out.println(treeSet.pollLast()); // u

        System.out.println(treeSet); //[b, e, i, n, o, q, t]


        // get first (min) and without remove
        System.out.println(treeSet.first()); // b

        // get first (max) and without remove
        System.out.println(treeSet.last()); // t

        System.out.println(treeSet); // [b, e, i, n, o, q, t]
    }

    static void demoSort(){
        Set<Student> treeSetStudent = new TreeSet<>();
        Random random = new Random();
        for (var i = 0; i < 100; i++) {
            int genId = random.nextInt(100);
            Student student = new Student(genId, "name " + genId, new Address(""+genId));
            treeSetStudent.add(student);
        }

        System.out.println(treeSetStudent);
    }

    public static void main(String[] args) {
        demoManipulation();
        demoSort();
    }
}
