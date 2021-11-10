package application.types;


/**
 * when use it create instance
  */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton(){
    }

    // not optimize because always synchronized when called function
    public static synchronized LazySingleton getInstanceNotOptimize(){
        if(lazySingleton != null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    //version optimize because it synchronized when create instance, get instance not sychronized
    public static LazySingleton getLazyInstanceOptimizePerfomace(){
        if(lazySingleton == null){
            synchronized(LazySingleton.class){
                // ensure check again
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void methodDoSomeThing(){

    }
}
