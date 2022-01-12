package program.numbers;

/**
 * 54,297 then the output should be Fifty-Four Thousand Two Hundred Ninety-Seven
 */
public class NumberToWord {

    static String[] init = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine"};
    static String[] dezon = {"Ten", "eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
    static String[] dezon2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};
    static String hunreadStr = " hundred";
    static String thousandStr = " thousand";
    static String millionStr = " million";

    static String getByNumber(int number) {
        if (number >= 0 && number <= 9) {
            return getInit(number);
        } else if (number >= 10 && number <= 99) {
            return getDozon(number);
        } else {
            return getHunread(number);
        }
    }

    static String getInit(int input) {
        if (input >= 0 && input <= 9) {
            return init[input];
        }
        return "?";
    }

    static String getDozon(int input) {
        if (input >= 10 && input <= 19) {
            return dezon[input - 10];
        }
        if (input >= 20 && input <= 99) {
            if (input % 10 == 0) {
                return dezon2[input / 10];
            } else {
                String dozon = dezon2[input / 10];
                int numberInit = input % 10;
                String unit = init[numberInit];
                return dozon + "-" + unit;
            }
        }
        return "?";
    }

    static String getHunread(int input) {
        if (input % 100 == 0) {
            return init[input / 100] + " " + hunreadStr;
        } else {
            String hunread = init[input / 100];
            int dozenNumber = input % 100;
            String donzen = getDozon(dozenNumber);
            return hunread + hunreadStr + " " + donzen;
        }
    }

    static String getThousand(int input) {
        if (input % 1000 == 0) {
            return init[input / 1000] + " " + thousandStr;
        } else {
            int thousandNumber = input / 1000;
            String thousand = getByNumber(thousandNumber);
            int hundredNumber = input % 1000;
            String hundred = getHunread(hundredNumber);
            return thousand + thousandStr + " " + hundred;
        }
    }

    static String getMillion(int input) {
        if (input % 1000000 == 0) {
            return init[input / 1000000] + " " + millionStr;
        } else {
            int millionNumber = input / 1000000;
            String million = getByNumber(millionNumber);
            int thousandNumber = input % 1000000;
            String thousand = getThousand(thousandNumber);
            return million + millionStr + " " + thousand;
        }
    }

    public static void main(String[] args) {
        int[] numberInput = {1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789};
        String out = "";
        for (int i : numberInput) {
            if (i >= 0 && i <= 9) {
                out = getInit(i);
            } else if (i >= 10 && i <= 99) {
                out = getDozon(i);
            } else if (i >= 100 && i <= 999) {
                out = getHunread(i);
            } else if (i >= 1000 && i <= 999999) {
                out = getThousand(i);
            } else if (i > 1000000 && i < 999999999) {
                out = getMillion(i);
            } else {
                out = "out of range";
            }
            System.out.println(i + " " + out);
        }
    }
}
