package program.bacsic;

/**
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 */
public class FibonacciSeries {

    void calculatedFibonacci(int n) {
        int k1 = 0, k2 = 1, k3 = 1;
        if (n == 0) {
            System.out.println(0);
        }
        if (n >= 1) {
            System.out.print(k1 + " " + k2 + " ");
        }
        for (int i = 2; i < n; i++) {
            k3 = k1 + k2;
            System.out.print(k3 + " ");
            k1 = k2;
            k2 = k3;
        }
    }

    void recursionFibonacci(int n){
        if (n == 0) {
            System.out.println(0);
        }
        if (n >= 1) {
            System.out.print("0 1 ");
        }
        recursionCalculatedFibonacci(2, n, 0, 1);
    }

    void recursionCalculatedFibonacci(int i, int n, int k1, int k2) {
        if(i == n){
            return ;
        }else {
            int k3 = k1 + k2;
            System.out.print(k3 + " ");
            k1 = k2;
            k2 = k3;
            recursionCalculatedFibonacci(++i, n, k1, k2);
        }
    }

    public static void main(String[] args) {
        FibonacciSeries fan = new FibonacciSeries();
        fan.calculatedFibonacci(10);
        System.out.println();
        fan.recursionFibonacci(10);
    }
}
