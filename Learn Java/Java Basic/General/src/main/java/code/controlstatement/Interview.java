package code.controlstatement;

import java.util.ArrayList;
import java.util.List;

public class Interview {

    static int findIndex(String word, String phrase) {
        if (null == phrase || null == word) {
            return -1;
        }
        String upperCaseWord = word.toUpperCase();
        String upperCasePhrase = phrase.toUpperCase();
        return upperCasePhrase.indexOf(upperCaseWord);
    }

    static void caluculator() {
        int today = 1;
        List<Integer> dayOff = new ArrayList<>();
        int check2 = 2;
        int check3 = 2;
        for (int i = 2; i <= 100; i++, check2++, check3++) {
            if (today == 0) {
                today = 1;
            } else {
                today = 0;
            }
            if (check2 == 2) {
                if (today == 1) {
                    today = 0;
                } else {
                    today = 1;
                }
                check2 = 0;
            }
            if (check3 == 3) {
                if (today == 1) {
                    today = 0;
                } else {
                    today = 1;
                }
                check3=0;
            }
            if (today == 0) {
                dayOff.add(i);
            }
        }
        for(Integer ww : dayOff){
            System.out.println(ww);
        }
    }

    public static void main(String[] args) {
        caluculator();
    }
}


