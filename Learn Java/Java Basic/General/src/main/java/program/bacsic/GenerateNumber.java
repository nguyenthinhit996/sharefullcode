package program.bacsic;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * using Math.random() and maybe Math.random() * (max - min + 1) + min as well
 * using class java.util.Random and not apply type * (max - min + 1) + min as well
 * using ThreadLocalRandom.
 * using ints() or doubles ... java 8 random.ints(10,1,100) return stream int
 */
public class GenerateNumber {

    void mathRandome() {
        System.out.println(Math.random()); // 0.6551242959482966
        System.out.println(Math.random() * (1000 - 10 + 1) - 10); //244.18674110107128
        System.out.println(Math.random() * (1000 - 10 + 1) - 10); //242.36168902588707
        System.out.println(Math.random() * (1000 - 10 + 1) - 10); //726.970843541886
    }

    void classRandom() {
        Random random = new Random();
        System.out.println(random.nextInt()); //652265148
        System.out.println(random.nextDouble()); //0.18750549191555088
        System.out.println(random.nextBoolean()); //true
    }

    void threadLocalRandom() {
        Random random = new Random();
        System.out.println(ThreadLocalRandom.current().nextInt()); //-1001673627
        System.out.println(ThreadLocalRandom.current().nextInt(0, 1000)); //457
        System.out.println(ThreadLocalRandom.current().nextDouble()); //0.9721761857664386
        System.out.println(ThreadLocalRandom.current().nextDouble(500)); //107.20471601543136
        System.out.println(ThreadLocalRandom.current().nextDouble(500)); //304.1117669698558
    }

    void usingInits() {
        Random random = new Random();
        System.out.println("using ints()");
        //random.ints().forEach(System.out::println); // loop unlimited
        System.out.println("using ints(500)");
        random.ints(10).forEach(System.out::println);
        System.out.println("using ints(1,10)");
        //random.ints(1,10).forEach(System.out::println); // loop unlimited
        System.out.println("using ints(10,1,100)");
        random.ints(10,1,100).forEach(System.out::println);
    }

    public static void main(String[] args) {
        GenerateNumber generateNumber = new GenerateNumber();
//        generateNumber.mathRandome();
        generateNumber.classRandom();
//        generateNumber.threadLocalRandom();
//        generateNumber.usingInits();
    }
}
