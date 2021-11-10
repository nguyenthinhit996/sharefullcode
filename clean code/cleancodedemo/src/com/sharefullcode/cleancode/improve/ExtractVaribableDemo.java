package com.sharefullcode.cleancode.improve;

public class ExtractVaribableDemo {

    public static void main(String[] args) {
        int widthSize = 50;
        int heightSize = 100;

        // bad
        if((widthSize + 10 - 8 * 8 / heightSize) == 90){
            // do something
        }else {
            // do something
        }

        // good
        int i = widthSize + 10 - 8 * 8 / heightSize;
        if(i == 90){
            // do something
        }else {
            // do something
        }
    }
}
