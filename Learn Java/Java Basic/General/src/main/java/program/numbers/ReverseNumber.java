package program.numbers;

/**
 * 1234 -> 4321
 */
public class ReverseNumber {

    static int reverseNumber(final int input) {
        boolean isNegative = input < 0;
        String number = String.valueOf(isNegative ? -1 * input : input);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            String numberStr = String.valueOf(number.charAt(i));
            stringBuilder.append(numberStr, 0, 1);
        }
        return isNegative ? -1 * Integer.parseInt(stringBuilder.toString()) : Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        int[] numberInput = {1, 12, 123, 1234, -12345, 123456, 1234567, 12345678, 123456789};
        for (int i : numberInput) {
            System.out.println("check : " + i + " " + reverseNumber(i));
        }
    }

}
