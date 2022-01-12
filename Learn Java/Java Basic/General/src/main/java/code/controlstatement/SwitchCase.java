package code.controlstatement;

/**
 * switch (value)
 * case value : code ; break ;
 * case ....
 * default: code ;
 * break is optional if you don't break it will execute all case below it
 */
public class SwitchCase {

    void switchNotBreak() {
        int inputSwitch = 10;
        switch (inputSwitch) {
            case 1 : System.out.println("case 1"); // not appear
            case 10 : System.out.println("case 10"); // case 10
            case 100 : System.out.println("case 100"); // case 100
            default:  System.out.println("default default"); // default default
        }
    }

    void switchWithBreak() {
        int inputSwitch = 10;
        switch (inputSwitch) {
            case 1 : System.out.println("case 1"); break; // not appear
            case 10 : System.out.println("case 10"); break;// not appear
            case 100 : System.out.println("case 100"); break; // case 100
            default:  System.out.println("default default"); // not appear
        }
    }

    public static void main(String[] args) {
        SwitchCase switchCase = new SwitchCase();
        switchCase.switchNotBreak();
        switchCase.switchWithBreak();
    }
}
