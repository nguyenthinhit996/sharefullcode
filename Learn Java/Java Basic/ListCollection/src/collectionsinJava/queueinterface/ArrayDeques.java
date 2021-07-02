package collectionsinJava.queueinterface;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * ArrayDeque class implements the Deque interface. 
 * It facilitates us to use the Deque. Unlike queue, we can add or delete the elements from both the ends.
 * we can remove and add the elements from both the side
 * ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.
 * @author Peter
 *
 */
public class ArrayDeques {

    public static void main(String[] args) {
        ArrayDeque<OderMeal2> queue=new ArrayDeque<OderMeal2>();
        queue.add(new OderMeal2(18,"meal" + 18));
        queue.add(new OderMeal2(1,"meal" + 1));
        queue.add(new OderMeal2(12,"meal" + 12));
        queue.add(new OderMeal2(1,"meal" + 111111));
        queue.add(new OderMeal2(12,"meal" + 122));
        queue.add(new OderMeal2(7,"meal" + 7));
        System.out.println(queue);

        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());

        queue.remove(); // remove 1
        queue.remove(); // remove 1
        queue.remove(); // remove 7

        System.out.println("after removing two elements:");

        Iterator itr=queue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}

class OderMeal2 {
    private int idOrder;
    private String nameMeal;

    public OderMeal2(int idOrder, String nameMeal) {
        this.idOrder = idOrder;
        this.nameMeal = nameMeal;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getNameMeal() {
        return nameMeal;
    }



    @Override
    public String toString() {
        return "OderMeal{" +
                "idOrder=" + idOrder +
                ", nameMeal='" + nameMeal + '\'' +
                '}';
    }


}
