package program.bacsic;

/**
 * range ASC2 O to 255 and view by char data type
 */
public class PrintASC2 {

    public static void main(String[] args) {
        for (int i = 0; i <= 255; i++) {
            System.out.println("char :"+ (char)i + ": " + i);
        }
    }
}
