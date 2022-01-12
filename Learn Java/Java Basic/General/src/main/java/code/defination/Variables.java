package code.defination;

/**
 * Three Type variable
 * + one in level lowest: local variable use in scope method. it will override value variable
 * outside if same name variable.
 * + Two in level class: instance variable use specific instance declared not shared value variable
 * among between instances
 * + Three in level class: static variable use in class and it use only one memory and
 * use to shared value for the instances.
 */
public class Variables {

    Integer instanceVariable = 0;
    static Integer staticVariable = 0;
    void method() {
        Integer localVariable = 222;
        // still declared and override value outside
        Integer instanceVariable = 999;
        staticVariable= 3333;
        System.out.println(localVariable); // 222
        System.out.println(instanceVariable); // 999
    }

    public static void main(String[] args) {
        Variables a = new Variables();
        a.method();
        System.out.println(staticVariable); // 333
    }
}
