package code.controlstatement;

/**
 * For: recommended use for when the max (N) fixed
 *
 * While: recommended use while when the max (N) not fixed
 * check condition if true into scope while
 *
 * Do while: recommended use while when the max (N) not fixed
 * and use want the do while action at least once.
 * check condition if true into scope while
 */
public class LoopControl {

    void forOrdinary() {
        System.out.println("forOrdinary");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    void whileOrdinary() {
        System.out.println("whileOrdinary");
        int input = 10;
        while (input > 0)  {
            System.out.println(input --);
        }
    }

    void doWhileOrdinary() {
        System.out.println("doWhileOrdinary");
        int input = 10;
        do {
            System.out.println(input --);
        }while(input > 0);
    }

    public static void main(String[] args) {
        LoopControl loopControl = new LoopControl();
        loopControl.forOrdinary();
        loopControl.whileOrdinary();
        loopControl.doWhileOrdinary();
    }
}
