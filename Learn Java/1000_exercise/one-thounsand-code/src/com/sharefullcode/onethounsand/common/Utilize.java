package com.sharefullcode.onethounsand.common;

import java.util.List;
import java.util.StringJoiner;

public class Utilize {

    public static <T> void outputConsole(List<T> list) {
        StringJoiner stringJoiner = new StringJoiner(",");
        if (list != null && list.size() > 1) {
            for (T in : list) {
                stringJoiner.add(in.toString());
            }
        }
        System.out.println(stringJoiner);
    }

    public static void runAll() {

    }

}
