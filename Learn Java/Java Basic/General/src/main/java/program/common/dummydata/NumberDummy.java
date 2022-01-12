package program.common.dummydata;

import program.common.ConfigCommon;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NumberDummy {

    private static Random random = new Random();

    public static Integer [] intArrays(){
        int N = ConfigCommon.getNumberOfArray();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static Integer [] intArrays(int N){
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static Integer [] intArrays(int N, int min, int max){
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(min, max);
        }
        return array;
    }

    public static Integer [] intArrays(int min, int max){
        int N = ConfigCommon.getNumberOfArray();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(min, max);
        }
        return array;
    }

    public static Float [] floatArrays(){
        int N = ConfigCommon.getNumberOfArray();
        Float[] array = new Float[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    public static Boolean [] booleanArrays(){
        int N = ConfigCommon.getNumberOfArray();
        Boolean[] array = new Boolean[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextBoolean();
        }
        return array;
    }

    public static void main(String[] args) {
        Arrays.stream(intArrays()).forEach(System.out::println);
    }
}
