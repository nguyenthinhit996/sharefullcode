package application;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1 use logger
 * 2 use class configuration example spring framework
 * 3 share resource example get serial port for multiple thread
 * 4 fatory pattern implement singleTon, is researching
 */
public class DemoSingleton {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        DemoThread a = new DemoThread("thread 1");
        DemoThread a2 = new DemoThread("thread 2");

        executor.submit(a);
        executor.submit(a2);

        System.out.println();
        executor.shutdown();
    }

}

class DemoThread extends  Thread {

    int stop1=50;
    String a;

    DemoThread(String name){
        a= name;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(stop1 == 0){
                    break;
                }
                stop1--;
                System.out.println(a +" " + ManagerPort.getInstance().getPort());
                ManagerPort.getInstance().updatePortSerial();
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// serial port
class ManagerPort {

    private static ManagerPort managerPort;

    private Integer port = 0;

    private ManagerPort(){
    }

    public static ManagerPort getInstance() {
        if(managerPort == null){
            synchronized (ManagerPort.class){
                if (managerPort == null) {
                    managerPort = new ManagerPort();
                }
            }
        }
        return managerPort;
    }

    public Integer getPort() {
        return port;
    }

    public void updatePortSerial() {
        this.port ++;
    }
}