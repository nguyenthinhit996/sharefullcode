package collectionsinJava.listinterface;

import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The stack is the subclass of {@link Vector}.
 * It implements the last-in-first-out data structure
 * @author Peter
 *
 */
public class StackDemo {
    public static void main(String args[])
    {
        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 7, 9, 11 });
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Integer i = (Integer)itr.next();
            System.out.println(i);
            if (i == 7)
                list.add(15); // It will not be printed
            //This means it has created a separate copy of the collection
        }
        System.out.println(list.size());
    }
}
