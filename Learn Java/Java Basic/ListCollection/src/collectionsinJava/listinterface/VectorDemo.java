package collectionsinJava.listinterface;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * pending
 * Vector uses a dynamic array to store the data elements. It is similar to ArrayList.
 * However, It is synchronized and contains many methods that are not the part of Collection framework.
 * It is recommended to use the Vector class in the thread-safe implementation only.
 * If you don't need to use the thread-safe implementation, you should use the ArrayList, the ArrayList will perform better in such case.
 * @author Peter
 *
 */
public class VectorDemo {

    /**
     * synchronized thread
     */
    static void demoVector() {
        Vector<String> vec = new Vector<>();
        vec.add("1111");

        Thread  th1 = new thread1(vec); // th1 get enough 10000 after that thread2 is get value
        th1.setPriority(1);
        Thread  th2 = new thread2(vec);
        th2.setPriority(10);
        System.out.println("---------------Start------------------");
        th1.start();
        th2.start();
//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("---------------End------------------");
        System.out.println(vec);
    }
    public static void main(String[] args) {
        demoVector();
    }
}

class thread1 extends Thread{

    Vector<String> ls =null;
    int stopMax = 10000;
    int start = 0;

    thread1(Vector<String> ls){
        this.ls= ls;
    }

    void getElementOfList(){
            String value = "thread1 " + start;
            String ss = ls.get(0);
            System.out.println(value + " " + ss);
            start++;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

         while(true){
            if(start == stopMax){
                break;
            }
            getElementOfList();
        }
    }
}

class thread2 extends Thread{

    Vector<String> ls =null;
    int stopMax = 10;
    int start = 0;

    thread2(Vector<String> ls){
        this.ls= ls;
    }

    void getElementOfList(){
        try {
            String value = "thread2 " + start;
            System.out.println(value);
            String valueGet = ls.get(0);
            System.out.println(valueGet);
            Thread.sleep(10);
            start++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while(true){
            if(start == stopMax){
                break;
            }
            getElementOfList();
        }
    }
}