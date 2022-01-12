package program.bacsic;

/**
 * số ngyên tố
 * chia hết cho chính nó
 * 0 and 1 not prime
 */
public class PrimeNumber {

    /**
     * @param number is check number is prime or not.
     * @return boolean if is prime number return true, else return false.
     */
    static boolean checkPrime(int number) {
        // check number > 1 , else return false
        // flag = 0
        // for i = 0 to < number
        // if number % i == 0 gán flag = 1 return flag.
        // check if flag = 0 return true.

        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static boolean recursionPrime(int number){
        if (number <= 1) {
            return false;
        }else {
            return calculatorRecursionPrime(2, number);
        }
    }

    static boolean calculatorRecursionPrime(int i, int n) {
        if(i == n){
            return true;
        }else {
            if(n % i == 0){
                return false;
            }
            return calculatorRecursionPrime(++i, n);
        }
    }

    public static void main(String[] args) {
        int[] input = {1 , 0, 1, 2, 3, 5, 7, 11, 13, 17, 20};
        for (int i : input) {
            System.out.println("check : "+ i + " :" + checkPrime(i));
        }
        System.out.println("---------------------");
        for (int i : input) {
            System.out.println("check : "+ i + " :" + recursionPrime(i));
        }
    }
}
