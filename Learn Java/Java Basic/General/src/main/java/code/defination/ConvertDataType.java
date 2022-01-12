package code.defination;


/**
 * We can convert from low to high value and reverse
 * float and double -> number integer = only positive integer part
 * integer -> float or double = positive integer part (.0)
 * if over range the value incorrect converted.
 */
public class ConvertDataType {

    /**
     * byte, short, integer, float, double.
     */
    void numberConvert(){

        int integerVariable = 10;
        float floatVariable = 10f;
        long longVariable = 10l;
        short shortVariable = 10;

        //convert in to range
        floatVariable = (float) integerVariable;
        System.out.println(floatVariable);

        shortVariable = (short) integerVariable;
        System.out.println(shortVariable);

        floatVariable = 123.923f;
        System.out.println((int) floatVariable);

        //convert over max range
        longVariable = 99999999999999l;
        shortVariable = (short) longVariable;
        System.out.println(shortVariable); // pass incorrect value.
    }

    public static void main(String[] args) {

        ConvertDataType type = new ConvertDataType();
        type.numberConvert();

    }

}
