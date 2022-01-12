package code.controlstatement;

/**
 *  these type of if:
 *  if
 *  if else
 *  if else if .... else
 *  if nested if ...
 */
public class IfControl {

    private static Integer valueA = 10;
    private static Integer valueB = 10;

    public static void main(String[] args) {

        if(valueA == 10){
            System.out.println("use type if 1");
        }

        if(valueA == 11){
            System.out.println("Don't appear");
        }else {
            System.out.println("use type if 2");
        }

        if(valueA == 11){
            System.out.println("Don't appear");
        }else if (valueA == 111){
            System.out.println("Don't appear");
        }else if (valueA == 10){
            System.out.println("use type if 3");
        }else if (valueA == 12){
            System.out.println("Don't appear");
        }else {
            System.out.println("Don't appear");
        }

        if(valueA == 11){
            System.out.println("Don't appear");
        }else if (valueA == 111){
            System.out.println("Don't appear");
        }else if (valueA == 110){
            System.out.println("Don't appear");
        }else if (valueA == 12){
            System.out.println("Don't appear");
        }else {
            System.out.println("use type if 3 example 2");
        }

        if(valueA == valueB){
            if (valueB == 10) {
                if (valueA == 10) {
                    System.out.println("use type if 4");
                }
            }
        }

    }
}
