package program.numbers;

import java.util.Random;

/**
 * N=80 then N+1 will be 80+1=81, which is a perfect square of the number 9. Hence 80 is a sunny number.
 */
public class SunnyNumber {

    static boolean isSunnyNumber(int input) {
        if (input < 1) {
            return false;
        }
        // i tu 0 -> input , i ^ i == input => ok
        for (int i = 1; i <= input; i++) {
            if ((i*i) == input) {
                return true;
            }
        }
        return false;
    }

    static boolean calculatedSunnyNumber(int i) {
        int nextInputNumber = i + 1;
        return isSunnyNumber(nextInputNumber);
    }

    public static void main(String[] args) {
        Random random = new Random();
        random.ints(1000, 0, 10000).
                forEach(s -> {
                    if(calculatedSunnyNumber(s)){
                        System.out.println("SunnyNumber : " + s);
                    }
                });
    }
}
