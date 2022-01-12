package program.numbers;

/**
 * example number 76
 * 76 * 76 = 5776, 2 số cuối 76 => Automorphic Number
 */
public class AutomorphicNumber {

    static boolean calculatedAutoNumber(final int number) {

        // number chuyen ve str => lenght
        // square chuyen ve str get lenght so cuoi
        // check value lenght số cuối vs number

        String strNumberInput = String.valueOf(number);
        int lengthLast = strNumberInput.length();
        Integer square = number * number;
        String strNumberSquare = String.valueOf(square);
        String strLast = strNumberSquare.substring(strNumberSquare.length() - lengthLast);
        if(Integer.valueOf(strLast).equals(number)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrayInput = {1, 2, 5, 6,76, 36, 890625, 1 ,5 ,6 ,25 ,76 ,376 ,625 ,9376};
        for (int i : arrayInput) {
            System.out.println("Check : " + i + ": " + calculatedAutoNumber(i));
        }
    }

}
