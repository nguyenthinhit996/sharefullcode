package program.common;

import program.common.dummydata.CharacterDummy;

import java.util.Arrays;

public class ConfigCommon {

    public static int getNumberOfArray(){
        return (int) (Math.random() * (100 - 5 + 1) + 5);
    }

    public static <T> void printArray( T [] array){
        if(array !=  null && array.length > 0){
            Arrays.stream(array).forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Arrays.stream(CharacterDummy.strArrayCity()).forEach(System.out::println);
    }
}
