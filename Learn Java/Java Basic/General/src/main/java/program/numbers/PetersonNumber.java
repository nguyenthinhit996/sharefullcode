package program.numbers;

/**
 * 145 = !1 + !4 + !5
 * =1+4*3*2*1+5*4*3*2*1
 * =1+24+120
 * 145 = 145
 */
public class PetersonNumber {

    static long calculatedFactorial(long number){
        long multi = 1;
        for (int i = 1; i <= number; i++) {
            multi *= i;
        }
        return multi;
    }

    static boolean calculatedPetersonNumber(final long inputNumber) {
        long numberCalculated = inputNumber;
        long total = 0;
        while (numberCalculated > 0) {
            long lastNumber = numberCalculated % 10;
            numberCalculated = numberCalculated / 10;
            total += calculatedFactorial(lastNumber);
        }
        if (inputNumber == total) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long[] factorial = new long[] { 773, 145, 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        for (long i : factorial) {
            System.out.println("check : " + i + " " + calculatedPetersonNumber(i));
        }
    }

}
