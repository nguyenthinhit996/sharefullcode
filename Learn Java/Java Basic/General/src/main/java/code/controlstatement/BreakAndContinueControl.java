package code.controlstatement;

/**
 * break : break jum to outside the loop nearest, not action on this loop.
 * continue: the statement will go on the next item , skipping code below continue tag.
 */
public class BreakAndContinueControl {

    public static void main(String[] args) {

        int conditionBreak = 10;
        int conditionContinue = 10;

        int maxLoop = 20;
        System.out.println("conditionBreak break at value 10");
        while (maxLoop > 0) {
            if(maxLoop == conditionBreak){
                break;
            }
            System.out.println(maxLoop --);
        }

        System.out.println("conditionContinue dont appear 10 in list");
        maxLoop = 20;
        while (maxLoop > 0) {
            if(maxLoop == conditionContinue){
                maxLoop --;
                continue;
            }
            System.out.println(maxLoop --);
        }

    }
}
