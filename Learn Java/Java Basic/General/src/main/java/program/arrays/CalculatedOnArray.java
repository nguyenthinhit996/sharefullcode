package program.arrays;

import program.common.ConfigCommon;
import program.common.dummydata.NumberDummy;

/**
 * Min, max, print even, odd, print reserve order.
 * Sum, sort asc - desc,
 * find the third largest, find the second smallest
 */
public class CalculatedOnArray {

    static int findMin(Integer[] array) {
        //check lenght array > 0
            // bien = array1
            // for start - end
                //if bien < array[i] => swap
            //return bien
        //return -1

        if(array != null && array.length > 0){
            int min = array[0];
            for(int i=0; i< array.length; i++){
                if(min > array[i]){
                    min = array[i];
                }
            }
            return min;
        }else {
            return -1;
        }
    }

    static int findMinSecond(Integer[] array) {
        //if array != null && arrya lenght > 0
            // create 2 variable min1 and min2
            // for start end
                // if min 1 > array[i]
                        //min2 = min1;
                        //min1 = array[i]
            // return min2;
        //else return -1;

        if (array != null && array.length > 0) {
            int min1 = Integer.MAX_VALUE , min2 = min1;
            for (int i = 0; i < array.length; i++) {
                if (min1 > array[i]) {
                    min2 = min1;
                    min1 = array[i];
                } else if (min2 > array[i] && array[i] != min1){ //{1,2,3,5,6,4,3,2}; FIXED THIS CASE
                    min2 = array[i];
                }
            }
            return min2;
        } else {
            return -1;
        }
    }

    static int findMinThird(Integer[] array) {
         // array != null && lenght array > 0
            // m1, m2, m3 = max.Int
            // for start to end
                // if m1 > arr[i]
                    // m3 = m2;
                    // m2 = m1;
                    // m1 = arr[i]
                // else if m2 > arr[i] && ar[i] != m1
                    // m3 = m2;
                    // m2 = arr[i]
                // else if m3 > arr[i] && arr[i] != m2 && arr[i] != m2
                    //m3 = arr[i];
            // return m3
        // return -1

        if (array != null && array.length > 0) {
            int min1 = Integer.MAX_VALUE , min2 = min1, min3 = min1;
            for (int i = 0; i < array.length; i++) {
                if (min1 > array[i]) {
                    min3 = min2;
                    min2 = min1;
                    min1 = array[i];
                } else if (min2 > array[i] && array[i] != min1){ //{1,2,3,5,6,4,3,2}; FIXED THIS CASE
                    min3 = min2;
                    min2 = array[i];
                } else if (min3 > array[i] && array[i] != min1 && array[i] != min2) { //{1,2,3,5,6,4,3,2}; FIXED THIS CASE
                    min3 = array[i];
                }
            }
            return min3;
        } else {
            return -1;
        }
    }

    static int findMax(Integer[] array) {
        // if array not null and length > 0
            // create variable max = array[i];
            // for start to end
                // if max < array [i]
                // max = array [i]
        // else return -1
        if (array != null && array.length > 0) {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if(max < array[i]){
                    max = array[i];
                }
            }
            return max;
        }else {
            return -1;
        }
    }

    static int findMaxSecond(Integer[] array) {
        // if array not null and length array
            // create variable max1, max2
            // for start to end
                // if max1 < array[i]
                    // max1 = array[i]
                // else if max2 < array[i]  && array[i] != max1
                    // max2 = array[i]
        // else return -1

        if (array != null && array.length > 0) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; i++) {
                if(max1 < array[i]){
                    max2 = max1;
                    max1 = array[i];
                } else if (max2 < array[i] && array[i] != max1) {
                    max2 = array[i];
                }
            }
            return max2;
        }else {
            return -1;
        }
    }

    static void printEven(Integer[] array) {

    }

    static void printOdd(Integer[] array) {

    }

    static int [] printReserveOrder(Integer[] array) {
        return null;
    }

    static int sum(Integer[] array) {
        return 0;
    }

    static int sort(Integer[] array, boolean asc) {
        return 0;
    }
}
