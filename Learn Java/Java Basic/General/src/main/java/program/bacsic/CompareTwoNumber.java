package program.bacsic;

/**
 * How to compare two object in java
 * equal and hashcode
 * Default if not override equal and hashcode 2 object equal when same location memory.
 * Two object equal mush same number hashcode.
 * Value Primitive: use == is best practices.
 * Value Reference (built-in java): use equal or compareTo as well.
 * Value Reference: use equal is best and Override Equal and Hashcode.
 */
public class CompareTwoNumber {

    public static void main(String[] args) {
        //case primitive
        int inputA = 10;
        int inputB = 10;
        if (inputA == inputB){
            System.out.println("primitive use ==");
        }

        //case built-in java
        Integer inputIntA = Integer.valueOf("10");
        Integer inputIntB = Integer.valueOf("10");

        if (inputIntA == inputIntB){
            System.out.println("Integer use == ");
        }
        else if (inputIntA.equals(inputIntB)){
            System.out.println("Integer use equal"); // appear
        }else {
            System.out.println("Integer not equal");
        }
        // case String
        String inputStrA = new String("10");
        String inputStrB = "10";

        if (inputStrA == inputStrB){
            System.out.println("String use == ");
        }
        else if (inputStrA.equals(inputStrB)){
            System.out.println("String use equal"); // appear
        }else {
            System.out.println("String not equal");
        }
    }
}
