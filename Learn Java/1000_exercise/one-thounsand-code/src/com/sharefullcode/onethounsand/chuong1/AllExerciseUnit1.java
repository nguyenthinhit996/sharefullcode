package com.sharefullcode.onethounsand.chuong1;

/**
 * Lưu Đồ Thuật Toán
 */
public class AllExerciseUnit1 {

    //Bài 1: Tính S(n) = 1 + 2 + 3 + …n.
    public int Bai01(int n) {
        int sum = 0;
        for (int index = 1; index <= n; index++) {
            sum += index;
        }
        return sum;
    }


    public static void main(String[] args) {

    }
}
