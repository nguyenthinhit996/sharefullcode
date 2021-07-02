package collectionsinJava.queueinterface;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * maintains the first-in-first-out order.
 * It holds the elements or objects which are to be processed by their priorities.
 * PriorityQueue doesn't allow null values to be stored in the queue.
 * @author Peter
 *
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<OderMeal> queue=new PriorityQueue<OderMeal>();
        queue.add(new OderMeal(18,"meal" + 18));
        queue.add(new OderMeal(1,"meal" + 1));
        queue.add(new OderMeal(12,"meal" + 12));
        queue.add(new OderMeal(1,"meal" + 111111));
        queue.add(new OderMeal(12,"meal" + 122));
        queue.add(new OderMeal(7,"meal" + 7));
        System.out.println(queue);

        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());
//
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

class OderMeal implements Comparable<OderMeal>{
    private int idOrder;
    private String nameMeal;

    public OderMeal(int idOrder, String nameMeal) {
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
    public int compareTo(OderMeal o) {
       return this.getIdOrder() - o.getIdOrder();
    }

    @Override
    public String toString() {
        return "OderMeal{" +
                "idOrder=" + idOrder +
                ", nameMeal='" + nameMeal + '\'' +
                '}';
    }
}
