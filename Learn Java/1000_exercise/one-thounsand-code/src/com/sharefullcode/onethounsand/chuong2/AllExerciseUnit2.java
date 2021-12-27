package com.sharefullcode.onethounsand.chuong2;

import com.sharefullcode.onethounsand.common.Utilize;

import java.util.ArrayList;
import java.util.List;

/**
 * Lập trình với ngôn ngữ Java
 */
public class AllExerciseUnit2 {

    //Bài 77: Viết Chương Trình tính tổng của dãy số sau: S(n) = 1 +2 +3+ … + n.
    public int Bai77(int n) {
        int sum = 0;
        for (int index = 1; index <= n; index++) {
            sum += index;
        }
        return sum;
    }

    //Bài 78: Liệt kê tất cả các ước số của số nguyên dương N.
    //là tất cả các số được N chia hết.
    public void Bai78(int n) {
        List<Integer> numbersUocSo = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                numbersUocSo.add(i);
            }
        }
        System.out.println("Các ước số của số nguyên dương: "+ n);
        Utilize.outputConsole(numbersUocSo);
    }
}
