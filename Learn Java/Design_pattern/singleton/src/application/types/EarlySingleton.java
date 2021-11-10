package application.types;

/**
 * Instance will create when class is load by runtime
 */
public class EarlySingleton {
    private static EarlySingleton earlySingleton = new EarlySingleton();

    private EarlySingleton(){
    }

    public static EarlySingleton getInstance(){
        return earlySingleton;
    }

    public static void methodDoSomeThing(){

    }
}
