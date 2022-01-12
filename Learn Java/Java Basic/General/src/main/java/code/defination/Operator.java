package code.defination;

/**
 * 1) Unary toán tử 1 ngôi
 * postfix: expr++ expr--  | in fact plus ans subtract was action after that.
 * prefix: ++expr --expr +expr -expr ~(flip bit) !(apply for boolean type) | action here.
 *
 * 2) Arithmetic số học : * (nhân) /(chia hết) %(chia lấy dư)  + -
 *
 * 3) Shift:
 *      << (value * (2 ^ shift))
 *      >> (value / (2 ^ shift))
 *      >>> (full zero)
 *
 * 4) Relational:
 *     comparison: < > <= >= instanceof
 *     equality: == !=
 *
 * 5) Bitwise
 *     bitwise AND & : always check all condition, dont care the condition first true or flase.
 *     bitwise exclusive OR ^ :
 *     bitwise inclusive OR | : always check all condition, dont care the condition first true or flase.
 *
 * 6) Logical Operator:
 *      logical AND && only run the second condition when the first is true. (all true => true)
 *      logical OR || only run the second condition when the first false (only need 1 true)
 *
 * 7) Ternary: toán tử 3 ngôi
 * 8) Assignment: = += -= *= /= %= &= ^= |= <<= >>= >>>=
 */
public class Operator {

    private Integer valueA = 10;
    private Integer valueB = 10;

    void reset() {
        valueA = 10;
        valueB = 10;
    }

    /**
     * expr++ expr--
     * ++expr --expr +expr -expr ~(flip bit) !(apply for boolean type)
     */
    void unaryOperator() {
        //expr++ expr--
        System.out.println(valueA ++); // 10 after that 11
        System.out.println(valueB --); // 10 after that 9
        System.out.println(valueA); //11
        System.out.println(valueB); //9

        reset();
        System.out.println(++ valueA); // 11
        System.out.println(-- valueB); // 9
        System.out.println(valueA); //11
        System.out.println(valueB); //9

        reset();
        System.out.println(+ valueA); // 10
        System.out.println(- valueB); // -10
        System.out.println(valueA); //10
        System.out.println(valueB); //10

        reset();
        valueB = -10;
        System.out.println(~ valueA); // -11
        System.out.println(~ valueB); // 9
        System.out.println(valueA); //10
        System.out.println(valueB); //10
    }


    /**
     * Arithmetic: * / %  + -
     */
    void arithmetic() {
        reset();
        System.out.println(valueA * valueB); // 100
        reset();
        System.out.println(valueA / valueB); // 1
        reset();
        valueB = 7;
        System.out.println(valueA % valueB); // 3
        reset();
        System.out.println(valueA + valueB); // 20
        reset();
        System.out.println(valueA - valueB); // 0
    }

    /**
     * Shift Operator: <<, >>, >>>
     *     << = value * (2 mũ số shift)
     *     >> = value / (2 mũ số shift)
     *     >>> trường hợp value dương giống với >>
     *     >>> trường hợp value âm dịch bit:
     *     get Binary signed 2's complement value thêm đủ 32 bit và sau đó dịch 1 bit
     *     nhớ là bit thêm vào đầu luôn là số 1
     */
    void shiftOperator() {
        // 10 = 1010
        reset();
        System.out.println(valueA >> 2); // 10 / (2^2) = 10 / 4 = 2
        System.out.println(valueA << 2); // 10 * (2^2) = 10 * 4 = 2
        System.out.println(-valueA >>> 1); // 2147483643
        // get get Binary signed 2's complement -10 = 1111111111110110
        // push đủ 32 bit : 1111111111111111111111111110110
        // dịch 1 bit sang phải: 1111111111111111111111111111011 = 2147483643
    }

    /**
     *     comparison: < > <= >= instanceof
     *     equality: == !=
     */
    void relational() {
        reset();
        String str = "str";
        InstanceClass object = null;
        InstanceClass object2 = new InstanceClass();
        System.out.println(str instanceof String); // always return true
        System.out.println(object instanceof InstanceClass); // always return false
        System.out.println(object2 instanceof InstanceClass); // return true
    }

    /**
     * Bitwise
     *  & : true & true => true , còn lại ra false
     *  ^ : giống ra false , khác nhau ra true
     *  | : có true thì tất cả ra true.
     */
    void bitwise(){
        reset();
        valueA = 9 ; // 1001
        valueB = 10; // 1010
        System.out.println(valueA & valueB); // 1000 = 8
        System.out.println(valueA ^ valueB); // 0011 = 3
        System.out.println(valueA | valueB); // 1011 = 11

        // set condition
        reset();
        if(++valueA == 12 & valueB++ == 10){ // false
            System.out.println("Do not appear");
        }
        //still update value of valueB
        System.out.println(valueA); //11
        System.out.println(valueB); //11
    }

    /**
     * Logical
     *  logical AND && : all true => true
     *  logical OR || : only one condition true => true
     *  | : có true thì tất cả ra true.
     */
    void logical(){
        reset();
        if(++valueA == 12 && valueB++ == 10){ // false
            System.out.println("Do not appear");
        }
        //NOT update value of valueB
        System.out.println(valueA); //11
        System.out.println(valueB); //10
    }

    /**
     * Assignment
     * = += -= *= /= %= &= ^= |= <<= >>= >>>=
     */
    void assignment(){
        reset();
        System.out.println(valueA += 10); // valueA = valueA + 10 = 20
        reset();
        System.out.println(valueA -= 5); // valueA = valueA - 5 = 5
        reset();
        System.out.println(valueA *= 10); // valueA = valueA * 10 = 100
        reset();
        System.out.println(valueA /= 10); // valueA = valueA / 10 = 1
        reset();
        System.out.println(valueA %= 7); // valueA = valueA % 7 = 3
        reset();
        // các phép tính khác tương tự  value ? = xx   <=>  value = value ? xxx
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.unaryOperator();
        operator.arithmetic();
        operator.shiftOperator();
        operator.bitwise();
        operator.logical();
        operator.assignment();

    }
}

class InstanceClass {

}
